/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.ArrayList;
import javax.swing.Box.Filler;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Marco
 */
public class SchermataGestioneRecensioni extends javax.swing.JFrame {

    private ControllerSchermate controller;
    private Struttura Struttura;
    /**
     * Creates new form SchermataGestioneRecensioni
     */
    public SchermataGestioneRecensioni() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public SchermataGestioneRecensioni(ControllerSchermate controller) {
        initComponents();
        this.controller = controller;
        this.setLocationRelativeTo(null);
        NienteRecensioniLabel.setVisible(false);
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
    
    public void riempiPanel(ArrayList<Recensione> ListaRecensioni) {  
        if(ListaRecensioni != null){
            
            if(!(ListaRecensioni.isEmpty())) {
                NienteRecensioniLabel.setVisible(false);
                svuotaPanel();
                jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.PAGE_AXIS));
                for (Recensione RecensioneTemp : ListaRecensioni) {
                    JPanel temp = new JPanel();
                    JTextField jTextField1 = new JTextField(RecensioneTemp.getDescrizione());
                    JButton ApprovaButton = new JButton("Approva");
                    JButton RifiutaButton = new JButton("Rifiuta");
                    JLabel UserEPunteggio = new JLabel(RecensioneTemp.getUser() + ", " + RecensioneTemp.getNumeroStelle() +"*");
                    
                    GridBagLayout layout = new java.awt.GridBagLayout();
                    temp.setLayout(layout);
                    
                    temp.add(jTextField1);
                    temp.add(ApprovaButton);
                    temp.add(RifiutaButton);
                    temp.add(UserEPunteggio);

                    settaTextField(layout, temp, jTextField1);
                    settaButtonApprova(layout, temp, ApprovaButton, RecensioneTemp);
                    settaButtonRifiuta(layout, temp, RifiutaButton, RecensioneTemp);
                    settaLabel(layout, temp, UserEPunteggio);
                    jPanel1.add(temp);
                }
            } else {
                jPanel1.setLayout(new BoxLayout(jPanel1, BoxLayout.LINE_AXIS));
                svuotaPanel();
                NienteRecensioniLabel.setVisible(true);
            }
        }
       pack();
       this.setLocationRelativeTo(null);
       setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    
    private void svuotaPanel() {
        Component[] Components = jPanel1.getComponents();
        if(Components.length != 1) {
            for(int i = 0; i < Components.length; i++) {
                if (Components[i] != NienteRecensioniLabel) jPanel1.remove(Components[i]);
            }
        }
    }
    
    private void settaTextField(GridBagLayout layout, JPanel temp, JTextField jTextField1) {
        GridBagConstraints gridBagConstraintini;
        gridBagConstraintini = layout.getConstraints(jTextField1);
        gridBagConstraintini.gridx = 0;
        gridBagConstraintini.gridy = 1;
        gridBagConstraintini.gridwidth = 6;
        gridBagConstraintini.gridheight = 2;
        gridBagConstraintini.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraintini.weightx = 1.0;
        gridBagConstraintini.weighty = 1.0;
        layout.setConstraints(jTextField1, gridBagConstraintini);
    }
    
    private void settaButtonApprova(GridBagLayout layout, JPanel temp, JButton bottone, Recensione RecensioneDaApprovare) {
        GridBagConstraints gridBagConstraintini;
        bottone.addActionListener(new java.awt.event.ActionListener() {
            private Recensione Recensione = RecensioneDaApprovare;
            private JPanel pannello = temp;
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //bottoneActionPerformed(evt);
                int ret = JOptionPane.showConfirmDialog(rootPane, "Sei sicuro di voler approvare questa recensione?", "Approvare la recensione?", JOptionPane.YES_NO_OPTION);
                if(ret == JOptionPane.YES_OPTION) {
                    controller.approvaRecensione(Recensione);
                    controller.eliminaRecensione(Recensione.getCodiceRecensione());
                    jPanel1.remove(pannello);
                    jPanel1.revalidate();
                    jPanel1.repaint();
                }                 
            }
        });
        gridBagConstraintini = layout.getConstraints(bottone);
        gridBagConstraintini.gridx = 4;
        gridBagConstraintini.gridy = 0;
        gridBagConstraintini.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraintini.weightx = 0.1;
        gridBagConstraintini.weighty = 0.25;
        layout.setConstraints(bottone, gridBagConstraintini);
    }
    
    private void settaButtonRifiuta(GridBagLayout layout, JPanel temp, JButton bottone, Recensione RecensioneDaRifiutare) {
        GridBagConstraints gridBagConstraintini;
        bottone.addActionListener(new java.awt.event.ActionListener() {
            private Recensione Recensione = RecensioneDaRifiutare;
            private JPanel pannello = temp;
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                //bottoneActionPerformed(evt);
                int ret = JOptionPane.showConfirmDialog(rootPane, "Sei sicuro di voler rifiutare questa recensione?", "Rifiutare la recensione?", JOptionPane.YES_NO_OPTION);
                if(ret == JOptionPane.YES_OPTION) {
                    controller.eliminaRecensione(Recensione.getCodiceRecensione());
                    jPanel1.remove(pannello);
                    jPanel1.revalidate();
                    jPanel1.repaint();
                }
            }
        });
        gridBagConstraintini = layout.getConstraints(bottone);
        gridBagConstraintini.gridx = 5;
        gridBagConstraintini.gridy = 0;
        gridBagConstraintini.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraintini.weightx = 0.1;
        gridBagConstraintini.weighty = 0.25;
        layout.setConstraints(bottone, gridBagConstraintini);
    }
    
    private void settaLabel(GridBagLayout layout, JPanel temp, JLabel jLabel1) {
        GridBagConstraints gridBagConstraints;
        gridBagConstraints = layout.getConstraints(jLabel1);
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHWEST;
        gridBagConstraints.weightx = 2;
        gridBagConstraints.weighty = 0.25;
        layout.setConstraints(jLabel1, gridBagConstraints);
    }
    
    public void setStruttura(Struttura DaGestire) {
        this.Struttura = DaGestire;
        IntestazioneLabel.setText("Ecco le recensioni in attesa di approvazione per " +DaGestire.getNomeStruttura());
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

        IntestazioneLabel = new javax.swing.JLabel();
        IndietroButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        NienteRecensioniLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UT Back Office - Recensioni");
        getContentPane().setLayout(new java.awt.GridBagLayout());

        IntestazioneLabel.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        IntestazioneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IntestazioneLabel.setText("Ecco le recensioni in attesa di approvazione per ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 5.0;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(IntestazioneLabel, gridBagConstraints);

        IndietroButton.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        IndietroButton.setText("Indietro");
        IndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IndietroButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(IndietroButton, gridBagConstraints);

        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        NienteRecensioniLabel.setFont(new java.awt.Font("Corbel", 0, 36)); // NOI18N
        NienteRecensioniLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NienteRecensioniLabel.setText("Non ci sono recensioni in attesa di approvazione.");
        jPanel1.add(NienteRecensioniLabel);

        jScrollPane1.setViewportView(jPanel1);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.gridheight = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void IndietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IndietroButtonActionPerformed
        this.setVisible(false);
        controller.showStruttureRegistrate("Recensioni");
    }//GEN-LAST:event_IndietroButtonActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton IndietroButton;
    private javax.swing.JLabel IntestazioneLabel;
    private javax.swing.JLabel NienteRecensioniLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
