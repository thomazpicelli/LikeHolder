/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.br.lp3.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Thomaz
 */
@Entity
@Table(name = "CATEGORIA_INTERESSE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CategoriaInteresse.findAll", query = "SELECT c FROM CategoriaInteresse c"),
    @NamedQuery(name = "CategoriaInteresse.findByCdCategoriaInteresse", query = "SELECT c FROM CategoriaInteresse c WHERE c.cdCategoriaInteresse = :cdCategoriaInteresse"),
    @NamedQuery(name = "CategoriaInteresse.findByNmCategoriaInteresse", query = "SELECT c FROM CategoriaInteresse c WHERE c.nmCategoriaInteresse = :nmCategoriaInteresse")})
public class CategoriaInteresse implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_CATEGORIA_INTERESSE")
    private Integer cdCategoriaInteresse;
    @Basic(optional = false)
    @Column(name = "NM_CATEGORIA_INTERESSE")
    private String nmCategoriaInteresse;

    public CategoriaInteresse() {
    }

    public CategoriaInteresse(Integer cdCategoriaInteresse) {
        this.cdCategoriaInteresse = cdCategoriaInteresse;
    }

    public CategoriaInteresse(Integer cdCategoriaInteresse, String nmCategoriaInteresse) {
        this.cdCategoriaInteresse = cdCategoriaInteresse;
        this.nmCategoriaInteresse = nmCategoriaInteresse;
    }

    public Integer getCdCategoriaInteresse() {
        return cdCategoriaInteresse;
    }

    public void setCdCategoriaInteresse(Integer cdCategoriaInteresse) {
        this.cdCategoriaInteresse = cdCategoriaInteresse;
    }

    public String getNmCategoriaInteresse() {
        return nmCategoriaInteresse;
    }

    public void setNmCategoriaInteresse(String nmCategoriaInteresse) {
        this.nmCategoriaInteresse = nmCategoriaInteresse;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdCategoriaInteresse != null ? cdCategoriaInteresse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CategoriaInteresse)) {
            return false;
        }
        CategoriaInteresse other = (CategoriaInteresse) object;
        if ((this.cdCategoriaInteresse == null && other.cdCategoriaInteresse != null) || (this.cdCategoriaInteresse != null && !this.cdCategoriaInteresse.equals(other.cdCategoriaInteresse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.CategoriaInteresse[ cdCategoriaInteresse=" + cdCategoriaInteresse + " ]";
    }
    
}
