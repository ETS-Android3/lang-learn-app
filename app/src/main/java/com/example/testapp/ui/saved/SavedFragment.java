package com.example.testapp.ui.saved;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.Data.Initiate;
import com.example.testapp.R;
import com.example.testapp.databinding.FragmentSavedBinding;
import com.example.testapp.test.Pages.RecogStart;

import java.util.ArrayList;

public class SavedFragment extends Fragment {

    private SavedDB savedDB;
    private RecyclerView recyclerView;
    ArrayList<SavedItem> nL = Initiate.getList();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        com.example.testapp.databinding.FragmentSavedBinding binding = FragmentSavedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        if (nL == null) {
            startActivity(new Intent(getActivity(), RecogStart.class));
        }

        savedDB = new SavedDB(getActivity());
        recyclerView = (RecyclerView) root.findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);

        loadData();

        return root;
    }

    private void loadData() {
        SQLiteDatabase db = savedDB.getReadableDatabase();
        Cursor cursor = savedDB.select_all_favorite_list();
        try {
            while (cursor.moveToNext()) {
                String item_hira = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.ITEM_HIRA));
                String item_kata = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.ITEM_KATA));
                String key_id = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.KEY_ID));
                String item_pho = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.ITEM_PHO));
                String status = cursor.getString(cursor.getColumnIndexOrThrow(SavedDB.FAVORITE_STATUS));
                SavedItem savedItem = new SavedItem(item_hira, key_id, item_kata, item_pho, status);
                nL.add(savedItem);
            }
        } finally {
            if (cursor != null && cursor.isClosed())
                cursor.close();
            db.close();
        }

        SavedAdapter savedAdapter = new SavedAdapter(getActivity(), nL);

        recyclerView.setAdapter(savedAdapter);

    }

}