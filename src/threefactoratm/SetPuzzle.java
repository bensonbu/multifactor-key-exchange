/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threefactoratm;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Azure
 */
public class SetPuzzle extends javax.swing.JInternalFrame {

    FileInputStream fos = null;

    JFileChooser jf = new JFileChooser();
    String filename;
    BufferedImage bufferedImage = null;
    File file = null;

    /**
     * Creates new form FingerPrint
     */
    public SetPuzzle() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        fingerimage = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setTitle("Set Puzzle Image");

        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 51, 51)));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setText(" Image:");

        jButton1.setText("Browse");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(fingerimage, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(fingerimage, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int state = jf.showOpenDialog(this);
        if (state == JFileChooser.APPROVE_OPTION) {
            file = jf.getSelectedFile();

            filename = file.getName();

            try {
                bufferedImage = ImageIO.read(file);

                //set icon preview
                Image aux = bufferedImage.getScaledInstance(fingerimage.getWidth(), fingerimage.getHeight(), 1);
                fingerimage.setIcon(new ImageIcon(aux));

            } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "Error", ex.toString(), JOptionPane.ERROR_MESSAGE);
            }

            jTextField1.setText(jf.getSelectedFile().getAbsolutePath());

        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        String puzzlepath = jTextField1.getText();

        if (puzzlepath.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Select Puzzle  Image");
        } else {

            String s1 = "E:/Server1/Puzzle/";

            File filestorage1 = new File("E:/Server1/");

            if (!filestorage1.exists()) {
                filestorage1.mkdir();
            }

            File filesto1 = new File(s1);

            if (!filesto1.exists()) {
                filesto1.mkdir();
            }

            String outpathorg1 = s1 + SecureKey.genid + "_Puzzle.jpg";

            String outpathorg1enc = s1 + SecureKey.genid + "_Puzzle_enc.jpg";

            try {

                azUtil.EncDcy.encrypt(SecureKey.passPhrase, puzzlepath, outpathorg1enc);

                SecureKey.writeFile(puzzlepath, outpathorg1);

                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost/atm", "root", "root");

                String sql = "insert into puzzle(user_id,  pz_image)" + "values(?,?)";

                PreparedStatement stm = con.prepareStatement(sql);

                String tempath = SecureKey.genid + "_Puzzle_enc.jpg";

                stm.setInt(1, SecureKey.genid);
                stm.setString(2, tempath);

                stm.execute();

                con.close();

                String ext = filename.substring(filename.lastIndexOf("."));

                try {
                    fos = new FileInputStream(file);
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(this, "please select file", "File not found", JOptionPane.ERROR_MESSAGE);
                }

                FileOutputStream fout = null;
                try {
                    fout = new FileOutputStream("src/images/image1/" + SecureKey.genid + ext);
                } catch (FileNotFoundException ex) {
                    JOptionPane.showMessageDialog(this, "please give destination", "File not found", JOptionPane.ERROR_MESSAGE);
                }
                int c;
                try {
                    while ((c = fos.read()) != -1) {
                        fout.write(c);
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(this, ex, "File not found", JOptionPane.ERROR_MESSAGE);
                }

                FingerPrint log = new FingerPrint();
                Dimension desktopSize = getDesktopPane().getSize();
                Dimension jInternalFrameSize = log.getSize();
                log.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                        (desktopSize.height - jInternalFrameSize.height) / 2);
                getDesktopPane().add(log);
                log.setVisible(true);

                dispose();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fingerimage;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
