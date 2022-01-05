package com.example.testapp.HomeOptions.Katakana;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.Data.CharactersTest;
import com.example.testapp.Data.DataTest;
import com.example.testapp.Data.Initiate;
import com.example.testapp.R;
import com.example.testapp.test.kata_test;

import java.util.Objects;


public class KatakanaTestOp extends AppCompatActivity {
    public static CharactersTest c = new CharactersTest();
    public static CharactersTest[] a = DataTest.getAKata();
    public static CharactersTest[] k = DataTest.getKKata();
    public static CharactersTest[] h = DataTest.getHKata();
    public static CharactersTest[] m = DataTest.getMKata();
    public static CharactersTest[] n = DataTest.getNKata();
    public static CharactersTest[] r = DataTest.getRKata();
    public static CharactersTest[] s = DataTest.getSKata();
    public static CharactersTest[] t = DataTest.getTKata();
    public static CharactersTest[] yw = DataTest.getYWKata();
    public static CharactersTest[] g = DataTest.getGKata();
    public static CharactersTest[] z = DataTest.getZKata();
    public static CharactersTest[] d = DataTest.getDKata();
    public static CharactersTest[] b = DataTest.getBKata();
    public static CharactersTest[] p = DataTest.getPKata();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setToFalse();

        Button abutton = findViewById(R.id.abutton);
        abutton.setOnClickListener(view -> {
            Initiate.aT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button kbutton = findViewById(R.id.kbutton);
        kbutton.setOnClickListener(view -> {
            Initiate.kT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button sbutton = findViewById(R.id.sbutton);
        sbutton.setOnClickListener(view -> {
            Initiate.sT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button tbutton = findViewById(R.id.tbutton);
        tbutton.setOnClickListener(view -> {
            Initiate.tT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button nbutton = findViewById(R.id.nbutton);
        nbutton.setOnClickListener(view -> {
            Initiate.nT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button hbutton = findViewById(R.id.hbutton);
        hbutton.setOnClickListener(view -> {
            Initiate.hT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button mbutton = findViewById(R.id.mbutton);
        mbutton.setOnClickListener(view -> {
            Initiate.mT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button ywbutton = findViewById(R.id.ywbutton);
        ywbutton.setOnClickListener(view -> {
            Initiate.ywT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button rbutton = findViewById(R.id.rbutton);
        rbutton.setOnClickListener(view -> {
            Initiate.rT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button gbutton = findViewById(R.id.gbutton);
        gbutton.setOnClickListener(view -> {
            Initiate.gT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button zbutton = findViewById(R.id.zbutton);
        zbutton.setOnClickListener(view -> {
            Initiate.zT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button dbutton = findViewById(R.id.dbutton);
        dbutton.setOnClickListener(view -> {
            Initiate.dT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button bbutton = findViewById(R.id.bbutton);
        bbutton.setOnClickListener(view -> {
            Initiate.bT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

        Button pbutton = findViewById(R.id.pbutton);
        pbutton.setOnClickListener(view -> {
            Initiate.pT = true;
            startActivity(new Intent(KatakanaTestOp.this, kata_test.class));
        });

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