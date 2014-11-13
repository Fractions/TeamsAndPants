
package fractionsteams;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


public class FractionsTeamsFOrms extends javax.swing.JFrame {

   //use this after students have been read so we know how many there are 
    //String [] studetns = new String [];
    
    //VARIABLE DECLARATION
    String [] students;
    
  
    public FractionsTeamsFOrms() {
        initComponents();
        readStudentInfo();
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

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        studentsText = new javax.swing.JTextArea();
        studentInitButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        studentsText.setColumns(20);
        studentsText.setRows(5);
        jScrollPane1.setViewportView(studentsText);

        studentInitButton.setText("Student inti");
        studentInitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                studentInitButtonActionPerformed(evt);
            }
        });

        jButton1.setText("Read FIle");
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
                        .addComponent(jButton1)))
                .addContainerGap(193, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(309, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        readStudentInfo();
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
    private javax.swing.JButton studentInitButton;
    private javax.swing.JTextArea studentsText;
    // End of variables declaration//GEN-END:variables
}
