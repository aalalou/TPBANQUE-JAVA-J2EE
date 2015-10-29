/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Banque.CompteBancaireBis;
import Banque.OperationBancaire;
import Session.GestionnaireCompteBancaire;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

/**
 *
 * @author SouFianE
 */
@Named
@ViewScoped
public class OperationMbean implements Serializable{
    @EJB
    private GestionnaireCompteBancaire gcb;
    private  LazyDataModel l1;

    public OperationMbean() {
        
         l1 = new LazyDataModel<OperationBancaire>() {

                   @Override
                    public List<OperationBancaire> load(int start, int nb, String nomChamp, SortOrder so,Map map) {
                        // A ecrire
                        System.out.println("### load : start ="+ start + " nb = "+ nb + "nom colonne = " + nomChamp);
                        if(nomChamp != null) {
                            if(nomChamp.equals("nom")) {
                                // Il faut trier
                                System.out.println("Tri: champ= " + 
                                        nomChamp + " ordre: " +so.name());
                                return gcb.getOperationsTriesParDescpriton(start, nb, nomChamp);
                            }
                        } else {
                            // Juste la pagination, pas de tri, de filtre
                            return gcb.getOperation(start, nb);
                        }
                        return null;
                    }

                    @Override
                    public int getRowCount() {
                        return (int) gcb.getNombreOperation();
                    }
                };
    }
    


     public LazyDataModel getLazyOperationBancaires() {
        return l1;
    }
     
    private CompteBancaireBis compte;
    private long id;

    public CompteBancaireBis getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaireBis compte) {
        this.compte = compte;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        System.out.println("SET ID = " + id);
        this.id = id;
    }
    
    
    
 public List<OperationBancaire> getOperationsBancaires() {
     System.out.println("GET OPERATIONS BANCAIRES");
        return gcb.getOperationsDuCompte(id);
    }
    
 

    
}
