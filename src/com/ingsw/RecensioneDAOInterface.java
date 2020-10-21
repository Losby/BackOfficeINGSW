/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.sql.Connection;
import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public interface RecensioneDAOInterface {
    
    public void setConnection();
    public ArrayList<Recensione> getAllRecensioni(int CodiceStruttura);
    public int deleteRecensione(int CodiceRecensione);
    public void approvaRecensione(Recensione DaApprovare);
    
}
