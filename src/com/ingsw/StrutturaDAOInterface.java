/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public interface StrutturaDAOInterface {
    
    public void setConnection();
    public ArrayList<Struttura> getAllStrutture();
    public int updateStruttura(int ChiavePrimaria, Struttura PostModifica);
    public int creaStruttura(Struttura StrutturaDaCaricare);
    public int cancellaStruttura(int ChiavePrimaria);
    
}
