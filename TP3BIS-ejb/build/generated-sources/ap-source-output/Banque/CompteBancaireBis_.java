package Banque;

import Banque.OperationBancaire;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-29T01:02:39")
@StaticMetamodel(CompteBancaireBis.class)
public abstract class CompteBancaireBis_ { 

    public static volatile ListAttribute<CompteBancaireBis, OperationBancaire> listeOpreration;
    public static volatile SingularAttribute<CompteBancaireBis, String> description;
    public static volatile SingularAttribute<CompteBancaireBis, Double> solde;
    public static volatile SingularAttribute<CompteBancaireBis, Long> id;
    public static volatile SingularAttribute<CompteBancaireBis, String> nom;

}