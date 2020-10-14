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
    private float NumeroStelle;
    private String DescrizioneTestuale;
    private int CodiceStruttura;
    private String Utente;
    
    public Recensione() {
        
    }
    
    public Recensione(int CodiceRecensione, float NumeroStelle, String DescrizioneTestuale, String Utente) {
        this.CodiceRecensione = CodiceRecensione;
        this.NumeroStelle = NumeroStelle;
        this.DescrizioneTestuale = DescrizioneTestuale;
        this.Utente = Utente;
    }
    
    public Recensione(int CodiceRecensione, float NumeroStelle, String DescrizioneTestuale, int CodiceStruttura, String Utente) {
        this.CodiceRecensione = CodiceRecensione;
        this.NumeroStelle = NumeroStelle;
        this.DescrizioneTestuale = DescrizioneTestuale;
        this.CodiceStruttura = CodiceStruttura;
        this.Utente = Utente;
    }
    
    public int getCodiceRecensione() {
        return CodiceRecensione;
    }
    
    public void setCodiceRecensione(int CodiceRecensione) {
        this.CodiceRecensione = CodiceRecensione;
    }
    
    public float getNumeroStelle() {
        return NumeroStelle;
    }
    
    public String getDescrizione() {
        return DescrizioneTestuale;
    }
    
    public String getUser() {
        return Utente;
    }
    
    public int getCodiceStruttura() {
        return CodiceStruttura;
    }
    
    public String toString() {
        return Utente + ", " + NumeroStelle + "*, " + DescrizioneTestuale;
    }
}
