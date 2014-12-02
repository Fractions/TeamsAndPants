
package fractionsteams;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;


public class Question {
    
    String qText; // the actual text of the question
    String answer; //should I make this an int? Nah. parse based on type of qustion. 
    int pointValue; // The number of points 
    int difficulty; // a range of ints, 0 being the easiest
    
    

   
    public Question(String q, String a, int p, int d){
        qText = q;
        answer = a;
        pointValue = p;
        difficulty = d;
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
