/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banque;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author SouFianE
 */
@Entity
public class CompteEpargne extends CompteBancaireBis implements Serializable {

    public CompteEpargne() {
    }
    
    private double taux;

    public CompteEpargne(String nom, double solde,double taux) {
        super(nom, solde);
        this.description="Epargne";
        this.taux=taux;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }
    
     
    public void apptaux(){
       solde=solde*(1+taux);
    }

    @Override
    public String toString() {
        return "Banque.CompteEparge[ id=" + getId() + " ]";
    }
    
}
