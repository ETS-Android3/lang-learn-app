package com.example.testapp.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.testapp.HomeOptions.Hiragana.HiraRecognition;
import com.example.testapp.HomeOptions.Hiragana.Hiragana;
import com.example.testapp.HomeOptions.Hiragana.HiraganaTestOp;
import com.example.testapp.HomeOptions.Katakana.KataRecognition;
import com.example.testapp.HomeOptions.Katakana.Katakana;
import com.example.testapp.HomeOptions.Katakana.KatakanaTestOp;
import com.example.testapp.R;
import com.example.testapp.databinding.FragmentHomeBinding;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);

        ImageButton hiraganaBtn = root.findViewById(R.id.hiraganaButton);
        hiraganaBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), Hiragana.class);
            startActivity(intent);
        });
        ImageButton hiraTestBtn = root.findViewById(R.id.hiraTestButton);
        hiraTestBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), HiraganaTestOp.class);
            startActivity(intent);
        });
        ImageButton hiraRecBtn = root.findViewById(R.id.hiraRecButton);
        hiraRecBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), HiraRecognition.class);
            startActivity(intent);
        });

        ImageButton katakanaBtn = root.findViewById(R.id.katakanaButton);
        katakanaBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), Katakana.class);
            startActivity(intent);
        });

        ImageButton kataTestBtn = root.findViewById(R.id.kataTestButton);
        kataTestBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), KatakanaTestOp.class);
            startActivity(intent);
        });

        ImageButton kataRecBtn = root.findViewById(R.id.kataRecButton);
        kataRecBtn.setOnClickListener(view -> {
            Intent intent = new Intent(getActivity(), KataRecognition.class);
            startActivity(intent);
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}