package fractionsteams;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

/*
*TO DO :
 *- create option for num teams in GUI
 *- leave questions array but declare nothing, keep counter in while loop, and at the end initilise the array with the amount of questions.
 *- add code for team logos to contructor and init method.
 *- code teams class for if it has already been initilised, esientially just reading a file.
 *- create save files for the classes that can be read in after initilisation
*/

public class FractionsTeamsFOrms extends javax.swing.JFrame {

    
    //===========================VARIABLE DECLARATION============================================
    //=======General============
    Random gen = new Random();
    Color primary;
    Color secondary;
    boolean defaultColours = true;
    //=============Students==============
    String [] names;
    Student [] students;
    
    
    //======Questions=======
    Question [] q = new Question[1000]; // arbitrary amout, how can I made a dynamic array size based on file reading?

    
    //=======Teams==========
    boolean teamsInitd;
    int numTeams = 2; //Can be modified at a later data
    Team [] teams = new Team[numTeams];
    int [] teamLevel = new int[numTeams];
    int studPerTeam;
    boolean randomTeams = true;
    String [] teamName = new String [numTeams];
    int [] totalScore = new int [numTeams];
    String [][] members = new String[numTeams][studPerTeam+1];// the +1 gives us leeway with a potential uneven class
    
    
    //======I/O STUFF=========
    FileReader fr;
    BufferedReader br;
    FileWriter fw;
    BufferedWriter bw;
          
    
  
    
    
