
package fractionsteams;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Random;

//Let's be productive

public class FractionsTeamsFOrms extends javax.swing.JFrame {

    
    //VARIABLE DECLARATION
    String [] students;
    Random gen = new Random();
    Color primary;
    Color secondary;
    boolean defaultColours = true;
    
  
    public FractionsTeamsFOrms() {
        initComponents();
        readStudentInfo();
        setColours();
    }
    
    public void studentInit(){
        //=============READS IN STUDENT NAMES AND WRITES THEM TO FILE=========
        // This is only used once when the student names are initially set.
        //The names will then be read for them file this creates!
        String[] students = studentsText.getText().split("\n");
        try{
            File f2 = new File("class.txt");
            FileWriter fw = new FileWriter(f2);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(""+students.length);// this first line will we use to tell how many names there are when reading the file in later.
            bw.newLine();
            
            for (int i= 0; i< students.length; i++){
                bw.write(students[i]);  
                bw.newLine();
            }

            
            System.out.println("The students file has been initilialised!");
            bw.close();
        }
        catch(Exception e){
            e.printStackTrace();        
        }
        
    }
    
    public void readStudentInfo(){
        try{
        File f = new File("class.txt");
        FileReader fr = new FileReader(f);
        BufferedReader br = new BufferedReader(fr);
        
        String line = br.readLine();
        students = new String[(Integer.parseInt(line))+1]; // creates array with the number of students, this is given at the start of the file.
        //  I HAVE USED +1 TO AVOID INDEX OOB BY WHY IS IT HAPPENEING IN THE FIRST PLACE?
        
        int i =0;
        while(line!=null){
            line = br.readLine();
            students[i] = line;
            i++;
            System.out.println(""+i);
        }
        br.close();
        
        }catch(Exception e){
            e.printStackTrace();
        }   
    }
    
    public void setColours(){
        if(defaultColours == true){
            primary = new Color(30, 144, 255);//find RGB for school colours. I think blue and gold.
            secondary = new Color(238, 221, 130);
        }
        else{
            primary = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256)); //  random for now, will change later.
            secondary = new Color(gen.nextInt(256), gen.nextInt(256), gen.nextInt(256));
        }

        //this.getContentPane().setForeground(primary); //what is the foregroud?
        this.getContentPane().setBackground(primary);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentsText = new javax.swing.JTextArea();
        studentInitButton = new javax.swing.JButton();
        readButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Fraction Interaction");

        studentsText.setColumns(20);
        studentsText.setRows(5);
        jScrollPane1.setViewportView(studentsText);

        studentInitButton.setText("Student inti");
        studentInitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInitButtonActionPerformed(evt);
            }
        });

        readButton.setText("Read FIle");
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Random Colour!");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(77, 77, 77)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(studentInitButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(readButton)))
                .addContainerGap(193, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(89, 89, 89))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(190, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(96, 96, 96)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(readButton)
                        .addGap(59, 59, 59)
                        .addComponent(studentInitButton))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(87, 87, 87))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void studentInitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_studentInitButtonActionPerformed
        studentInit();
        
    }//GEN-LAST:event_studentInitButtonActionPerformed

    private void readButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_readButtonActionPerformed
        readStudentInfo();
    }//GEN-LAST:event_readButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        defaultColours = false;
        setColours();
    }//GEN-LAST:event_jButton1ActionPerformed

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
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton readButton;
    private javax.swing.JButton studentInitButton;
    private javax.swing.JTextArea studentsText;
    // End of variables declaration//GEN-END:variables
}
