/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import javax.swing.JOptionPane;

/**
 *
 * @author Marco
 */
public class SchermataConfermaInserimentoStruttura extends javax.swing.JFrame {

    private ControllerSchermate controller;
    /**
     * Creates new form SchermataConfermaInserimentoStruttura
     */
    public SchermataConfermaInserimentoStruttura() {
        initComponents();
    }
    
    public SchermataConfermaInserimentoStruttura(ControllerSchermate controller) {
        initComponents();
        this.controller = controller;
        this.setLocationRelativeTo(null);
    }
    
    public void riempiDati(String Nome, String Indirizzo, String Citta, String Categoria, int Prezzo) {
        NomeStrutturaText.setText(Nome);
        IndirizzoText.setText(Indirizzo);
        CittaText.setText(Citta);
        CategoriaText.setText(Categoria);
        if (Prezzo == 1) {
            RangePrezzoText.setText("€");
        } else if (Prezzo == 2) {
            RangePrezzoText.setText("€€");
        } else if (Prezzo == 3) {
            RangePrezzoText.setText("€€€");
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

        IndietroButton = new javax.swing.JButton();
        ConfermaButton = new javax.swing.JButton();
        IntestazioneLabel = new javax.swing.JLabel();
        NomeStrutturaLabel = new javax.swing.JLabel();
        NomeStrutturaText = new javax.swing.JLabel();
        CategoriaLabel = new javax.swing.JLabel();
        CategoriaText = new javax.swing.JLabel();
        IndirizzoLabel = new javax.swing.JLabel();
        IndirizzoText = new javax.swing.JLabel();
        RangePrezzoLabel = new javax.swing.JLabel();
        RangePrezzoText = new javax.swing.JLabel();
        FotoPanel = new javax.swing.JPanel();
        Foto = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        filler4 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        filler5 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 32767));
        CittaLabel = new javax.swing.JLabel();
        CittaText = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridBagLayout());

        IndietroButton.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        IndietroButton.setText("Indietro");
        IndietroButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IndietroButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(IndietroButton, gridBagConstraints);

        ConfermaButton.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        ConfermaButton.setText("Conferma");
        ConfermaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfermaButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.weightx = 0.1;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(ConfermaButton, gridBagConstraints);

        IntestazioneLabel.setFont(new java.awt.Font("Corbel", 0, 24)); // NOI18N
        IntestazioneLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        IntestazioneLabel.setText("Controlla i dati inseriti prima di confermare l'inserimento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 0.2;
        getContentPane().add(IntestazioneLabel, gridBagConstraints);

        NomeStrutturaLabel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        NomeStrutturaLabel.setText("Nome Struttura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(NomeStrutturaLabel, gridBagConstraints);

        NomeStrutturaText.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        NomeStrutturaText.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(NomeStrutturaText, gridBagConstraints);

        CategoriaLabel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        CategoriaLabel.setText("Categoria");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(CategoriaLabel, gridBagConstraints);

        CategoriaText.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        CategoriaText.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(CategoriaText, gridBagConstraints);

        IndirizzoLabel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        IndirizzoLabel.setText("Indirizzo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(IndirizzoLabel, gridBagConstraints);

        IndirizzoText.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        IndirizzoText.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(IndirizzoText, gridBagConstraints);

        RangePrezzoLabel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        RangePrezzoLabel.setText("Range Prezzo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(RangePrezzoLabel, gridBagConstraints);

        RangePrezzoText.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        RangePrezzoText.setText("jLabel1");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.3;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(RangePrezzoText, gridBagConstraints);

        Foto.setText("jLabel1");

        javax.swing.GroupLayout FotoPanelLayout = new javax.swing.GroupLayout(FotoPanel);
        FotoPanel.setLayout(FotoPanelLayout);
        FotoPanelLayout.setHorizontalGroup(
            FotoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(FotoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FotoPanelLayout.createSequentialGroup()
                    .addGap(0, 33, Short.MAX_VALUE)
                    .addComponent(Foto)
                    .addGap(0, 33, Short.MAX_VALUE)))
        );
        FotoPanelLayout.setVerticalGroup(
            FotoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
            .addGroup(FotoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FotoPanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Foto)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.weighty = 0.5;
        getContentPane().add(FotoPanel, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 11;
        gridBagConstraints.weightx = 0.1;
        getContentPane().add(filler1, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridheight = 5;
        gridBagConstraints.weightx = 0.3;
        getContentPane().add(filler2, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 11;
        gridBagConstraints.weightx = 0.4;
        getContentPane().add(filler3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.weighty = 0.3;
        getContentPane().add(filler4, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.weighty = 0.3;
        getContentPane().add(filler5, gridBagConstraints);

        CittaLabel.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        CittaLabel.setText("Città");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(CittaLabel, gridBagConstraints);

        CittaText.setFont(new java.awt.Font("Corbel", 0, 14)); // NOI18N
        CittaText.setText("jLabel2");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 6;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 0.2;
        gridBagConstraints.weighty = 0.1;
        getContentPane().add(CittaText, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ConfermaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfermaButtonActionPerformed
        int input;
        input = JOptionPane.showConfirmDialog(this, "Confermi il caricamento di questi dati sul nostro database?\nLa struttura sarà visibile dagli utenti della nostra app con questi dati.", "Conferma?", JOptionPane.OK_CANCEL_OPTION);
        if(input == JOptionPane.OK_OPTION) {
            if(JOptionPane.showConfirmDialog(this, "La struttura è stata caricata con successo sul database.", "Inserimento avvenuto con successo.", JOptionPane.DEFAULT_OPTION) == JOptionPane.OK_OPTION) {
                this.setVisible(false);
                controller.showMenu();
            }
        }
    }//GEN-LAST:event_ConfermaButtonActionPerformed

    private void IndietroButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IndietroButtonActionPerformed
        this.setVisible(false);
        controller.showInserisciStruttura();
    }//GEN-LAST:event_IndietroButtonActionPerformed

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
            java.util.logging.Logger.getLogger(SchermataConfermaInserimentoStruttura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchermataConfermaInserimentoStruttura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchermataConfermaInserimentoStruttura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchermataConfermaInserimentoStruttura.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchermataConfermaInserimentoStruttura().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CategoriaLabel;
    private javax.swing.JLabel CategoriaText;
    private javax.swing.JLabel CittaLabel;
    private javax.swing.JLabel CittaText;
    private javax.swing.JButton ConfermaButton;
    private javax.swing.JLabel Foto;
    private javax.swing.JPanel FotoPanel;
    private javax.swing.JButton IndietroButton;
    private javax.swing.JLabel IndirizzoLabel;
    private javax.swing.JLabel IndirizzoText;
    private javax.swing.JLabel IntestazioneLabel;
    private javax.swing.JLabel NomeStrutturaLabel;
    private javax.swing.JLabel NomeStrutturaText;
    private javax.swing.JLabel RangePrezzoLabel;
    private javax.swing.JLabel RangePrezzoText;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.Box.Filler filler3;
    private javax.swing.Box.Filler filler4;
    private javax.swing.Box.Filler filler5;
    // End of variables declaration//GEN-END:variables
}
