/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw.test;

import com.ingsw.Struttura;
import com.ingsw.StrutturaDAOJDBC;
import com.sun.org.apache.bcel.internal.generic.AALOAD;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import com.ingsw.StrutturaDAO;

/**
 *
 * @author Marco
 */
public class StrutturaDAOTest {
    
    StrutturaDAO DAOStruttura;
    
    public StrutturaDAOTest() {    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        DAOStruttura = new StrutturaDAOJDBC();
        DAOStruttura.setConnection();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void addStrutturaCorrettamenteTest() {
        /*Questo test verifica la funzionalità di aggiunta di una Struttura al database, prima di eseguirlo assicurarsi che il database
          remoto sia raggiungibile dall'applicativo.
          Prima di lanciarlo verificare che la struttura campione non sia già presente nel database, altrimenti si verificherà un errore
          al momento dell'inserimento.
        */
        
        //Verrà creata una struttura da caricare ai fini del test.
        Struttura StrutturaDaInserire;
        StrutturaDaInserire = new Struttura();
        StrutturaDaInserire.setNomeStruttura("Caffè Brazil");
        StrutturaDaInserire.setIndirizzo("Corso Giuseppe Garibaldi, 169");
        StrutturaDaInserire.setCitta("Napoli");
        StrutturaDaInserire.setCategoria("Bar");
        StrutturaDaInserire.setPrezzo(1);
        StrutturaDaInserire.setURLFoto("");
        
        int ret = DAOStruttura.createStruttura(StrutturaDaInserire);
        assertEquals(1, ret);
        
    }
    
    @Test
    public void addStrutturaSenzaNomeTest() {
        /*Questo test verifica che qualora si dovesse provare ad aggiungere una struttura senza il nome,
          il metodo fallirà e ritornerà un valore che indica il fallimento del caricamento.            
        */
        //Verrà creata una struttura da caricare ai fini del test.
        Struttura StrutturaDaInserire;
        StrutturaDaInserire = new Struttura();
        StrutturaDaInserire.setIndirizzo("Via Toledo, 10");
        StrutturaDaInserire.setCitta("Napoli");
        StrutturaDaInserire.setCategoria("Bar");
        StrutturaDaInserire.setPrezzo(1);
        
        int ret = DAOStruttura.createStruttura(StrutturaDaInserire);
        
        //L'inserimento non dovrebbe andare a buon fine, in quanto manca un campo necessario.
        assertNotEquals(1, ret);
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
