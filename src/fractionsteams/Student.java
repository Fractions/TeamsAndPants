
package fractionsteams;

public class Student {
    String name;
    int team;
    int totalScore;

    //contructor with just names - i.e. teams not yet initilised.
    public Student(String n){
        name = n;
    }
    
    //full constructor
    public Student(String n, int t, int s){
        name = n;
        team = t;
        totalScore = s;     
    }

    public int getTeam() {
        return team;
    }

    public void setTeam(int team) {
        this.team = team;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
   
    
    
    
}
