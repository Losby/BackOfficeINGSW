/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Marco
 */
public class SchermataModificaStruttura extends javax.swing.JFrame {

    private ControllerSchermate controller;
    private boolean Modifica;
    private int CodiceStruttura;
    private SchermataSelezionaFoto ModificaFoto;
    private File FotoNuova;
    private String URLFoto;
    /**
     * Creates new form SchermataModificaStruttura
     */
    public SchermataModificaStruttura() {
        initComponents();
        this.controller = controller;
        this.setLocationRelativeTo(null);
        ConfermaModificaButton.setVisible(false);
        ModificaFotoButton.setVisible(false);
        Modifica = false;
        ModificaFoto = new SchermataSelezionaFoto(this);
    }
    public SchermataModificaStruttura(ControllerSchermate controller) {
        initComponents();
        this.controller = controller;
        this.setLocationRelativeTo(null);
        ConfermaModificaButton.setVisible(false);
        ModificaFotoButton.setVisible(false);
        Modifica = false;
        ModificaFoto = new SchermataSelezionaFoto(this);
        //setSize(1920,1080);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        try {
                UIManager.setLookAndFeel(UIManager
                        .getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | InstantiationException
                    | IllegalAccessException | UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
    }
    
    private void inizioModifica() {
        IndirizzoField.setEnabled(true);
        CittaField.setEnabled(true);
        PrezzoBox.setEnabled(true);
        EliminaButton.setVisible(false);
        ConfermaModificaButton.setVisible(true);
        ModificaButton.setVisible(false);
        ModificaFotoButton.setVisible(true);
        Modifica = true;
    }
    
    private void fineModifica() {
        IndirizzoField.setEnabled(false);
        CittaField.setEnabled(false);
        PrezzoBox.setEnabled(false);
        EliminaButton.setVisible(true);
        ConfermaModificaButton.setVisible(false);
        ModificaButton.setVisible(true);
        ModificaFotoButton.setVisible(false);
        Modifica = false;
        FotoNuova = null;
    }
    
    public void modificaFoto(File FotoNuova) {
        try {
            FotoLabel.setIcon(new ImageIcon(ImageIO.read(FotoNuova).getScaledInstance(400, 300, Image.SCALE_SMOOTH)));
            this.FotoNuova = FotoNuova;
        } catch (IOException ex) {
            Logger.getLogger(SchermataModificaStruttura.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setStruttura(Struttura DaModificare) {
        NomeStrutturaLabel.setText(DaModificare.getNomeStruttura());
        IndirizzoField.setText(DaModificare.getIndirizzo());
        PrezzoBox.setSelectedIndex(DaModificare.getPrezzo()-1);
        CittaField.setText(DaModificare.getCitta());
        CodiceStruttura = DaModificare.getIDStruttura();
        URLFoto = DaModificare.getURLFoto();
        try {
            FotoLabel.setIcon(new ImageIcon(ImageIO.read(new URL(URLFoto)).getScaledInstance(400, 300, Image.SCALE_SMOOTH)));
        } catch (MalformedURLException ex) {
            Logger.getLogger(SchermataModificaStruttura.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(SchermataModificaStruttura.class.getName()).log(Level.SEVERE, null, ex);
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

        BackButton = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        FotoLabel = new javax.swing.JLabel();
        NomeStrutturaLabel = new javax.swing.JLabel();
        IndirizzoLabel = new javax.swing.JLabel();
        IndirizzoField = new javax.swing.JTextField();
        PrezzoLabel = new javax.swing.JLabel();
        PrezzoBox = new javax.swing.JComboBox<>();
        EliminaButton = new javax.swing.JButton();
        ModificaButton = new javax.swing.JButton();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        CittaLabel = new javax.swing.JLabel();
        CittaField = new javax.swing.JTextField();
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        ConfermaModificaButton = new javax.swing.JButton();
        ModificaFotoButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UT Back Office - Modifica struttura");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        BackButton.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        BackButton.setText("Indietro");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 13;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(BackButton, gridBagConstraints);

        jPanel1.setLayout(new java.awt.GridBagLayout());
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        jPanel1.add(FotoLabel, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(jPanel1, gridBagConstraints);

        NomeStrutturaLabel.setFont(new java.awt.Font("Corbel", 1, 36)); // NOI18N
        NomeStrutturaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NomeStrutturaLabel.setText("Nome Struttura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(NomeStrutturaLabel, gridBagConstraints);

        IndirizzoLabel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        IndirizzoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        IndirizzoLabel.setText("Indirizzo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(IndirizzoLabel, gridBagConstraints);

        IndirizzoField.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(IndirizzoField, gridBagConstraints);

        PrezzoLabel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        PrezzoLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        PrezzoLabel.setText("Prezzo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(PrezzoLabel, gridBagConstraints);

        PrezzoBox.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        PrezzoBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "€", "€€", "€€€" }));
        PrezzoBox.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(PrezzoBox, gridBagConstraints);

        EliminaButton.setBackground(new java.awt.Color(255, 255, 255));
        EliminaButton.setFont(new java.awt.Font("Corbel", 0, 18)); // NOI18N
        EliminaButton.setForeground(new java.awt.Color(255, 0, 0));
        EliminaButton.setText("Elimina struttura");
        EliminaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EliminaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(EliminaButton, gridBagConstraints);

        ModificaButton.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        ModificaButton.setText("Modifica");
        ModificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 11;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(ModificaButton, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 14;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.6;
        getContentPane().add(filler1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.3;
        getContentPane().add(filler2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(filler3, gridBagConstraints);

        CittaLabel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        CittaLabel.setText("Città");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTH;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(CittaLabel, gridBagConstraints);

        CittaField.setEnabled(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(CittaField, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 1.4;
        getContentPane().add(filler4, gridBagConstraints);

        ConfermaModificaButton.setText("Conferma Modifica");
        ConfermaModificaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfermaModificaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(ConfermaModificaButton, gridBagConstraints);

        ModificaFotoButton.setText("Modifca Foto");
        ModificaFotoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificaFotoButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(ModificaFotoButton, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        if(Modifica == true){
            int ret = JOptionPane.showConfirmDialog(this, "Sei sicuro di voler tornare indietro?\nLe modifiche non verranno salvate.", "Annullare modifica?", JOptionPane.YES_NO_OPTION);
            if(ret == JOptionPane.NO_OPTION) {
                return;
            }
        }
        fineModifica();
        this.setVisible(false);
        controller.showStruttureRegistrate("Strutture");
    }//GEN-LAST:event_BackButtonActionPerformed

    private void EliminaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EliminaButtonActionPerformed
        int ret = JOptionPane.showConfirmDialog(this, "Sei davvero sicuro di voler eliminare la struttura dal database?\nTutte le informazioni relative ad essa andranno perse e il processo è irreversibile.", "Attenzione! Eliminare?", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        if(ret == JOptionPane.NO_OPTION) {
            return;
        }
        controller.eliminaStruttura(CodiceStruttura);
        JOptionPane.showConfirmDialog(this, "Struttura eliminata dal database.", "Struttura eliminata.", JOptionPane.DEFAULT_OPTION);
        fineModifica();
        this.setVisible(false);
        controller.showStruttureRegistrate("Strutture");
    }//GEN-LAST:event_EliminaButtonActionPerformed

    private void ModificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificaButtonActionPerformed
        inizioModifica();
    }//GEN-LAST:event_ModificaButtonActionPerformed

    private void ConfermaModificaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfermaModificaButtonActionPerformed
        Struttura PostModifica = new Struttura();
        
        PostModifica.setIDStruttura(CodiceStruttura);
        PostModifica.setNomeStruttura(NomeStrutturaLabel.getText());
        PostModifica.setIndirizzo(IndirizzoField.getText());
        PostModifica.setCitta(CittaField.getText());
        PostModifica.setPrezzo(PrezzoBox.getSelectedIndex()+1);
        if(FotoNuova != null) {
            PostModifica.setURLFoto(controller.caricaFoto(this.FotoNuova));
        } else {
            PostModifica.setURLFoto(URLFoto);
        }
        try{
            controller.modificaStruttura(CodiceStruttura, PostModifica);
        } catch (SQLException e) {
            if(JOptionPane.showConfirmDialog(this, "C'è stato un errore durante la modifica della struttura, riprova più tardi.", "Errore durante la modifica.", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE) == JOptionPane.OK_OPTION) {
                fineModifica();
                this.setVisible(false);
                controller.showStruttureRegistrate("Strutture");        
            }
        }
        fineModifica();
    }//GEN-LAST:event_ConfermaModificaButtonActionPerformed

    private void ModificaFotoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificaFotoButtonActionPerformed
        ModificaFoto.setVisible(true);
    }//GEN-LAST:event_ModificaFotoButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JTextField CittaField;
    private javax.swing.JLabel CittaLabel;
    private javax.swing.JButton ConfermaModificaButton;
    private javax.swing.JButton EliminaButton;
    private javax.swing.JLabel FotoLabel;
    private javax.swing.JTextField IndirizzoField;
    private javax.swing.JLabel IndirizzoLabel;
    private javax.swing.JButton ModificaButton;
    private javax.swing.JButton ModificaFotoButton;
    private javax.swing.JLabel NomeStrutturaLabel;
    private javax.swing.JComboBox<String> PrezzoBox;
    private javax.swing.JLabel PrezzoLabel;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
