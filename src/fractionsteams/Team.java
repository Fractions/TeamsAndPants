
package fractionsteams;

import javax.swing.ImageIcon;




public class Team {
    int teamNum;
    String teamName;
    int totalScore;
    String [][] members;
    ImageIcon logo;
    int level;
    
    public Team (int t, String tn, int s, String [][] m, int l /*ImageIcon l*/){
        teamNum = t;
        teamName = tn;
        totalScore = s;
        members = m;
        level = l;
        //logo = l;
    }
}
