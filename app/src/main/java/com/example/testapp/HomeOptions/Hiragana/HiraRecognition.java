package com.example.testapp.HomeOptions.Hiragana;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.Data.CharactersTest;
import com.example.testapp.Data.DataRec;
import com.example.testapp.Data.Initiate;
import com.example.testapp.R;
import com.example.testapp.test.hira_rec_test;

import java.util.Objects;

public class HiraRecognition extends AppCompatActivity {
    public static CharactersTest c = new CharactersTest();
    public static CharactersTest[] h = DataRec.getHira();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recog_start);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setToFalse();

        Button start_button = findViewById(R.id.start_button);
        start_button.setOnClickListener(view -> startActivity(
                new Intent(HiraRecognition.this, hira_rec_test.class)));


    }

    public void setToFalse(){
        Initiate.aT = false;
        Initiate.hT = false;
        Initiate.kT = false;
        Initiate.mT = false;
        Initiate.sT = false;
        Initiate.nT = false;
        Initiate.rT = false;
        Initiate.tT = false;
        Initiate.ywT = false;
        Initiate.gT = false;
        Initiate.zT = false;
        Initiate.dT = false;
        Initiate.bT = false;
        Initiate.pT = false;
        c.setCurrentIndex(0);
        c.setCorrectCount(0);
    }
    public void onDestroy() {

        super.onDestroy();
    }
}