 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.sql.Connection;
import java.sql.DriverManager;
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
public class StrutturaDAOJDBC implements StrutturaDAO {

    private Connection Connessione;
    private final String SQLInsert = "INSERT INTO `struttura` (`nome`, `indirizzo`, `città`, `tipo_struttura`, `range_prezzo`, `link_immagine`, `latitudine`, `longitudine` ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private final String SQLUpdate = "UPDATE `struttura`\n" +
        "SET\n" +
        "`indirizzo` = ?,\n" +
        "`città` = ?,\n" +
        "`range_prezzo` = ?,\n" + "`link_immagine` = ?\n" +
        "WHERE `cod_struttura` = ?;";
    private final String SQLDelete = "DELETE FROM `struttura` WHERE `cod_struttura` = ?";
    
    private GoogleAPIClient Geocoder;
    
    public StrutturaDAOJDBC() { 
        Geocoder = new GoogleAPIClient();
    }
    
    @Override
    public void setConnection() {
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbName = "consiglia_viaggiDB";
                String userName = "ingsw_master";
                String password = "consigliaviaggi20";
                String hostname = "progetto-ingswdb.cqtyppoiia4t.us-east-2.rds.amazonaws.com";
                String port = "3306";
                String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
                Connection con = DriverManager.getConnection(jdbcUrl);
                System.out.println("Remote connection successful.\n");
                Connessione = con;
                return;
            }
            catch (ClassNotFoundException e) { 
                // logger.warn(e.toString());
                System.out.println("Class not found.\n");
            }
            catch (java.sql.SQLException ex) { 
                //logger.warn(e.toString());
                Logger.getLogger(StrutturaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        System.out.println(("Connection is null.\n"));
        Connessione = null;
        return;
  }
  
    public Connection getConnection() {
        return Connessione;
    }

    @Override
    public ArrayList<Struttura> getAllStrutture() {
        Statement stmt;
        ResultSet rsStrutture;
        
        try {
            stmt = Connessione.createStatement();
            rsStrutture = stmt.executeQuery("SELECT cod_struttura, nome, indirizzo, città, range_prezzo, tipo_struttura, link_immagine\n" +
"FROM `consiglia_viaggiDB`.`struttura`;");
        } catch (SQLException ex) {
            Logger.getLogger(StrutturaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        //fills the list with the data from the resultset
        ArrayList<Struttura> ListaStrutture;
        try {
            ListaStrutture = riempiListaStrutture(rsStrutture);
            return ListaStrutture;
        } catch (SQLException ex) {
            Logger.getLogger(StrutturaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    private ArrayList<Struttura> riempiListaStrutture(ResultSet rs) throws SQLException {
        ArrayList<Struttura> Lista = new ArrayList<>();
        
        while(rs.next()) {
            int CodiceStruttura = rs.getInt("cod_struttura");
            String Nome = rs.getString("nome");
            String Indirizzo = rs.getString("indirizzo");
            String Citta = rs.getString("città");
            int Prezzo = rs.getInt("range_prezzo");
            String Categoria = rs.getString("tipo_struttura");
            String LinkImmagine = rs.getString("link_immagine");
            
            Struttura temp = new Struttura(CodiceStruttura, Nome, Indirizzo, Citta, Prezzo, Categoria, LinkImmagine);
            
            Lista.add(temp);
        }
        
        return Lista;
    }

    @Override
    public int updateStruttura(int ChiavePrimaria, Struttura PostModifica) {
        int ret = -1;
        try {
            PreparedStatement prepStat = Connessione.prepareStatement(SQLUpdate);
            prepStat.setString(1, PostModifica.getIndirizzo());
            prepStat.setString(2, PostModifica.getCitta());
            prepStat.setInt(3, PostModifica.getPrezzo());
            prepStat.setString(4, PostModifica.getURLFoto());
            prepStat.setInt(5, ChiavePrimaria);
            
            ret = prepStat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StrutturaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    @Override
    public int createStruttura(Struttura StrutturaDaCaricare) {
        int ret = -1;
        try {
            PreparedStatement prepStat = Connessione.prepareStatement(SQLInsert);
            prepStat.setString(1, StrutturaDaCaricare.getNomeStruttura());
            prepStat.setString(2, StrutturaDaCaricare.getIndirizzo());
            prepStat.setString(3, StrutturaDaCaricare.getCitta());
            prepStat.setString(4, StrutturaDaCaricare.getCategoria());
            prepStat.setInt(5, StrutturaDaCaricare.getPrezzo());
            prepStat.setString(6, StrutturaDaCaricare.getURLFoto());
            
            String[] Coordinate = Geocoder.getLatLongPositions(""+StrutturaDaCaricare.getNomeStruttura()+", "+StrutturaDaCaricare.getIndirizzo()+", "+StrutturaDaCaricare.getCitta()+"");
            
            prepStat.setString(7, Coordinate[0]);
            prepStat.setString(8, Coordinate[1]);
            
            ret = prepStat.executeUpdate();
        } catch (SQLException ex) {
            ret = -1;
        } catch (Exception ex) {   
            ret = -2;
        }
        return ret;
    }

    @Override
    public int deleteStruttura(int ChiavePrimaria) {
        int ret = -1;
        
        try {
            PreparedStatement prepStat = Connessione.prepareStatement(SQLDelete);
            prepStat.setInt(1, ChiavePrimaria);
            
            ret = prepStat.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StrutturaDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
}
