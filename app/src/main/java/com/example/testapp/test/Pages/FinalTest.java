package com.example.testapp.test.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.Data.CharactersTest;
import com.example.testapp.HomeOptions.Hiragana.HiraRecognition;
import com.example.testapp.HomeOptions.Hiragana.HiraganaTestOp;
import com.example.testapp.HomeOptions.Katakana.KataRecognition;
import com.example.testapp.HomeOptions.Katakana.KatakanaTestOp;
import com.example.testapp.MainActivity;
import com.example.testapp.R;

import java.util.Objects;

public class FinalTest extends AppCompatActivity {
    CharactersTest c = HiraganaTestOp.c;
    CharactersTest k = KatakanaTestOp.c;
    CharactersTest h = HiraRecognition.c;
    CharactersTest r = KataRecognition.c;
    Button home;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_test);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        TextView grade = findViewById(R.id.gradeText);
        TextView outof = findViewById(R.id.outofText);
        home = findViewById(R.id.homeButton);
        int value;
        if(Correct.hiraTrue) {
            value = c.getCorrectCount();
        }else if(Correct.kataTrue){
            value = k.getCorrectCount();
        }else if(CorrectRecognition.hiraTrue){
            value = h.getCorrectCount();
        }else{
            value = r.getCorrectCount();
        }

        grade.setText(String.valueOf((value * 100) / 15));
        outof.setText("You got " + value + " out of 15 correct!");
        home.setOnClickListener(view -> startActivity(
                new Intent(FinalTest.this, MainActivity.class)));

    }
    public void onDestroy() {

        super.onDestroy();
    }
}