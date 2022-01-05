package com.example.testapp.Data;

public class Characters {
    private String hiraChar;
    private String kataChar;
    private String phonetic;
    private int currentIndex ;
    private String status;
    private int ID ;
    private Characters[] ct;

    public Characters(String hira, String kata, String pho, int id,
                      String stat){
        hiraChar = hira;
        kataChar = kata;
        phonetic = pho;
        ID = id;
        status = stat;
    }

    public Characters(){
        currentIndex = 0;
    }

    public void setStatus(String stat){ status = stat; }

    public void setCurrentIndex(int index){currentIndex = index;}

    public void setCt(Characters[] array){ct = array;}

    public String getHiraChar(){
        return hiraChar;
    }

    public String getKataChar(){
        return kataChar;
    }

    public String getPhonetics(){
        return phonetic;
    }

    public String getStatus(){
        return status;
    }

    public int getCurrentIndex(){return currentIndex;}

    public int getID(){return ID;}

    public Characters[] getCt() {return ct;}

}
