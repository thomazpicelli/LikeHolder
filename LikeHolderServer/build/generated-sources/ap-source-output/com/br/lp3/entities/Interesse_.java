package com.br.lp3.entities;

import com.br.lp3.entities.CategoriaInteresse;
import com.br.lp3.entities.InteressePK;
import com.br.lp3.entities.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-20T22:15:49")
@StaticMetamodel(Interesse.class)
public class Interesse_ { 

    public static volatile SingularAttribute<Interesse, Integer> cdCodigoApi;
    public static volatile SingularAttribute<Interesse, InteressePK> interessePK;
    public static volatile SingularAttribute<Interesse, CategoriaInteresse> categoriaInteresse;
    public static volatile SingularAttribute<Interesse, Usuario> usuario;

}