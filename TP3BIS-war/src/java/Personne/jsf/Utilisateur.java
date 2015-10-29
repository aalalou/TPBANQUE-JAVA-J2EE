/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personne.jsf;

/**
 *
 * @author SouFianE
 */
public class Utilisateur {
    
    private String login;
    protected String password;
    private final String nom;
    private final String prenom;

    Utilisateur(String nom, String prenom) {
        this.nom=nom;
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    
}
