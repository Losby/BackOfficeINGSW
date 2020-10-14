/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Marco
 */
public class RecensioneDAOJDBC implements RecensioneDAOInterface {

    private final String SQLSelect = "SELECT `cod_recensione`,\n" +
        "`numero_stelle`,\n" +
        "`descrizione_testuale`,\n" +
        "`utente`\n" +
        "FROM `recensione_da_approvare`\n" +
        "WHERE `codice_struttura` = ? ;";
    
    private final String SQLDelete = "DELETE FROM `recensione_da_approvare`\nWHERE `cod_recensione` = ?;";
    private final String SQLInsert = "INSERT INTO `recensione_approvata`\n" +
        "(`utente`,\n" +
        "`numero_stelle`,\n" +
        "`descrizione_testuale`,\n" +
        "`codice_struttura`)\n" +
        "VALUES\n" +
        "(?, ?, ?, ?);";
    
    private Connection Connessione;
    
    public RecensioneDAOJDBC() {}
    public RecensioneDAOJDBC(Connection Connessione) {
        this.Connessione = Connessione;
    }
    
    public void setConnection(Connection Connessione) {
        this.Connessione = Connessione;
    }
    
    @Override
    public ArrayList<Recensione> getAllRecensioni(int CodiceStruttura) {
        PreparedStatement PrepStat;
        ResultSet rsRecensioni;
        if (CodiceStruttura > 0) {
            
            try {
                PrepStat = Connessione.prepareStatement(SQLSelect);
                PrepStat.setInt(1, CodiceStruttura);
                rsRecensioni = PrepStat.executeQuery();
            } catch (SQLException ex) {
                Logger.getLogger(StrutturaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            
            ArrayList<Recensione> ListaRecensioni;
            
            try {
                ListaRecensioni = riempiListaRecensioni(rsRecensioni, CodiceStruttura);
                return ListaRecensioni;
                
            } catch (SQLException ex) {
                Logger.getLogger(StrutturaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }
    
    private ArrayList<Recensione> riempiListaRecensioni(ResultSet rs, int CodStruttura) throws SQLException {
        if(rs != null) {
            ArrayList<Recensione> Lista = new ArrayList<>();
        
            while(rs.next()) {
                int CodiceRecensione = rs.getInt("cod_recensione");
                float NumeroStelle = rs.getFloat("numero_stelle");
                String Descrizione = rs.getString("descrizione_testuale");
                String Utente = rs.getString("utente");
                
                Recensione temp = new Recensione(CodiceRecensione, NumeroStelle, Descrizione, CodStruttura, Utente);
            
                Lista.add(temp);
            }
        
            return Lista;
        }
        return null;
    }

    @Override
    public int deleteRecensione(int CodiceRecensione) {
        int ret = -1;
        
        try {
            PreparedStatement prepStat = Connessione.prepareStatement(SQLDelete);
            prepStat.setInt(1, CodiceRecensione);
            
            ret = prepStat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StrutturaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public void approvaRecensione(Recensione DaApprovare) {
        if(DaApprovare != null) {
            try {
                PreparedStatement PrepStat = Connessione.prepareStatement(SQLInsert);
                PrepStat.setString(1, DaApprovare.getUser());
                PrepStat.setFloat(2, DaApprovare.getNumeroStelle());
                PrepStat.setString(3, DaApprovare.getDescrizione());
                PrepStat.setInt(4, DaApprovare.getCodiceStruttura());
                
                PrepStat.executeUpdate();                
            } catch (SQLException ex) {
                Logger.getLogger(RecensioneDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }            
        }
    }
    
}
