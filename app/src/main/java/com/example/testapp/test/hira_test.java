package com.example.testapp.test;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.Data.CharactersTest;
import com.example.testapp.Data.Initiate;
import com.example.testapp.HomeOptions.Hiragana.HiraganaTestOp;
import com.example.testapp.R;
import com.example.testapp.test.Pages.Correct;
import com.example.testapp.test.Pages.CorrectRecognition;
import com.example.testapp.test.Pages.Incorrect;

import java.util.Objects;

public class hira_test extends AppCompatActivity {
    CharactersTest c = HiraganaTestOp.c;
    CharactersTest[] a = HiraganaTestOp.a;
    CharactersTest[] k = HiraganaTestOp.k;
    CharactersTest[] s = HiraganaTestOp.s;
    CharactersTest[] t = HiraganaTestOp.t;
    CharactersTest[] n = HiraganaTestOp.n;
    CharactersTest[] h = HiraganaTestOp.h;
    CharactersTest[] m = HiraganaTestOp.m;
    CharactersTest[] yw = HiraganaTestOp.yw;
    CharactersTest[] r = HiraganaTestOp.r;
    CharactersTest[] g = HiraganaTestOp.g;
    CharactersTest[] z = HiraganaTestOp.z;
    CharactersTest[] d = HiraganaTestOp.d;
    CharactersTest[] b = HiraganaTestOp.b;
    CharactersTest[] p = HiraganaTestOp.p;
    private TextView character;
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hira_test);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Correct.hiraTrue = true;
        Correct.kataTrue = false;
        CorrectRecognition.hiraTrue = false;
        CorrectRecognition.kataTrue = false;

        character = findViewById(R.id.wordText);
        option1 = findViewById(R.id.option1Button);
        option2 = findViewById(R.id.option2Button);
        option3 = findViewById(R.id.option3Button);
        option4 = findViewById(R.id.option4Button);
        ProgressBar progress = findViewById(R.id.progressBar);
        int progression = ((c.getCurrentIndex() +1)*100)/15;
        if(c.getCurrentIndex() == 0){
            cardSet();
        }

        progress.setProgress(progression);
        option1.setOnClickListener(view -> {
            if(option1.getText() == c.getCt()[c.getCurrentIndex()].getAnswer()){
                //go to you are right page & correct counter++
                c.incrementCorrectCount(1);
                startActivity(new Intent(hira_test.this, Correct.class));
            } else{
                //go to incorrect page page
                startActivity(new Intent(hira_test.this, Incorrect.class));
            }
        });
        option2.setOnClickListener(view -> {
            if(option2.getText() == c.getCt()[c.getCurrentIndex()].getAnswer()){
                c.incrementCorrectCount(1);
                startActivity(new Intent(hira_test.this, Correct.class));
            } else{
                //go to false page
                startActivity(new Intent(hira_test.this, Incorrect.class));
            }
        });
        option3.setOnClickListener(view -> {
            if(option3.getText() == c.getCt()[c.getCurrentIndex()].getAnswer()){
                //go to true page
                c.incrementCorrectCount(1);
                startActivity(new Intent(hira_test.this, Correct.class));
            } else{
                //go to false page
                startActivity(new Intent(hira_test.this, Incorrect.class));
            }
        });
        option4.setOnClickListener(view -> {
            if(option4.getText() == c.getCt()[c.getCurrentIndex()].getAnswer()){
                //go to true page
                c.incrementCorrectCount(1);
                startActivity(new Intent(hira_test.this, Correct.class));
            } else{
                //go to false page
                startActivity(new Intent(hira_test.this, Incorrect.class));
            }
        });

        c.setCurrentIndex((c.getCurrentIndex()+1));
        update();

    }

    private void update(){
        character.setText(c.getCt()[c.getCurrentIndex()].getCharacter());
        int[] array = new int[]{1,2,3,4};
        for(int i = array.length - 1; i>0;i--){
            int j = (int)Math.floor(Math.random()*(i+1));
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        assign(array[0]);
    }

    private void assign(int num){
        int random1 = (int)Math.floor(Math.random()*(c.getCt().length-1));
        String temp1 = c.getCt()[random1].getAnswer();
        int random2 = (int)Math.floor(Math.random()*(c.getCt().length-1));
        String temp2 = c.getCt()[random2].getAnswer();
        int random3 = (int)Math.floor(Math.random()*(c.getCt().length-1));
        String temp3 = c.getCt()[random3].getAnswer();
        if(num == 1){
            option1.setText(c.getCt()[c.getCurrentIndex()].getAnswer());
            option2.setText(temp1);
            option3.setText(temp2);
            option4.setText(temp3);
        }else if(num == 2){
            option1.setText(temp1);
            option2.setText(c.getCt()[c.getCurrentIndex()].getAnswer());
            option3.setText(temp2);
            option4.setText(temp3);
        }else if(num == 3){
            option1.setText(temp1);
            option2.setText(temp2);
            option3.setText(c.getCt()[c.getCurrentIndex()].getAnswer());
            option4.setText(temp3);
        }else{
            option1.setText(temp1);
            option2.setText(temp2);
            option3.setText(temp3);
            option4.setText(c.getCt()[c.getCurrentIndex()].getAnswer());
        }
    }

    public void cardSet(){
        if(Initiate.aT) {
            a = c.shuffle(a);
            c.setCt(a);
        }else if(Initiate.kT){
            k = c.shuffle(k);
            c.setCt(k);
        }else if(Initiate.mT){
            m = c.shuffle(m);
            c.setCt(m);
        }else if(Initiate.hT){
            h = c.shuffle(h);
            c.setCt(h);
        }else if(Initiate.sT){
            s = c.shuffle(s);
            c.setCt(s);
        }else if(Initiate.nT){
            n = c.shuffle(n);
            c.setCt(n);
        }else if(Initiate.rT){
            r = c.shuffle(r);
            c.setCt(r);
        }else if(Initiate.tT){
            t = c.shuffle(t);
            c.setCt(t);
        }else if(Initiate.ywT){
            yw = c.shuffle(yw);
            c.setCt(yw);
        }else if(Initiate.gT){
            g = c.shuffle(g);
            c.setCt(g);
        }else if(Initiate.zT){
            z = c.shuffle(z);
            c.setCt(z);
        }else if(Initiate.dT){
            d = c.shuffle(d);
            c.setCt(d);
        }else if(Initiate.bT){
            b = c.shuffle(b);
            c.setCt(b);
        }else if(Initiate.pT) {
            p = c.shuffle(p);
            c.setCt(p);
        }
    }
    public void onDestroy() {

        super.onDestroy();
    }
}