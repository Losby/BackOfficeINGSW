/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw.test;

import com.ingsw.Struttura;
import com.ingsw.StrutturaDAOInterface;
import com.ingsw.StrutturaDAOJDBC;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Marco
 */
public class StrutturaDAOTest {
    
    StrutturaDAOInterface StrutturaDAO;
    
    public StrutturaDAOTest() {    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        StrutturaDAO = new StrutturaDAOJDBC();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addStrutturaCorrettamenteTest() throws SQLException {
        /*Questo test verifica la funzionalità di aggiunta di una Struttura al database, prima di eseguirlo assicurarsi che il database
          remoto sia raggiungibile dall'applicativo.
        */
        
        //Verrà creata una struttura da caricare ai fini del test.
        Struttura StrutturaDaInserire;
        StrutturaDaInserire = new Struttura();
        StrutturaDaInserire.setNomeStruttura("Caffè Brazil");
        StrutturaDaInserire.setIndirizzo("Corso Giuseppe Garibaldi, 169");
        StrutturaDaInserire.setCitta("Napoli");
        StrutturaDaInserire.setCategoria("Bar");
        StrutturaDaInserire.setPrezzo(1);
        
        try {
            int ret = StrutturaDAO.createStruttura(StrutturaDaInserire);
            assertEquals(1, ret);
        } catch (SQLException e) {
            fail("SQL exception: " + e.getMessage() + e.getSQLState() + e.getErrorCode());
        }
        
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
