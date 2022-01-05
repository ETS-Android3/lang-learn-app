package com.example.testapp.ui.saved;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;

import java.util.ArrayList;

public class SavedAdapter extends RecyclerView.Adapter<SavedAdapter.ViewHolder> {

    private final Context context;
    private final ArrayList<SavedItem> savedItemList;
    private SavedDB savedDB;

    public SavedAdapter(Context context, ArrayList<SavedItem> savedItemList) {
        this.context = context;
        this.savedItemList = savedItemList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,
                parent, false);
        savedDB = new SavedDB(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SavedItem savedItem = savedItemList.get(position);

        readCursorData(savedItem,holder);

        holder.saved_char.setText(savedItemList.get(position).getItem_hira()+"");
        holder.saved_other_char.setText(savedItemList.get(position).getItem_kata()+"");
        holder.saved_pho.setText(savedItemList.get(position).getItem_pho()+"");
    }

    @Override
    public int getItemCount() {
        return savedItemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView saved_char;
        TextView saved_other_char;
        TextView saved_pho;
        ImageView saved_update;
        ImageView saved_delete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.saved_char = (TextView) itemView.findViewById(R.id.save_char);
            this.saved_other_char = (TextView) itemView.findViewById(R.id.save_other_char);
            this.saved_pho = (TextView) itemView.findViewById(R.id.save_pho);
            this.saved_update = (ImageView) itemView.findViewById(R.id.save_update);
            this.saved_delete = (ImageView) itemView.findViewById(R.id.save_delete);

            saved_delete.setOnClickListener(view -> {
                int position = getAdapterPosition();
                final SavedItem savedItem = savedItemList.get(position);
                savedItem.setFavStatus("0");
                savedDB.remove_saved(savedItem.getKey_id());
                removeItem(position);
            });
        }
    }
    private void readCursorData(SavedItem savedItem, ViewHolder viewHolder) {
        Cursor cursor = savedDB.read_all_data(savedItem.getKey_id());
        SQLiteDatabase db = savedDB.getReadableDatabase();
        try {
            while (cursor.moveToNext()) {
                String item_fav_status = cursor.getString(
                        cursor.getColumnIndexOrThrow(SavedDB.FAVORITE_STATUS));
                savedItem.setFavStatus(item_fav_status);

                //check fav status
                if (item_fav_status != null && item_fav_status.equals("1")) {
                    viewHolder.saved_update.setBackgroundResource(
                            R.drawable.ic_baseline_turned_in_24);
                } else if (item_fav_status != null && item_fav_status.equals("0")) {
                    viewHolder.saved_update.setBackgroundResource(
                            R.drawable.ic_baseline_turned_in_not_24);
                }
            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }

    }
    private void removeItem(int position){
        savedItemList.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position,savedItemList.size());
    }
}
