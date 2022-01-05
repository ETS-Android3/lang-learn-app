package com.example.testapp.ui.kana;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.Data.Characters;
import com.example.testapp.Data.DataChar;
import com.example.testapp.Data.Initiate;
import com.example.testapp.R;
import com.example.testapp.ui.saved.SavedDB;
import com.example.testapp.ui.saved.SavedItem;

import java.util.ArrayList;

public class KanaChart1 extends Fragment {

    private SavedDB kanaDB;
    private RecyclerView recyclerView;
    private View binding;
    ArrayList<SavedItem> kanaChart = Initiate.getKanaChart();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = inflater.inflate(R.layout.fragment_kana_h, container, false);
        View root = binding;

        kanaDB = new SavedDB(getActivity());
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerKata);
        GridLayoutManager layoutManager = new GridLayoutManager(
                requireActivity().getApplicationContext(), 5);
        recyclerView.setLayoutManager(layoutManager);
        addData();
        loadData();

        return root;

    }

    public void addData(){
        Characters[] temp = DataChar.getA();
        for (Characters characters : temp) {
            kanaChart.add(new SavedItem(characters.getHiraChar(),
                    Integer.toString(characters.getID()), characters.getKataChar(),
                    characters.getPhonetics(), characters.getStatus()));
        }
    }

    public void loadData(){
        SQLiteDatabase db = kanaDB.getReadableDatabase();
        Cursor cursor = kanaDB.read_all_data("1");
        try {
            while (cursor.moveToNext()) {
                String item_hira = cursor.getString(
                        cursor.getColumnIndexOrThrow(SavedDB.ITEM_HIRA));
                String item_kata = cursor.getString(
                        cursor.getColumnIndexOrThrow(SavedDB.ITEM_KATA));
                String key_id = cursor.getString(
                        cursor.getColumnIndexOrThrow(SavedDB.KEY_ID));
                String item_pho = cursor.getString(
                        cursor.getColumnIndexOrThrow(SavedDB.ITEM_PHO));
                String status = cursor.getString(
                        cursor.getColumnIndexOrThrow(SavedDB.FAVORITE_STATUS));
                SavedItem savedItem = new SavedItem(
                        item_hira, key_id, item_kata, item_pho, status);
                kanaChart.add(savedItem);
            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }
        KanaAdapter kanaAdapter = new KanaAdapter(getContext(), kanaChart);
        recyclerView.setAdapter(kanaAdapter);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}