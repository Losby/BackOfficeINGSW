/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingsw;

import java.io.File;
import java.sql.SQLException;


/**
 *
 * @author Marco
 */
public class ControllerSchermate {
    private final SchermataLogin Login;
    private final SchermataMenu Menu;
    private final SchermataGestioneStrutture GestioneStrutture;
    private final SchermataStruttureRegistrate ModificaStruttureRegistrate;
    private final SchermataModificaStruttura ModificaStruttura;
    private final SchermataInserimentoStruttura InserisciStruttura;
    private final SchermataInserisciFoto InserisciFoto;
    private final SchermataConfermaInserimentoStruttura ConfermaOperazioneInserimento;
    private final SchermataGestioneRecensioni GestisciRecensioni;
    private StrutturaDAO DAOStruttura;
    private RecensioneDAO DAORecensione;
    private static Struttura StrutturaDaInserire;
    private final AWSUploader UploaderAWS;
    
    public ControllerSchermate() {
        super();
        Login = new SchermataLogin(this);
        Menu = new SchermataMenu(this);
        GestioneStrutture = new SchermataGestioneStrutture(this);
        ModificaStruttureRegistrate = new SchermataStruttureRegistrate(this);
        ModificaStruttura = new SchermataModificaStruttura(this);
        InserisciStruttura = new SchermataInserimentoStruttura(this);
        InserisciFoto = new SchermataInserisciFoto(this);
        ConfermaOperazioneInserimento = new SchermataConfermaInserimentoStruttura(this);
        GestisciRecensioni = new SchermataGestioneRecensioni(this);
        UploaderAWS = new AWSUploader();
    }
    
    public static void main(String args[]) {
       ControllerSchermate controller = new ControllerSchermate();
       controller.run();     
    }
    
    private void run() {
        login();
        Menu.setVisible(true);
    }
    
    public void login(){
        DAOStruttura = StrutturaDAOFactory.getDAOStruttura("jdbc");
        DAORecensione = RecensioneDAOFactory.getDAORecensione("jdbc");
        DAOStruttura.setConnection();
        DAORecensione.setConnection();
        }
    
    public void showMenu() {
        Menu.setVisible(true);
    }
    
    public String caricaFoto(File Foto) {
        return UploaderAWS.caricaFoto(Foto);
    }
    
    public void showStruttureRegistrate(String Operazione) {
        ModificaStruttureRegistrate.setOperazione(Operazione);
        ModificaStruttureRegistrate.elencaStrutture(DAOStruttura.getAllStrutture());
        ModificaStruttureRegistrate.setVisible(true);
    }
    
    public void modificaStruttura(int ChiavePrimaria, Struttura PostModifica) throws SQLException {
        DAOStruttura.updateStruttura(ChiavePrimaria, PostModifica);
    }
    
    public void eliminaStruttura(int ChiavePrimaria) {
        DAOStruttura.deleteStruttura(ChiavePrimaria);
    }
    
    public void showGestioneStrutture() {
        GestioneStrutture.setVisible(true);
    }
        
    public void showGestioneRecensioni(Struttura StrutturaDaGestire) {
        GestisciRecensioni.setStruttura(StrutturaDaGestire);
        GestisciRecensioni.riempiPanel(DAORecensione.getAllRecensioni(StrutturaDaGestire.getIDStruttura()));
        GestisciRecensioni.setVisible(true);
    }
    
    public void showModificaStruttura(Struttura Struttura) {
        ModificaStruttura.setStruttura(Struttura);
        ModificaStruttura.setVisible(true);
    }
    
    public void showInserisciStruttura() {
        InserisciStruttura.setVisible(true);
    }
    
    public void showInserisciStruttura(File Foto) {
        StrutturaDaInserire.setFoto(Foto);
        InserisciStruttura.setVisible(true);
    }
    
    public void showInserisciFoto(String Nome, String Indirizzo, String Citta, String Categoria, int Prezzo) {
        StrutturaDaInserire = new Struttura(Nome, Indirizzo, Citta, Prezzo, Categoria);
        InserisciFoto.setVisible(true);
    }
    
    public void showConfermaInserimento() {
        ConfermaOperazioneInserimento.riempiDati(StrutturaDaInserire.getNomeStruttura(), StrutturaDaInserire.getIndirizzo(), StrutturaDaInserire.getCitta(), StrutturaDaInserire.getCategoria(), StrutturaDaInserire.getPrezzo(), StrutturaDaInserire.getFoto());
        ConfermaOperazioneInserimento.setVisible(true);
    }
    
    public boolean checkCredenziali(String ID, String Password) {
        return (ID.equals("admin") && Password.equals("password"));
    }
    
    public int confermaInsert() {
        StrutturaDaInserire.setURLFoto(UploaderAWS.caricaFoto(StrutturaDaInserire.getFoto()));
        int ret = DAOStruttura.createStruttura(StrutturaDaInserire);
        
        return ret;
    }
    
    public void setFoto(File Foto) {
        StrutturaDaInserire.setFoto(Foto);
    }
    
    public void eliminaRecensione(int CodiceRecensione) {
        DAORecensione.deleteRecensione(CodiceRecensione);
    }
    
    public void approvaRecensione(Recensione DaApprovare) {
        DAORecensione.approvaRecensione(DaApprovare);
    }
    
    public void fineInserimento() {
        InserisciStruttura.svuotaCampi();
        InserisciFoto.svuotaCampi();
    }
}
