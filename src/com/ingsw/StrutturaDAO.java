/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Marco
 */
public interface StrutturaDAO {
    
    public void setConnection();
    public ArrayList<Struttura> getAllStrutture();
    public int updateStruttura(int ChiavePrimaria, Struttura PostModifica) throws SQLException;
    public int createStruttura(Struttura StrutturaDaCaricare);
    public int deleteStruttura(int ChiavePrimaria);
    
}
