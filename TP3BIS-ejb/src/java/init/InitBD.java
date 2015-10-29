/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package init;

import Session.GestionnaireCompteBancaire;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Startup;

/**
 *
 * @author SouFianE
 */
@Singleton
@LocalBean
@Startup
public class InitBD {
    @EJB
    private GestionnaireCompteBancaire gestionnaireCompteBancaire;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PostConstruct
    public void init(){
    System.out.println("##BD REMPLIE##");
    gestionnaireCompteBancaire.creercomptedeTest();
    }
}
