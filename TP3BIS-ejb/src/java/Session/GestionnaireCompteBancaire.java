/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Session;

import Banque.CompteBancaireBis;
import Banque.CompteCourant;
import Banque.CompteEpargne;
import Banque.OperationBancaire;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author SouFianE
 */
@Stateless
@LocalBean
public class GestionnaireCompteBancaire {
    
     @PersistenceContext
    private EntityManager em;
     

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
     
     public GestionnaireCompteBancaire(){
     
     }
     
     public void creerUnCompte(String Nom, double Salaire) {
        CompteBancaireBis c = new CompteCourant(Nom, Salaire);
        em.persist(c);
    }
     
      public void creerCompte(CompteBancaireBis c) {
        em.persist(c);
        
    }
      
      public List<CompteBancaireBis> getComptes(int start, int nb) {
        Query q = em.createQuery("select c from CompteBancaireBis c");
        q.setFirstResult(start);
        q.setMaxResults(nb);
        return q.getResultList();
    }
      
       public List<OperationBancaire> getOperation(int start, int nb) {
        Query q = em.createQuery("select oc from OperationBancaire oc");
        q.setFirstResult(start);
        q.setMaxResults(nb);
        return q.getResultList();
    }
       
       public long getNombreOperation() {
         Query q = em.createQuery("select count(oc) from OperationBancaire oc"); 
         return (long) q.getSingleResult();
      }
      
      public long getNombreDeComptes() {
         Query q = em.createQuery("select count(c) from CompteBancaireBis c"); 
         return (long) q.getSingleResult();
      }

    public void creercomptedeTest() {

        creerUnCompte("Soufiane AALLOU", 10100);
        creerUnCompte("Sarag Ghalam", 13000);
        creerUnCompte("zakari Jimy", 170000);
        creerUnCompte("Immad Bounar", 180000);
        
      for(int i=0; i < 2000; i++) {
            String nom = "Proprio" + i;
            double solde = Math.round(Math.random() * 100);
            creerCompte(new CompteCourant(nom, solde));
        }
      
       for(int i=0; i < 2000; i++) {
           double taux=1+5*Math.random();
            String nom = "Proprio" + i;
            double solde = Math.round(Math.random() * 100);
            creerCompte(new CompteEpargne(nom, solde,taux));
        }

    }

    public List<CompteBancaireBis> getAllComptes() {
        Query q = em.createQuery("select c from CompteBancaireBis c");
        return q.getResultList();
    }

    public void persist(Object object) {
        em.persist(object);
    }
    
    
    public void crediterUnCompte(long id, double montant) {
        
        CompteBancaireBis c = em.find(CompteBancaireBis.class, id);
      
        c.retirer_argent(montant);
    }
    
    public void debiterUnCompte(long id, double montant) {
        // On va chercher un compte dans la base, il est connecté
        CompteBancaireBis c = em.find(CompteBancaireBis.class, id);
        // On update juste en faisant solde-=montant
        c.deposer_argent(montant);
    }
    
    public void transferer(long id1, long id2, double montant) {
        debiterUnCompte(id1, montant);
        crediterUnCompte(id2, montant);
    }
    
    public List<OperationBancaire> getOperationsDuCompte(long id){
        CompteBancaireBis c = em.find(CompteBancaireBis.class, id);
        System.out.println("getOperations id = " + id + " nb operations = " + c.getOperations().size());
        return c.getOperations();
    
    }
    
    public void supprimerCompte(CompteBancaireBis c) {
        // Le compte n'est peut-être pas connecté
        em.remove(em.merge(c));
    }
    
       public void supprimerCompteparId(int id) {
        CompteBancaireBis c = em.find(CompteBancaireBis.class, id);
        em.remove(c);
    }
       
       
       public List<CompteBancaireBis> getComptesTriesParNom(int start, int nb, String order) {
        String orderValue = "";
          if(order.equals("ASCENDING")) {
              orderValue = "ASC";
         } else {
              orderValue = "DESC";
          }
          String r = "select c from CompteBancaireBis c order by c.nom " 
                + orderValue;
          System.out.println("TRI PAR NOM: " + r);
          Query q = em.createQuery(r);
        q.setFirstResult(start);
        q.setMaxResults(nb);
        return q.getResultList();
    }
       
        public List<OperationBancaire> getOperationsTriesParDescpriton(int start, int nb, String order) {
        String orderValue = "";
          if(order.equals("ASCENDING")) {
              orderValue = "ASC";
         } else {
              orderValue = "DESC";
          }
          String r = "select c from OperationBancaire oc order by oc.description" 
                + orderValue;
          System.out.println("TRI PAR DESCRIPTION: " + r);
          Query q = em.createQuery(r);
        q.setFirstResult(start);
        q.setMaxResults(nb);
        return q.getResultList();
    }
 
    
    
}
