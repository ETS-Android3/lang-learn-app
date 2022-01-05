package com.example.testapp.HomeOptions.Hiragana;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.Data.CharactersTest;
import com.example.testapp.Data.DataTest;
import com.example.testapp.Data.Initiate;
import com.example.testapp.R;
import com.example.testapp.test.CharTest.HiraTest;

import java.util.Objects;


public class HiraganaTestOp extends AppCompatActivity {
    public static CharactersTest c = new CharactersTest();
    public static CharactersTest[] a = DataTest.getA();
    public static CharactersTest[] k = DataTest.getK();
    public static CharactersTest[] h = DataTest.getH();
    public static CharactersTest[] m = DataTest.getM();
    public static CharactersTest[] n = DataTest.getN();
    public static CharactersTest[] r = DataTest.getR();
    public static CharactersTest[] s = DataTest.getS();
    public static CharactersTest[] t = DataTest.getT();
    public static CharactersTest[] yw = DataTest.getYW();
    public static CharactersTest[] g = DataTest.getG();
    public static CharactersTest[] z = DataTest.getZ();
    public static CharactersTest[] d = DataTest.getD();
    public static CharactersTest[] b = DataTest.getB();
    public static CharactersTest[] p = DataTest.getP();

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setToFalse();

        Button abutton = findViewById(R.id.abutton);
        abutton.setOnClickListener(view -> {
            Initiate.aT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button kbutton = findViewById(R.id.kbutton);
        kbutton.setOnClickListener(view -> {
            Initiate.kT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button sbutton = findViewById(R.id.sbutton);
        sbutton.setOnClickListener(view -> {
            Initiate.sT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button tbutton = findViewById(R.id.tbutton);
        tbutton.setOnClickListener(view -> {
            Initiate.tT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button nbutton = findViewById(R.id.nbutton);
        nbutton.setOnClickListener(view -> {
            Initiate.nT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button hbutton = findViewById(R.id.hbutton);
        hbutton.setOnClickListener(view -> {
            Initiate.hT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button mbutton = findViewById(R.id.mbutton);
        mbutton.setOnClickListener(view -> {
            Initiate.mT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button ywbutton = findViewById(R.id.ywbutton);
        ywbutton.setOnClickListener(view -> {
            Initiate.ywT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button rbutton = findViewById(R.id.rbutton);
        rbutton.setOnClickListener(view -> {
            Initiate.rT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button gbutton = findViewById(R.id.gbutton);
        gbutton.setOnClickListener(view -> {
            Initiate.gT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button zbutton = findViewById(R.id.zbutton);
        zbutton.setOnClickListener(view -> {
            Initiate.zT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button dbutton = findViewById(R.id.dbutton);
        dbutton.setOnClickListener(view -> {
            Initiate.dT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button bbutton = findViewById(R.id.bbutton);
        bbutton.setOnClickListener(view -> {
            Initiate.bT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
        });

        Button pbutton = findViewById(R.id.pbutton);
        pbutton.setOnClickListener(view -> {
            Initiate.pT = true;
            startActivity(new Intent(HiraganaTestOp.this, HiraTest.class));
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