
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
        initComponents(); // don't put anything before this!
        setColours();
        
        //panels!
        studentPanel.setVisible(false);
        studentPanel.setBackground(secondary);
        
        // end panels
        
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
        }
        br.close();
        
        }catch(Exception e){
            e.printStackTrace();
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

        readButton.setText("Read FIle");
        readButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                readButtonActionPerformed(evt);
            }
        });

        colourButton.setText("Random Colour!");
        colourButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                colourButtonActionPerformed(evt);
            }
        });

        studentButton.setFont(new java.awt.Font("Monospaced", 1, 18)); // NOI18N
        studentButton.setForeground(new java.awt.Color(51, 255, 51));
        studentButton.setText("Initialise Student List");
        studentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                studentButtonMouseClicked(evt);
            }
        });

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

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(studentButton)
                        .addGap(65, 65, 65)
                        .addComponent(readButton))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(studentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 399, Short.MAX_VALUE)
                .addComponent(colourButton))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(77, 77, 77)
                        .addComponent(colourButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(16, Short.MAX_VALUE)
                        .addComponent(studentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(studentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(readButton))
                .addGap(24, 24, 24))
        );

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
