/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

/**
 *
 * @author Marco
 */
public class Recensione {
    private int CodiceRecensione;
    private int NumeroStelle;
    private String DescrizioneTestuale;
    private int CodiceStruttura;
    private String Utente;
    
    public Recensione() {
        
    }
    
    public Recensione(int CodiceRecensione, int NumeroStelle, String DescrizioneTestuale, int CodiceStruttura, String Utente) {
        this.CodiceRecensione = CodiceRecensione;
        this.NumeroStelle = NumeroStelle;
        this.DescrizioneTestuale = DescrizioneTestuale;
        this.CodiceStruttura = CodiceStruttura;
    }
    
    public int getCodiceRecensione() {
        return CodiceRecensione;
    }
    
    public void setCodiceRecensione(int CodiceRecensione) {
        this.CodiceRecensione = CodiceRecensione;
    }
    
    public int getNumeroStelle() {
        return NumeroStelle;
    }
    
    
}
