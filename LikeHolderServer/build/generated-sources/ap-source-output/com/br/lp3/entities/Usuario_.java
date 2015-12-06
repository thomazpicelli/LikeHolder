package com.br.lp3.entities;

import com.br.lp3.entities.Interesse;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-20T22:15:49")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> nmUsername;
    public static volatile SingularAttribute<Usuario, String> dcEmail;
    public static volatile SingularAttribute<Usuario, Integer> cdUsuario;
    public static volatile SingularAttribute<Usuario, String> nmUsuario;
    public static volatile SingularAttribute<Usuario, Integer> cdNivel;
    public static volatile CollectionAttribute<Usuario, Interesse> interesseCollection;
    public static volatile SingularAttribute<Usuario, String> nmPassword;

}