
package fractionsteams;

import javax.swing.ImageIcon;




public class Team {
    int teamNum;
    String teamName;
    int totalScore;
    Student [] members; //does NOT need to be a 2D array, but changing will take more time than what it saves. 
    ImageIcon logo;
    int level;
    
    public Team (int t, String tn, int s, Student [] m, int l /*ImageIcon l*/){
        teamNum = t;
        teamName = tn;
        totalScore = s;
        members = m;
        //System.out.println("from inside class name 0 "+members[0].getName());
        level = l;
        if(teamNum == 1){
            //logo.setImage(); // get from brandons code
        }
    }

   

    @Override
    public String toString() {
        String mem = "";
        for(int i = 0; i< members.length; i++){
            mem = mem + members[i].getName()+", ";
        }
        String msg = "team "+teamName+"(#"+teamNum+") consists of "+mem;
        
        return msg; 
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

    public Student[] getMembers() {
        return members;
    }

    public void setMembers(Student[] members) {
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
