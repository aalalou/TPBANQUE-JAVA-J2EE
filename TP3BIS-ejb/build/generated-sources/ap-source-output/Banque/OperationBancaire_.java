package Banque;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-10-29T01:02:39")
@StaticMetamodel(OperationBancaire.class)
public class OperationBancaire_ { 

    public static volatile SingularAttribute<OperationBancaire, String> description;
    public static volatile SingularAttribute<OperationBancaire, Date> dateoperation;
    public static volatile SingularAttribute<OperationBancaire, Double> montant;
    public static volatile SingularAttribute<OperationBancaire, Long> id;

}