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
public class ControllerSchermate {
    private final SchermataLogin Login;
    private final SchermataMenu Menu;
    private final SchermataGestioneStrutture GestioneStrutture;
    private final SchermataStruttureRegistrate ModificaStruttureRegistrate;
    private final SchermataModificaStruttura ModificaStruttura;
    
    public ControllerSchermate() {
        super();
        Login = new SchermataLogin(this);
        Menu = new SchermataMenu(this);
        GestioneStrutture = new SchermataGestioneStrutture(this);
        ModificaStruttureRegistrate = new SchermataStruttureRegistrate(this);
        ModificaStruttura = new SchermataModificaStruttura(this);
    }
    
    public static void main(String args[]) {
        ControllerSchermate controller = new ControllerSchermate();
        controller.run();
    }
    
    private void run() {
        Login.setVisible(true);
    }
    
    public void login(){
        Login.setVisible(false);
        Menu.setVisible(true);
    }
    
    public void showMenu() {
        Menu.setVisible(true);
    }
    
    public void showStruttureRegistrate() {
        ModificaStruttureRegistrate.setVisible(true);
    }
    
    public void showGestioneStrutture() {
        GestioneStrutture.setVisible(true);
    }
    
    public void logout() {
        Login.setVisible(true);
    }
    
    public void showModificaStruttura() {
        ModificaStruttura.setVisible(true);
    }
    
    
}
