/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import javax.ejb.Stateless;

/**
 *
 * @author SouFianE
 */
@Stateless
public class AuthentificationBean implements Authentification.AuthentificationRemote{

    @Override
    public boolean authentification(String login, String password) {
       
       return  "admin".equals(login) && "toto".equals(password);
    }
    
    
    
    
}
