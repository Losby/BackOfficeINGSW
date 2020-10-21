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
public class StrutturaDAOFactory {
    
    public static StrutturaDAOInterface getDAOStruttura(String TipoLibreria) {
        if(TipoLibreria == "jdbc") {
            return new StrutturaDAOJDBC();
        }
        else {
            return null;
        }
    }
}
