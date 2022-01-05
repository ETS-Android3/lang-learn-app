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

import com.example.testapp.Data.Characters;
import com.example.testapp.Data.DataChar;
import com.example.testapp.Data.Initiate;
import com.example.testapp.R;
import com.example.testapp.ui.saved.SavedDB;
import com.example.testapp.ui.saved.SavedItem;

import java.util.ArrayList;

public class KanaFragmentH extends Fragment {

    private RecyclerView recyclerView;
    private SavedDB kanaDB;
    ArrayList<SavedItem> kanaChart = Initiate.getKanaChart();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_kana_h, container, false);

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
        for(int i = 0; i < 5; i++){
            kanaChart.add(new SavedItem(temp[i].getHiraChar(),
                    Integer.toString(temp[i].getID()), temp[i].getKataChar(),
                    temp[i].getPhonetics(),temp[i].getStatus()));
        }
        addData2(DataChar.getK());
        addData2(DataChar.getS());
        addData2(DataChar.getT());
        addData2(DataChar.getN());
        addData2(DataChar.getH());
        addData2(DataChar.getM());
        temp = DataChar.getYW();
        for(int i = 3; i <= temp.length; i++){
            if(i<5) {
                kanaChart.add(new SavedItem(temp[i].getHiraChar(),
                        Integer.toString(temp[i].getID()), temp[i].getKataChar(),
                        temp[i].getPhonetics(), temp[i].getStatus()));
            } else if(i == 5){
                kanaChart.add(new SavedItem("",
                        "0", "",
                        "", "0"));
            }else{
                kanaChart.add(new SavedItem(temp[i-1].getHiraChar(),
                        Integer.toString(temp[i-1].getID()), temp[i-1].getKataChar(),
                        temp[i-1].getPhonetics(), temp[i-1].getStatus()));
            }
        }
        addData2(DataChar.getR());
        temp = DataChar.getYW();
        kanaChart.add(new SavedItem(temp[0].getHiraChar(),
                Integer.toString(temp[0].getID()), temp[0].getKataChar(),
                temp[0].getPhonetics(), temp[0].getStatus()));
        kanaChart.add(new SavedItem("",
                "75", "",
                "", "0"));
        kanaChart.add(new SavedItem(temp[1].getHiraChar(),
                Integer.toString(temp[1].getID()), temp[1].getKataChar(),
                temp[1].getPhonetics(), temp[1].getStatus()));
        kanaChart.add(new SavedItem("",
                "76", "",
                "", "0"));
        kanaChart.add(new SavedItem(temp[2].getHiraChar(),
                Integer.toString(temp[2].getID()), temp[2].getKataChar(),
                temp[2].getPhonetics(), temp[2].getStatus()));
        addData2(DataChar.getG());
        addData2(DataChar.getZ());
        addData2(DataChar.getD());
        addData2(DataChar.getB());
        addData2(DataChar.getP());
        temp = DataChar.getA();
        kanaChart.add(new SavedItem(temp[5].getHiraChar(),
                Integer.toString(temp[5].getID()), temp[5].getKataChar(),
                temp[5].getPhonetics(), temp[5].getStatus()));
    }

    public void addData2(Characters[] temp){
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
    public void onDestroy() {

        super.onDestroy();
    }
}