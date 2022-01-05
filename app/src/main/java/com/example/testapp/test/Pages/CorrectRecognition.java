package com.example.testapp.test.Pages;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testapp.Data.CharactersTest;
import com.example.testapp.HomeOptions.Hiragana.HiraRecognition;
import com.example.testapp.HomeOptions.Katakana.KataRecognition;
import com.example.testapp.R;
import com.example.testapp.test.hira_rec_test;
import com.example.testapp.test.kata_rec_test;

import java.util.Locale;

public class CorrectRecognition extends AppCompatActivity {
    CharactersTest c = HiraRecognition.c;
    CharactersTest k = KataRecognition.c;
    private TextView fin;
    private TextView nonReading;
    private TextView phonetic;
    private TextView definition;
    private TextToSpeech tts;
    public static boolean hiraTrue = false;
    public static boolean kataTrue = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_correct);

        fin = findViewById(R.id.finText1);
        nonReading = findViewById(R.id.nonReadingText1);
        phonetic = findViewById(R.id.phoneText1);
        definition = findViewById(R.id.definitionText1);
        Button next = findViewById(R.id.nextButton);
        setChar();
        ImageButton sound = findViewById(R.id.soundButton);
        tts = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result;
                if (tts.isLanguageAvailable(Locale.JAPANESE) < 0) {
                    result = tts.setVoice(tts.getVoice());
                }else {
                    result = tts.setLanguage(Locale.JAPANESE);
                }
                tts.setSpeechRate(0.5f);
                if (result == TextToSpeech.LANG_MISSING_DATA
                        || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Toast.makeText(getApplicationContext(),
                            "Language not supported", Toast.LENGTH_SHORT).show();
                } else {
                    sound.setEnabled(true);
                }
            } else {
                Toast.makeText(getApplicationContext(),
                        "TTS Initialization failed!", Toast.LENGTH_SHORT).show();
            }
        });
        sound.setOnClickListener(view -> speak());
        next.setOnClickListener(view -> {
            if(hiraTrue){
                if(c.getCurrentIndex() == 15){
                    //go to final page
                    startActivity(new Intent(
                            CorrectRecognition.this, FinalTest.class));
                }else{
                    startActivity(new Intent(
                            CorrectRecognition.this, hira_rec_test.class));
                }
            }else{
                if(k.getCurrentIndex() == 15){
                    //go to final page
                    startActivity(new Intent(
                            CorrectRecognition.this, FinalTest.class));
                }else{
                    startActivity(new Intent(
                            CorrectRecognition.this, kata_rec_test.class));
                }
            }
        });
    }

    public void setChar(){
        if(hiraTrue) {
            fin.setText(c.getCt()[c.getCurrentIndex()].getCharacter());
            phonetic.setText(c.getCt()[c.getCurrentIndex()].getAnswer());
            nonReading.setText(c.getCt()[c.getCurrentIndex()].getReading());
            definition.setText("Definition: " + c.getCt()[c.getCurrentIndex()].getDefinition());
        }else{
            fin.setText(k.getCt()[k.getCurrentIndex()].getCharacter());
            phonetic.setText(k.getCt()[k.getCurrentIndex()].getAnswer());
            nonReading.setText("");
            definition.setText("Definition: " + k.getCt()[k.getCurrentIndex()].getDefinition());
        }

    }
    public void speak(){
        tts.setOnUtteranceProgressListener(new UtteranceProgressListener() {
            @Override
            public void onStart(String s) {
                runOnUiThread(() -> Toast.makeText(getApplicationContext(),"Done ",
                        Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onDone(String s) {
                runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Done ",
                        Toast.LENGTH_SHORT).show());
            }

            @Override
            public void onError(String utteranceId) {
                runOnUiThread(() -> Toast.makeText(getApplicationContext(), "Error ",
                        Toast.LENGTH_SHORT).show());
            }
        });

        tts.setSpeechRate(0.3f);
        tts.speak(fin.getText().toString(),
                TextToSpeech.QUEUE_FLUSH, null,null);
    }
    public void onDestroy() {
        if(tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}