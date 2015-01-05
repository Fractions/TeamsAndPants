
package fractionsteams;

import javax.swing.ImageIcon;




public class Team {
    int teamNum;
    String teamName;
    int totalScore;
    String [][] members; //does NOT need to be a 2D array, but changing will take more time than what it saves. 
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

    public int getTeamNum() {
        return teamNum;
    }

    public void setTeamNum(int teamNum) {
        this.teamNum = teamNum;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String[][] getMembers() {
        return members;
    }

    public void setMembers(String[][] members) {
        this.members = members;
    }

    public ImageIcon getLogo() {
        return logo;
    }

    public void setLogo(ImageIcon logo) {
        this.logo = logo;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
    
    
}
