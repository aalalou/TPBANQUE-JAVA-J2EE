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
public class CompteCourant extends CompteBancaireBis implements Serializable {
   

   




    @Override
    public String toString() {
        return "Banque.CompteCourant[ id=" + getId() + " ]";
    }

    public CompteCourant() {
    }

    public CompteCourant(String nom, double solde) {
        super(nom, solde);
        this.description="Courant";
    }
    
    
    
    
}