    public FractionsTeamsFOrms() {
        initComponents(); // don't put anything before this!
        setColours();
        
        //panels!
        studentPanel.setVisible(false);
        studentPanel.setBackground(secondary);
        
        // end panels
        
        readStudentInfo();
        primeNumberGenerator();
        readQuestions();
        
    }
    
    
    public void readQuestions(){
        /*The questions file will read as follows: 
            questions text
            answer
            point value
            difficulty. 
        THIS MUST BE STICTLY ADHERED IN THE QUESTIONS FILE OTHERWISE MANY ERRORS WILL OCCUR
       */
        
        try{
        File g = new File("questions.txt");
        fr = new FileReader(g);
        br = new BufferedReader(fr);
        
        String line = br.readLine();
        int qTal = 0;
        
        
        
            while(line!=null){
                String fQ = line; // question from file

                line = br.readLine();
                String fA = line;  //answer from file

                line = br.readLine();
                int fP = Integer.parseInt(line);   // point value from file

                line = br.readLine();
                int fD = Integer.parseInt(line);   // dificulty from file

                q[qTal] = new Question(fQ, fA, fP, fD);
                
                System.out.println("The question is "+q[qTal].getqText());
                qTal++;
                line = br.readLine();
                //System.out.println(""+line);
               
            }
                
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void initTeam(){
        //return to this when students array is done proper
        studPerTeam = students.length/numTeams;
        
        if(!teamsInitd){
            if(students.length%numTeams != 0){                                  // i.e. if the teams are not equally divided - there is a remainder
                students[students.length-1].setTeam(gen.nextInt(numTeams));     //the last student will be put into a random team
            }
            else{                                                                  //otherwise, they are equal size and randomly distributed.
                for(int i = 0; i < students.length; i++){
                    students[i].setTeam(gen.nextInt(numTeams));
                }
            }
            

            for(int t = 0; t < teams.length; t++){
                //The following code utilises 3 loops to fill the 2d array of team members. //THIS CAN BE CUT DOWN BY SORTING THE STUDENTS ARRAY BY TEAM
                // it searches the stuends array for team number, then asigns it to the other loop t(for team) and the inner loop j(for members)
                for(int i = 0; i < students.length; i++){
                    if(students[i].getTeam()==t){
                        for(int m = 0; m < studPerTeam; m++){
                            members[t][m] = students[i].getName();
                        }
                    }
                }

                teams[t] = new Team(t, teamName[t], totalScore[t], members, teamLevel[t]);
            }
            
        }
        
        
    }
    
    public void studentInit(){
        //=============READS IN STUDENT NAMES AND WRITES THEM TO FILE=========
        // This is only used once when the student names are initially set.
        //The names will then be read for them file this creates!
        names = studentsText.getText().split("\n");                             //this creates an array with a length of the number of new lines 
        try{
            File f2 = new File("class.txt");
            fw = new FileWriter(f2);
            bw = new BufferedWriter(fw);

            bw.write(""+names.length);                                          // this first line will we use to tell how many names there are when reading the file in later.
            bw.newLine();
            
            for (int i= 0; i< names.length; i++){
                bw.write(names[i]);  
                bw.newLine();
            }

            
            System.out.println("The students file has been initilialised!");
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();        
        }
        //Once the names have been initilised, we call the next method which will store them properly in javas ram.
        readStudentInfo();
        
    }
    
    public void readStudentInfo(){
        try{
        File f = new File("class.txt");
        fr = new FileReader(f);
        br = new BufferedReader(fr);
        
        String line = br.readLine();
        names = new String[(Integer.parseInt(line))+1]; // creates array with the number of names, this is given at the start of the file.
        //  I HAVE USED +1 TO AVOID INDEX OOB BY WHY IS IT HAPPENEING IN THE FIRST PLACE?
        
        int i =0;
        while(line!=null){
            line = br.readLine();
            names[i] = line;
            i++;
        }
        br.close();
        
        }catch(Exception e){
            e.printStackTrace();
        }   
        
        //We will now create the student object with the names we read
        for (int i = 0; i < names.length; i++){
            students = new Student[names.length]; // declaring the array of student "remote controls"
            students[i] = new Student(names[i]);  // actually creating an object for the array "remote control" to point at
        }
    }
    
    public void setColours(){
        if(defaultColours == true){
            primary = new Color(0, 0, 128);//find RGB for school colours. I think blue and gold.
            secondary = new Color(128, 0, 0);
        }
        else{
            primary = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)); //  random for now, will change later.
            secondary = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256));
        }

        //this.getContentPane().setForeground(primary); //what is the foregroud?
        this.getContentPane().setBackground(primary);
    }

    public void primeNumberGenerator(){
        // THIS IS NOT DONE... I haven't yet said which are true for prime!x
        //this is not necessary for program, just wanted to wrtie this in java and python
        
        
        int interval = 1000; //what were searching through
        int primeTally = 0;
        int [] primes = new int[1000]; // how do we get the array to adapt to how many we need?
        
        boolean[] isPrime = new boolean[interval];
        
      
        
        for(int i = 1; i < interval; i++){ //start at one since we know 0 is not prime
            for(int j = i; j > 0; j--){ // start at one since we can never divide by zero
                //check if i is divisible by any number in the interval
                if((i%j == 0)&&(i!=1)&&(i!=i)){
                    isPrime[i] = false;
                }
            }
            if(isPrime[i]!= false){
                    isPrime[i] = true;
                    primeTally++;
                    primes[primeTally] = i;
                    System.out.println("The number "+i+" is prime"); 
            }
                    
                
        }
        
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        readButton = new javax.swing.JButton();
        colourButton = new javax.swing.JButton();
        studentButton = new javax.swing.JLabel();
        studentPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        studentsText = new javax.swing.JTextArea();
        saveStudentButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fraction Interaction");
        setMinimumSize(new java.awt.Dimension(1174, 539));
        getContentPane().setLayout(null);

        readButton.setText("Read FIle");
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });
        getContentPane().add(readButton);
        readButton.setBounds(340, 470, 79, 23);

        colourButton.setText("Random Colour!");
        colourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colourButtonActionPerformed(evt);
            }
        });
        getContentPane().add(colourButton);
        colourButton.setBounds(600, 150, 109, 23);

        studentButton.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        studentButton.setForeground(new java.awt.Color(51, 255, 51));
        studentButton.setText("Initialise Student List");
        studentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentButtonMouseClicked(evt);
            }
        });
        getContentPane().add(studentButton);
        studentButton.setBounds(10, 460, 253, 43);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("Enter Student Names - One per line!");

        studentsText.setColumns(20);
        studentsText.setRows(5);
        jScrollPane1.setViewportView(studentsText);

        saveStudentButton.setText("Save Student Data");
        saveStudentButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveStudentButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout studentPanelLayout = new javax.swing.GroupLayout(studentPanel);
        studentPanel.setLayout(studentPanelLayout);
        studentPanelLayout.setHorizontalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 490, Short.MAX_VALUE)
                    .addGroup(studentPanelLayout.createSequentialGroup()
                        .addGroup(studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(saveStudentButton)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        studentPanelLayout.setVerticalGroup(
            studentPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(studentPanelLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(saveStudentButton)
                .addContainerGap(187, Short.MAX_VALUE))
        );

        getContentPane().add(studentPanel);
        studentPanel.setBounds(0, 0, 563, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void saveStudentButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveStudentButtonActionPerformed
        studentInit();
        
    }//GEN-LAST:event_saveStudentButtonActionPerformed

    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readButtonActionPerformed
        readStudentInfo();
    }//GEN-LAST:event_readButtonActionPerformed

    private void colourButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_colourButtonActionPerformed
        defaultColours = false;
        setColours();
    }//GEN-LAST:event_colourButtonActionPerformed

    private void studentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_studentButtonMouseClicked
        studentPanel.setVisible(true);
        studentPanel.requestFocusInWindow();
    }//GEN-LAST:event_studentButtonMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FractionsTeamsFOrms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FractionsTeamsFOrms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FractionsTeamsFOrms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FractionsTeamsFOrms.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FractionsTeamsFOrms().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton colourButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton readButton;
    private javax.swing.JButton saveStudentButton;
    private javax.swing.JLabel studentButton;
    private javax.swing.JPanel studentPanel;
    private javax.swing.JTextArea studentsText;
    // End of variables declaration//GEN-END:variables
}
