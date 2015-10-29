/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Banque;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;

/**
 *
 * @author SouFianE
 */
@Entity
abstract public  class CompteBancaireBis implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nom;
    protected String description;
    protected double solde;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @OrderBy("dateoperation ASC")
    private List<OperationBancaire> listeOpreration = new ArrayList<>();

    public List<OperationBancaire> getOperations() {
        return listeOpreration;
    }

    public void addOperation(String description, double montant) {
        OperationBancaire op = new OperationBancaire(description, montant);
        listeOpreration.add(op);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    
    public CompteBancaireBis() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CompteBancaireBis)) {
            return false;
        }
        CompteBancaireBis other = (CompteBancaireBis) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Banque.CompteBancaireBis[ id=" + id + " ]";
    }

    public CompteBancaireBis(String nom, double solde) {
        this.nom = nom;
        this.solde = solde;
        addOperation("Création du Compte", solde);
    }

    public void deposer_argent(double montant) {

        solde += montant;
        addOperation("Credit", montant);
    }

    public double retirer_argent(double montant) {

        if (montant < solde) {
            solde -= montant;
            addOperation("debit", montant);
            return montant;
        } else {
            return 0;
        }

    }

}
