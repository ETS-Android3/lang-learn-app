package com.example.testapp.ui.saved;

import com.example.testapp.Data.Characters;

public class SavedItem {
    private String item_hira;
    private String key_id;
    private String item_kata;
    private String item_pho;
    private String fav_status;
    private Characters chara;

    public SavedItem(){
    }

    public SavedItem(String item_hira, String key_id, String item_kata,
                     String item_pho, String fav, Characters ch) {
        this.item_hira = item_hira;
        this.key_id = key_id;
        this.item_kata = item_kata;
        this.item_pho = item_pho;
        this.fav_status = fav;
        this.chara = ch;
    }
    public SavedItem(String item_hira, String key_id, String item_kata,
                     String item_pho, String fav) {
        this.item_hira = item_hira;
        this.key_id = key_id;
        this.item_kata = item_kata;
        this.item_pho = item_pho;
        this.fav_status = fav;
    }


    public String getItem_hira() {
        return item_hira;
    }

    public String getKey_id() {
        return key_id;
    }

    public String getItem_kata() {
        return item_kata;
    }

    public String getItem_pho() { return item_pho; }

    public Characters getChar() {return chara;}

    public String getFav_status() {
        return fav_status;
    }

    public void setFavStatus(String item_fav_status) {
        getChar().setStatus(item_fav_status);
        this.fav_status = item_fav_status;
    }
}

