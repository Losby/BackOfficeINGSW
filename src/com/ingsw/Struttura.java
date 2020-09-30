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
public class Struttura {
    private String NomeStruttura;
    private String Indirizzo;
    private String Prezzo;
    private String Categoria;
    private int IDStruttura;
    
    public Struttura() {}
    
    public Struttura(String Nome, String Indirizzo, String Prezzo, String Categoria) {
        this.NomeStruttura = Nome;
        this.Indirizzo = Indirizzo;
        this.Prezzo = Prezzo;
        this.Categoria = Categoria;
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
    
    public void setIDStruttura(int IDStruttura) {
        this.IDStruttura = IDStruttura;
    }
    
    public int getIDStruttura() {
        return IDStruttura;
    }
}
