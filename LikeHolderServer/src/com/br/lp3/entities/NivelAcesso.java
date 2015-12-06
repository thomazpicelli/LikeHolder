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
@Table(name = "NIVEL_ACESSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NivelAcesso.findAll", query = "SELECT n FROM NivelAcesso n"),
    @NamedQuery(name = "NivelAcesso.findByCdNivel", query = "SELECT n FROM NivelAcesso n WHERE n.cdNivel = :cdNivel"),
    @NamedQuery(name = "NivelAcesso.findByNmNivel", query = "SELECT n FROM NivelAcesso n WHERE n.nmNivel = :nmNivel")})
public class NivelAcesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_NIVEL")
    private Integer cdNivel;
    @Basic(optional = false)
    @Column(name = "NM_NIVEL")
    private String nmNivel;

    public NivelAcesso() {
    }

    public NivelAcesso(Integer cdNivel) {
        this.cdNivel = cdNivel;
    }

    public NivelAcesso(Integer cdNivel, String nmNivel) {
        this.cdNivel = cdNivel;
        this.nmNivel = nmNivel;
    }

    public Integer getCdNivel() {
        return cdNivel;
    }

    public void setCdNivel(Integer cdNivel) {
        this.cdNivel = cdNivel;
    }

    public String getNmNivel() {
        return nmNivel;
    }

    public void setNmNivel(String nmNivel) {
        this.nmNivel = nmNivel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdNivel != null ? cdNivel.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NivelAcesso)) {
            return false;
        }
        NivelAcesso other = (NivelAcesso) object;
        if ((this.cdNivel == null && other.cdNivel != null) || (this.cdNivel != null && !this.cdNivel.equals(other.cdNivel))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.NivelAcesso[ cdNivel=" + cdNivel + " ]";
    }
    
}
