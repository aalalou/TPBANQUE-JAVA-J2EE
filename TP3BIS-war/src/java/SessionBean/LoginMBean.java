/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author SouFianE
 */
@Named(value = "loginMBean")
@SessionScoped
public class LoginMBean implements Serializable {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String login;
    private String password;
    private boolean connected = false;
    @EJB
    private Authentification.AuthentificationRemote aut;

    public LoginMBean(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public LoginMBean() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        this.connected = connected;
    }

    public String authentification() {
        String chemin;

        if (aut.authentification(login, password)) {
            connected = true;
            System.out.println(connected);
            chemin = "index";
        } else {
            FacesMessage fm = new FacesMessage("Login or Password Invalid !!!");
            FacesContext.getCurrentInstance().addMessage("Msg", fm);
            connected = false;
            System.out.println(connected);
            chemin = "authentification";
        }
        return chemin;
    }
    
    public String deconnexion(){
        
        connected=false;
        return "authentification";
    
    }

}
