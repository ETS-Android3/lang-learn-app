package com.example.testapp.Data;

public class CharactersTest {
    private String character;
    private String answer;
    private String definition;
    private String reading;
    private int currentIndex ;
    private CharactersTest[] ct;
    private int correctCount;

    public CharactersTest(String c, String ans, String def, String read){
        character = c;
        answer = ans;
        definition = def;
        reading = read;
    }

    public CharactersTest(){
        correctCount = 0;
        currentIndex = 0;
    }

    public void setCurrentIndex(int index){currentIndex = index;}

    public void setCt(CharactersTest[] array){ct = array;}

    public void setCorrectCount(int num){ correctCount = num; }

    public void incrementCorrectCount(int num){ correctCount+=num;}

    public String getCharacter(){
        return character;
    }

    public String getAnswer(){
        return answer;
    }

    public String getDefinition(){
        return definition;
    }

    public int getCurrentIndex(){return currentIndex;}

    public CharactersTest[] getCt() {return ct;}

    public int getCorrectCount(){return correctCount;}

    public String getReading(){return reading;}

    public CharactersTest[] shuffle(CharactersTest[] array){
        for(int i = array.length - 1; i>0;i--){
            int j = (int)Math.floor(Math.random()*(i+1));
            CharactersTest temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
