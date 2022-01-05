package com.example.testapp.test.flash;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testapp.Data.Characters;
import com.example.testapp.Data.Initiate;
import com.example.testapp.HomeOptions.Katakana.Katakana;
import com.example.testapp.R;
import com.example.testapp.ui.saved.SavedAdapter;
import com.example.testapp.ui.saved.SavedItem;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

public class KataFlash extends AppCompatActivity {
    ArrayList<SavedItem> nL = Initiate.getList();
    SavedItem sI;
    public static Characters c = Katakana.c;
    public static Characters[] a = Katakana.a;
    public static Characters[] k = Katakana.k;
    public static Characters[] h = Katakana.h;
    public static Characters[] m = Katakana.m;
    public static Characters[] n = Katakana.n;
    public static Characters[] r = Katakana.r;
    public static Characters[] s = Katakana.s;
    public static Characters[] t = Katakana.t;
    public static Characters[] yw = Katakana.yw;
    public static Characters[] g = Katakana.g;
    public static Characters[] z = Katakana.z;
    public static Characters[] d = Katakana.d;
    public static Characters[] b = Katakana.b;
    public static Characters[] p = Katakana.p;
    private TextView character;
    private TextView phone;
    private TextView kanaCharacter;
    private ImageButton saved_item;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash);
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        character = findViewById(R.id.charText);
        kanaCharacter = findViewById(R.id.kanaText);
        phone = findViewById(R.id.phoneticText);
        ImageButton sound = findViewById(R.id.soundButton);
        Button saveButton = findViewById(R.id.saveButton);
        saved_item = findViewById(R.id.saved_item);
        RecyclerView recyclerView = findViewById(R.id.recyclerKata);
        recyclerView.setAdapter(new SavedAdapter(getApplicationContext(),nL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        tts = new TextToSpeech(getApplicationContext(), status -> {
            if (status == TextToSpeech.SUCCESS) {
                int result;
                if (tts.isLanguageAvailable(Locale.JAPANESE) < 0) {
                    result = tts.setVoice(tts.getVoice());
                }else {
                    result = tts.setLanguage(Locale.JAPANESE);
                }
                tts.setSpeechRate(0.3f);
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

        saveButton.setOnClickListener(view -> {
            if (Integer.parseInt(c.getCt()[c.getCurrentIndex()].getStatus()) == 0) {
                c.getCt()[c.getCurrentIndex()].setStatus("1");
                nL.add(sI);
            } else if (Integer.parseInt(c.getCt()[c.getCurrentIndex()].getStatus()) == 1) {
                c.getCt()[c.getCurrentIndex()].setStatus("0");
                Initiate.removeSaved(c.getCt()[c.getCurrentIndex()].getID());
            }
            checkStatus();
        });
        saved_item.setOnClickListener(v -> {
            if(Integer.parseInt(c.getCt()[c.getCurrentIndex()].getStatus()) == 0) {
                c.getCt()[c.getCurrentIndex()].setStatus("1");
                nL.add(sI);
            }else if(Integer.parseInt(c.getCt()[c.getCurrentIndex()].getStatus()) == 1){
                c.getCt()[c.getCurrentIndex()].setStatus("0");
                Initiate.removeSaved(c.getCt()[c.getCurrentIndex()].getID());
            }
            checkStatus();
        });

        if(c.getCurrentIndex() == 0){
            if(Initiate.first) {
                cardSet();
                Initiate.first = false;
            }
            updateChar();
        }
        Button nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(view -> {
            if(c.getCurrentIndex() == c.getCt().length-1){
                c.setCurrentIndex(0);
            }else {
                c.setCurrentIndex((c.getCurrentIndex() + 1));
            }
            updateChar();
        });
        Button prevButton = findViewById(R.id.prevButton);
        prevButton.setOnClickListener(view -> {
            if(c.getCurrentIndex() == 0){
                c.setCurrentIndex(c.getCt().length-1);
            }
            else{
                c.setCurrentIndex(c.getCurrentIndex() - 1);
            }
            updateChar();
        });
    }
    private void checkStatus(){
        if(Integer.parseInt(c.getCt()[c.getCurrentIndex()].getStatus()) == 0){
            saved_item.setForeground(AppCompatResources.getDrawable(
                    getApplicationContext(),R.drawable.ic_baseline_turned_in_not_24));
        }else if (Integer.parseInt(c.getCt()[c.getCurrentIndex()].getStatus()) == 1){
            saved_item.setForeground(AppCompatResources.getDrawable(
                    getApplicationContext(),R.drawable.ic_baseline_turned_in_24));
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
        tts.speak(character.getText().toString(),
                TextToSpeech.QUEUE_FLUSH, null,null);
    }

    private void updateChar(){
        String kata = c.getCt()[c.getCurrentIndex()].getKataChar();
        character.setText(kata);
        String hira = c.getCt()[c.getCurrentIndex()].getHiraChar();
        kanaCharacter.setText("Hiragana: " + hira);
        String pho = c.getCt()[c.getCurrentIndex()].getPhonetics();
        phone.setText(pho);
        checkStatus();
        sI = new SavedItem(c.getCt()[c.getCurrentIndex()].getHiraChar(),
                Integer.toString(c.getCt()[c.getCurrentIndex()].getID()),
                c.getCt()[c.getCurrentIndex()].getKataChar(),
                c.getCt()[c.getCurrentIndex()].getPhonetics(),
                c.getCt()[c.getCurrentIndex()].getStatus(), c.getCt()[c.getCurrentIndex()]);

    }

    public void cardSet(){
        if(Initiate.aT) {
            c.setCt(a);
        }else if(Initiate.kT){
            c.setCt(k);
        }else if(Initiate.mT){
            c.setCt(m);
        }else if(Initiate.hT){
            c.setCt(h);
        }else if(Initiate.sT){
            c.setCt(s);
        }else if(Initiate.nT){
            c.setCt(n);
        }else if(Initiate.rT){
            c.setCt(r);
        }else if(Initiate.tT){
            c.setCt(t);
        }else if(Initiate.ywT){
            c.setCt(yw);
        }else if(Initiate.gT){
            c.setCt(g);
        }else if(Initiate.zT){
            c.setCt(z);
        }else if(Initiate.dT){
            c.setCt(d);
        }else if(Initiate.bT){
            c.setCt(b);
        }else if(Initiate.pT) {
            c.setCt(p);
        }
    }
    public void onDestroy() {
        if(tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}