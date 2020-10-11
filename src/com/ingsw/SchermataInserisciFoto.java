/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author Marco
 */
public class SchermataInserisciFoto extends javax.swing.JFrame {
    
    private SchermataSelezionaFoto FotoChooser;
    private ControllerSchermate controller;
    private File FotoCaricata;
    /**
     * Creates new form SchermataInserisciFoto
     */
    public SchermataInserisciFoto() {
        initComponents();
        FotoChooser = new SchermataSelezionaFoto(this);
    }
    public SchermataInserisciFoto(ControllerSchermate controller) {
        initComponents();
        this.controller = controller;
        this.setLocationRelativeTo(null);
        FotoChooser = new SchermataSelezionaFoto(this);
    }
    public void setFoto(File Foto) {
        FotoCaricata = Foto;
        mostraFoto();
        controller.setFoto(Foto);
    }
    
    private void mostraFoto() {
        try {
            DirectoryFotoLabel.setText(FotoCaricata.getPath());
            Image dimg = ImageIO.read(FotoCaricata).getScaledInstance(800, 600, Image.SCALE_SMOOTH);
            FotoLabel.setIcon(new ImageIcon(dimg));
        } catch (IOException ex) {
            Logger.getLogger(SchermataInserisciFoto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        IntestazioneLabelFoto = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        FotoLabel = new javax.swing.JLabel();
        DirectoryFotoLabel = new javax.swing.JLabel();
        CaricaFotoButton = new javax.swing.JButton();
        IndietroButtonFoto = new javax.swing.JButton();
        CompletaProceduraButton = new javax.swing.JButton();
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler6 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        IntestazioneLabelFoto.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        IntestazioneLabelFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IntestazioneLabelFoto.setText("Inserisci una foto per la tua struttura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.2;
        gridBagConstraints.weighty = 0.3;
        getContentPane().add(IntestazioneLabelFoto, gridBagConstraints);

        jPanel1.setMaximumSize(new java.awt.Dimension(800, 600));
        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        jPanel1.add(FotoLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jPanel1, gridBagConstraints);

        DirectoryFotoLabel.setFont(new java.awt.Font("Corbel", 0, 12)); // NOI18N
        DirectoryFotoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        DirectoryFotoLabel.setText("jLabel3");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(DirectoryFotoLabel, gridBagConstraints);

        CaricaFotoButton.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        CaricaFotoButton.setText("Carica");
        CaricaFotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CaricaFotoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(CaricaFotoButton, gridBagConstraints);

        IndietroButtonFoto.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        IndietroButtonFoto.setText("Indietro");
        IndietroButtonFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IndietroButtonFotoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(IndietroButtonFoto, gridBagConstraints);

        CompletaProceduraButton.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        CompletaProceduraButton.setText("Completa procedura");
        CompletaProceduraButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CompletaProceduraButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(CompletaProceduraButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.weightx = 0.6;
        getContentPane().add(filler5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 6;
        gridBagConstraints.weightx = 0.9;
        getContentPane().add(filler6, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IndietroButtonFotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IndietroButtonFotoActionPerformed
        this.setVisible(false);
        controller.showInserisciStruttura();
    }//GEN-LAST:event_IndietroButtonFotoActionPerformed

    private void CompletaProceduraButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CompletaProceduraButtonActionPerformed
        
        if(FotoCaricata != null) {
            this.setVisible(false);
            controller.showConfermaInserimento();
        } else {
            JOptionPane.showMessageDialog(this, "Scegli una foto per la struttura prima di continuare!", "Scegli una foto!", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_CompletaProceduraButtonActionPerformed

    private void CaricaFotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CaricaFotoButtonActionPerformed
        this.setVisible(false);
        FotoChooser.setVisible(true);
    }//GEN-LAST:event_CaricaFotoButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SchermataInserisciFoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchermataInserisciFoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchermataInserisciFoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchermataInserisciFoto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchermataInserisciFoto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CaricaFotoButton;
    private javax.swing.JButton CompletaProceduraButton;
    private javax.swing.JLabel DirectoryFotoLabel;
    private javax.swing.JLabel FotoLabel;
    private javax.swing.JButton IndietroButtonFoto;
    private javax.swing.JLabel IntestazioneLabelFoto;
    private javax.swing.Box.Filler filler5;
    private javax.swing.Box.Filler filler6;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
