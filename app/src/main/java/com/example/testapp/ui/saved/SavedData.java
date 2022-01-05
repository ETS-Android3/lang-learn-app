package com.example.testapp.ui.saved;

import com.example.testapp.Data.Characters;
import com.example.testapp.Data.CharactersTest;

import java.util.Vector;

public class SavedData {
    private Vector<Characters> vector;
    private Vector<CharactersTest> vTest;

    public SavedData(){}


    public Vector<Characters> getVector(){return vector;}

    public void addVector(Characters string){
        vector.add(string);
    }

    public void clearData(){
        vector.clear();
    }

    public void removeVector(Characters string){
        vector.remove(string);
    }
}
