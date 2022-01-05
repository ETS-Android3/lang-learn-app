package com.example.testapp.ui.kana;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.R;
import com.example.testapp.ui.saved.SavedDB;
import com.example.testapp.ui.saved.SavedItem;

import java.util.ArrayList;

public class KanaAdapter extends RecyclerView.Adapter<KanaAdapter.ViewHolder> {

    private final Context context;
    ArrayList<SavedItem> kanaList;
    private SavedDB kanaDB;

    public KanaAdapter(Context context, ArrayList<SavedItem> kanaList) {
        this.context = context;
        this.kanaList = kanaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_first,
                parent, false);
        kanaDB = new SavedDB(context);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SavedItem savedItem = kanaList.get(position);
        readCursorData(savedItem);

        holder.topChar.setText(kanaList.get(position).getItem_hira()+"");
        holder.transChar.setText(kanaList.get(position).getItem_kata()+"");
        holder.phoChar.setText(kanaList.get(position).getItem_pho()+"");
    }

    @Override
    public int getItemCount() {
        return kanaList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView topChar;
        TextView transChar;
        TextView phoChar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.topChar = (TextView) itemView.findViewById(R.id.topChar);
            this.transChar = (TextView) itemView.findViewById(R.id.transChar);
            this.phoChar = (TextView) itemView.findViewById(R.id.phoChar);
        }
    }
    private void readCursorData(SavedItem savedItem) {
        Cursor cursor = kanaDB.read_all_data(savedItem.getKey_id());
        SQLiteDatabase db = kanaDB.getReadableDatabase();
        try {
            while (cursor.moveToNext()) {
                String item_fav_status = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.FAVORITE_STATUS));
                savedItem.setFavStatus(item_fav_status);

            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }

    }
}
