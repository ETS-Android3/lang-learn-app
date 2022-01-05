package com.example.testapp.test.Pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.testapp.R;


public class RecogStart extends Fragment {

    private View binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = inflater.inflate(R.layout.recog_start, container, false);
        return binding;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}