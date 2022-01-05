package com.example.testapp.ui.kana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.Data.Initiate;
import com.example.testapp.R;
import com.example.testapp.ui.saved.SavedDB;
import com.example.testapp.ui.saved.SavedItem;

import java.util.ArrayList;

public class KanaFragmentK extends Fragment {

    private RecyclerView recyclerView;
    private SavedDB kanaDB;
    ArrayList<SavedItem> kanaChart = Initiate.getKanaChart();

    public KanaFragmentK() {
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_kana_h, container, false);

        kanaDB = new SavedDB(getActivity());

        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerKata);
        GridLayoutManager layoutManager = new GridLayoutManager(requireActivity().getApplicationContext(), 5);
        recyclerView.setLayoutManager(layoutManager);
        loadData();
        return root;
    }


    public void loadData(){
        SQLiteDatabase db = kanaDB.getReadableDatabase();
        Cursor cursor = kanaDB.read_all_data("1");
        try {
            while (cursor.moveToNext()) {
                String item_hira = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.ITEM_HIRA));
                String item_kata = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.ITEM_KATA));
                String key_id = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.KEY_ID));
                String item_pho = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.ITEM_PHO));
                String status = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.FAVORITE_STATUS));
                SavedItem savedItem = new SavedItem(item_hira, key_id, item_kata, item_pho, status);
                kanaChart.add(savedItem);
            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }
        KanaAdapterK kanaAdapter = new KanaAdapterK(getContext(), kanaChart);
        recyclerView.setAdapter(kanaAdapter);

    }
    public void onDestroy() {

        super.onDestroy();
    }
}