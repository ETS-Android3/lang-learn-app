package com.example.testapp.Data;

import com.example.testapp.ui.saved.SavedItem;

import java.util.ArrayList;

public class Initiate {
    public static boolean aT = false;
    public static boolean hT = false;
    public static boolean kT = false;
    public static boolean mT = false;
    public static boolean sT = false;
    public static boolean nT = false;
    public static boolean rT = false;
    public static boolean tT = false;
    public static boolean ywT = false;
    public static boolean gT = false;
    public static boolean zT = false;
    public static boolean dT = false;
    public static boolean bT = false;
    public static boolean pT = false;
    public static boolean first = true;


    public static ArrayList<SavedItem> savedItems = new ArrayList<>();
    public static ArrayList<SavedItem> kanaChart = new ArrayList<>();


    public static ArrayList<SavedItem> getList(){return savedItems;}
    public static ArrayList<SavedItem> getKanaChart(){return kanaChart;}

    public static void removeSaved(int id){
        for(int i = 0; i<savedItems.size(); i++){
            SavedItem temp = savedItems.get(i);
            if(temp.getKey_id().equals(Integer.toString(id))){
                temp.getChar().setStatus("0");
                savedItems.remove(savedItems.get(i));
            }
        }
    }

}
