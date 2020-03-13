/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threefactoratm;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Azure
 */
public class PreviewImage extends javax.swing.JInternalFrame {

    /**
     * Creates new form PreviewImage
     */
    public PreviewImage(BufferedImage bufferedImage) {
        initComponents();

        Image aux = bufferedImage.getScaledInstance(280, 210, 1);
        jLabel1.setIcon(new ImageIcon(aux));

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Output");
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText(".");
        jLabel1.setMaximumSize(new java.awt.Dimension(570, 340));
        jLabel1.setMinimumSize(new java.awt.Dimension(570, 340));
        jLabel1.setPreferredSize(new java.awt.Dimension(570, 340));
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 280, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
