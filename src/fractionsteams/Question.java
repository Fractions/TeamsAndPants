
package fractionsteams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Question {
    
    int pointValue; // The number of points 
    int difficulty; // a range of ints, 0 being the easiest
    String qText; // the actual text of the question
    String answer; //should I make this an int? Nah. parse based on type of qustion. 

   
    public Question(int p, int d, String q, String a){
        pointValue = p;
        difficulty = d;
        qText = q;
        answer = a;
    }
   
    
    //===========================================================
    //GETTERS AND SETTERS AND GETTERTS AND SETTERS AND SETTERS
    public int getPointValue() {
        return pointValue;
    }

    public void setPointValue(int pointValue) {
        this.pointValue = pointValue;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public String getqText() {
        return qText;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
    
    
}
