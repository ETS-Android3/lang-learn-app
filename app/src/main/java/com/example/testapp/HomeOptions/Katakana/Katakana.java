package com.example.testapp.HomeOptions.Katakana;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.Data.Characters;
import com.example.testapp.Data.DataChar;
import com.example.testapp.Data.Initiate;
import com.example.testapp.R;
import com.example.testapp.flash.kata_flash;

import java.util.Objects;

public class Katakana extends AppCompatActivity {
    public static Characters c = new Characters();
    public static Characters[] a = DataChar.getA();
    public static Characters[] k = DataChar.getK();
    public static Characters[] h = DataChar.getH();
    public static Characters[] m = DataChar.getM();
    public static Characters[] n = DataChar.getN();
    public static Characters[] r = DataChar.getR();
    public static Characters[] s = DataChar.getS();
    public static Characters[] t = DataChar.getT();
    public static Characters[] yw = DataChar.getYW();
    public static Characters[] g = DataChar.getG();
    public static Characters[] z = DataChar.getZ();
    public static Characters[] d = DataChar.getD();
    public static Characters[] b = DataChar.getB();
    public static Characters[] p = DataChar.getP();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setToFalse();

        Button abutton = findViewById(R.id.abutton);
        abutton.setOnClickListener(view -> {
            Initiate.aT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button kbutton = findViewById(R.id.kbutton);
        kbutton.setOnClickListener(view -> {
            Initiate.kT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button sbutton = findViewById(R.id.sbutton);
        sbutton.setOnClickListener(view -> {
            Initiate.sT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button tbutton = findViewById(R.id.tbutton);
        tbutton.setOnClickListener(view -> {
            Initiate.tT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button nbutton = findViewById(R.id.nbutton);
        nbutton.setOnClickListener(view -> {
            Initiate.nT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button hbutton = findViewById(R.id.hbutton);
        hbutton.setOnClickListener(view -> {
            Initiate.hT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button mbutton = findViewById(R.id.mbutton);
        mbutton.setOnClickListener(view -> {
            Initiate.mT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button ywbutton = findViewById(R.id.ywbutton);
        ywbutton.setOnClickListener(view -> {
            Initiate.ywT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button rbutton = findViewById(R.id.rbutton);
        rbutton.setOnClickListener(view -> {
            Initiate.rT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });
        Button gbutton = findViewById(R.id.gbutton);
        gbutton.setOnClickListener(view -> {
            Initiate.gT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button zbutton = findViewById(R.id.zbutton);
        zbutton.setOnClickListener(view -> {
            Initiate.zT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button dbutton = findViewById(R.id.dbutton);
        dbutton.setOnClickListener(view -> {
            Initiate.dT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button bbutton = findViewById(R.id.bbutton);
        bbutton.setOnClickListener(view -> {
            Initiate.bT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

        Button pbutton = findViewById(R.id.pbutton);
        pbutton.setOnClickListener(view -> {
            Initiate.pT = true;
            startActivity(new Intent(Katakana.this, kata_flash.class));
        });

    }

    public void setToFalse() {
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
        Initiate.first = true;
        c.setCurrentIndex(0);
    }
    public void onDestroy() {

        super.onDestroy();
    }
}