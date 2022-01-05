package com.example.testapp.ui.kana;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.testapp.R;
import com.google.android.material.tabs.TabLayout;

public class KanaFragment extends Fragment {

    private View binding;

    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = inflater.inflate(R.layout.fragment_kana, container, false);
        View root = binding;

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tabBar);
        ViewPager2 viewPager2 = root.findViewById(R.id.viewPager2);

        TabAdapter tabAdapter = new TabAdapter(getActivity(),
                tabLayout.getTabCount());

        viewPager2.setAdapter(tabAdapter);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}