/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SessionBean;

import Banque.CompteBancaireBis;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;
import Session.GestionnaireCompteBancaire;
import static com.sun.javafx.logging.PulseLogger.addMessage;
import java.awt.event.ActionEvent;
import java.util.Locale;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author SouFianE
 */
@Named
@ViewScoped
public class BeancompteBancaire implements Serializable {
    
    @EJB
    private GestionnaireCompteBancaire gcb;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    private long idCompteADebiter;
    private long idCompteACrediter;
    private double montantACrediter;
    private double montantADebiter;
    private long id1;
    private long id2;
    private double montantTransfert;
    private String message;
    private CompteBancaireBis compte;
    private  LazyDataModel lazyModelComptesBancaires;
    private List<CompteBancaireBis> listeDesComptes;
    
    	//sup
    private List<CompteBancaireBis> selectedComptes;
    
    
    
    private List<CompteBancaireBis> filtreComptes;

    public List<CompteBancaireBis> getListeDesComptes() {
        return listeDesComptes;
    }

    public void setListeDesComptes(List<CompteBancaireBis> listeDesComptes) {
        this.listeDesComptes = listeDesComptes;
    }
    
    public void buttonAction(ActionEvent actionEvent) {
        addMessage("Welcome to Primefaces!!");
    }
     
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary,  null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

  
    
    

    
    public BeancompteBancaire() {
        // On creer une instance du LazyDataModel
        lazyModelComptesBancaires = new LazyDataModel<CompteBancaireBis>() {

                   @Override
                    public List<CompteBancaireBis> load(int start, int nb, String nomChamp, SortOrder so,Map map) {
                        // A ecrire
                        System.out.println("### load : start ="+ start + " nb = "+ nb + "nom colonne = " + nomChamp);
                        if(nomChamp != null) {
                            if(nomChamp.equals("nom")) {
                                // Il faut trier
                                System.out.println("Tri: champ= " + 
                                        nomChamp + " ordre: " +so.name());
                                return gcb.getComptesTriesParNom(start, nb, so.name());
                            }
                        } else {
                            // Juste la pagination, pas de tri, de filtre
                            return gcb.getComptes(start, nb); 
                        }
                        return null;
                    }

                    @Override
                    public int getRowCount() {
                        return (int) gcb.getNombreDeComptes();
                    }
                };
    }

   
    
     public List<CompteBancaireBis> getComptesBancairesBbis() {
        if (listeDesComptes == null) {
            refreshListeDesComptes();
        }
        return listeDesComptes;
    }
    
    
    
 public LazyDataModel getLazyCompteBancaires() {
        return lazyModelComptesBancaires;
    }
 
  private void refreshListeDesComptes() {
        listeDesComptes = gcb.getAllComptes();
        System.out.println("On FAIT FINDALL");
    }

    public CompteBancaireBis getCompte() {
        return compte;
    }

    public void setCompte(CompteBancaireBis compte) {
        this.compte = compte;
    }
    
    

  

    public long getIdCompteADebiter() {
        return idCompteADebiter;
    }

    public void setIdCompteADebiter(long idCompteADebiter) {
        this.idCompteADebiter = idCompteADebiter;
    }

    public long getIdCompteACrediter() {
        return idCompteACrediter;
    }

    public void setIdCompteACrediter(long idCompteACrediter) {
        this.idCompteACrediter = idCompteACrediter;
    }

    public double getMontantACrediter() {
        return montantACrediter;
    }

    public void setMontantACrediter(double montantACrediter) {
        this.montantACrediter = montantACrediter;
    }

    public double getMontantADebiter() {
        return montantADebiter;
    }

    public void setMontantADebiter(double montantADebiter) {
        this.montantADebiter = montantADebiter;
    }

    public long getId1() {
        return id1;
    }

    public void setId1(long id1) {
        this.id1 = id1;
    }

    public long getId2() {
        return id2;
    }

    public void setId2(long id2) {
        this.id2 = id2;
    }

    public double getMontantTransfert() {
        return montantTransfert;
    }

    public void setMontantTransfert(double montantTransfert) {
        this.montantTransfert = montantTransfert;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    public void creerCompteTest(){
        System.out.println("#Compte Crée Avec Succés");
        gcb.creercomptedeTest();
        refreshListeDesComptes();
    }
    
    public List<CompteBancaireBis> getComptesBancaires (){

    return gcb.getAllComptes();
}
    
    public void debiterCompte(){
        gcb.debiterUnCompte(idCompteADebiter, montantADebiter);
                addMessage("dedrfrg");

        refreshListeDesComptes();
    
    }
    
    
    public void crediterCompte(){
    gcb.crediterUnCompte(idCompteACrediter,montantACrediter);
        addMessage("dedrfrg");
    refreshListeDesComptes();
    }
    
    public void transferer() {
        
        try {
            gcb.transferer(id1, id2, montantTransfert);
          System.out.println("OK" + id1+" "+ id2 +" "+montantTransfert+ " "+montantACrediter+" "+montantADebiter);
          addMessage("dedrfrg");
          refreshListeDesComptes();
            
        } catch(Exception e) {
            message = "Transfert impossible, pas assez d'argent";
            System.out.println("### PAS ASSEZ d'argent");
            refreshListeDesComptes();
        }
    }
    
      
       
         public void supprimerCompte(CompteBancaireBis c) {
        System.out.println("### Suppression du compte " + c.getId());
        gcb.supprimerCompte(c);
    }
    
    	//sup
	 public void supprimer() {
			 for(CompteBancaireBis c:selectedComptes)
			 {
			 System.out.println("### Suppression du compte " + c.getId());
				gcb.supprimerCompte(c);
                              
			 }
                           addMessage("dedrfrg");
        
    }
         
             //sup
public List<CompteBancaireBis> getComptesBancairesBis() {
      
        return selectedComptes;
    }
	//sup
	public void setComptesBancairesBis(List<CompteBancaireBis> liste) {
        selectedComptes=liste;
    }

    public List<CompteBancaireBis> getSelectedComptes() {
        return selectedComptes;
    }

    public void setSelectedComptes(List<CompteBancaireBis> selectedComptes) {
        this.selectedComptes = selectedComptes;
    }
        
public List<CompteBancaireBis> getFiltreComptes(){
return filtreComptes;
} 
public void setFiltreCompte(List<CompteBancaireBis> filtreComptes){
this.filtreComptes=filtreComptes;
}



         
         
    
}
