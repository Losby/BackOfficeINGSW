/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.io.File;

/**
 *
 * @author Marco
 */
public class Struttura {
    private String NomeStruttura;
    private String Indirizzo;
    private String Citta;
    private int Prezzo;
    private String Categoria;
    private int IDStruttura;
    private String LinkImmagine;
    private File FotoStruttura;
    
    public Struttura() {}
    
    public Struttura(String Nome, String Indirizzo, String Citta, int Prezzo, String Categoria) {
        this.NomeStruttura = Nome;
        this.Indirizzo = Indirizzo;
        this.Citta = Citta;
        this.Prezzo = Prezzo;
        this.Categoria = Categoria;
    }
    
    public Struttura(int Codice, String Nome, String Indirizzo, String Citta, int Prezzo, String Categoria, String LinkImmagine) {
        this.IDStruttura = Codice;
        this.NomeStruttura = Nome;
        this.Indirizzo = Indirizzo;
        this.Citta = Citta;
        this.Prezzo = Prezzo;
        this.Categoria = Categoria;
        this.LinkImmagine = LinkImmagine;
    }
    
    public String toString() {
        String RangePrezzo = "€";
        if(Prezzo == 1) {
            RangePrezzo = "€";
        } else if (Prezzo == 2) {
            RangePrezzo = "€€";
        } else if (Prezzo == 3) {
            RangePrezzo = "€€€";
        }
        return ""+NomeStruttura+", "+Indirizzo+", "+Citta+", "+Categoria+", "+RangePrezzo+"";
    }
    
    public void setURLFoto(String URL) {
        LinkImmagine = URL;
    }
    
    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }
    
    public String getURLFoto() {
        return LinkImmagine;
    }
    
    public void setFoto(File Foto) {
        FotoStruttura = Foto;
    }
    
    public File getFoto() {
        return FotoStruttura;
    }
    
    public String getCitta() {
        return Citta;
    }
    
    public void setPrezzo(int Prezzo) {
        this.Prezzo = Prezzo;
    }
    
    public void setCitta(String Citta) {
        this.Citta = Citta;
    }
    
    public String getCategoria() {
        return Categoria;
    }
    
    public int getPrezzo() {
        return Prezzo;
    }
    
    public String getNomeStruttura() {
        return NomeStruttura;
    }
    
    public void setNomeStruttura(String nome) {
        NomeStruttura = nome;
    }
    
    public String getIndirizzo() {
        return Indirizzo;
    }
    
    public void setIndirizzo(String Indirizzo) {
        this.Indirizzo = Indirizzo;
    }
    
    public void setIDStruttura(int IDStruttura) {
        this.IDStruttura = IDStruttura;
    }
    
    public int getIDStruttura() {
        return IDStruttura;
    }
}
