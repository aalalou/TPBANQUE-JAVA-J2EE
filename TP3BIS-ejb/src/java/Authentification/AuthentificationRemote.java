/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentification;

import javax.ejb.Remote;

/**
 *
 * @author SouFianE
 */
@Remote
public interface AuthentificationRemote {
    
    public boolean authentification(String login,String password);
    
}
