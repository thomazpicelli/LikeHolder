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
@Table(name = "EVENTO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Evento.findAll", query = "SELECT e FROM Evento e"),
    @NamedQuery(name = "Evento.findByCdEvento", query = "SELECT e FROM Evento e WHERE e.cdEvento = :cdEvento"),
    @NamedQuery(name = "Evento.findByCdUsuario", query = "SELECT e FROM Evento e WHERE e.cdUsuario = :cdUsuario"),
    @NamedQuery(name = "Evento.findByDcId", query = "SELECT e FROM Evento e WHERE e.dcId = :dcId"),
    @NamedQuery(name = "Evento.findByDcUrl", query = "SELECT e FROM Evento e WHERE e.dcUrl = :dcUrl"),
    @NamedQuery(name = "Evento.findByDcTicket", query = "SELECT e FROM Evento e WHERE e.dcTicket = :dcTicket"),
    @NamedQuery(name = "Evento.findByDcLocal", query = "SELECT e FROM Evento e WHERE e.dcLocal = :dcLocal"),
    @NamedQuery(name = "Evento.findByDcCidade", query = "SELECT e FROM Evento e WHERE e.dcCidade = :dcCidade")})
public class Evento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_EVENTO")
    private Integer cdEvento;
    @Basic(optional = false)
    @Column(name = "CD_USUARIO")
    private int cdUsuario;
    @Basic(optional = false)
    @Column(name = "DC_ID")
    private String dcId;
    @Basic(optional = false)
    @Column(name = "DC_URL")
    private String dcUrl;
    @Basic(optional = false)
    @Column(name = "DC_TICKET")
    private String dcTicket;
    @Basic(optional = false)
    @Column(name = "DC_LOCAL")
    private String dcLocal;
    @Basic(optional = false)
    @Column(name = "DC_CIDADE")
    private String dcCidade;

    public Evento() {
    }

    public Evento(Integer cdEvento) {
        this.cdEvento = cdEvento;
    }

    public Evento(Integer cdEvento, int cdUsuario, String dcId, String dcUrl, String dcTicket, String dcLocal, String dcCidade) {
        this.cdEvento = cdEvento;
        this.cdUsuario = cdUsuario;
        this.dcId = dcId;
        this.dcUrl = dcUrl;
        this.dcTicket = dcTicket;
        this.dcLocal = dcLocal;
        this.dcCidade = dcCidade;
    }
    
    public Evento(int cdUsuario, String dcId, String dcUrl, String dcTicket, String dcLocal, String dcCidade) {
        this.cdUsuario = cdUsuario;
        this.dcId = dcId;
        this.dcUrl = dcUrl;
        this.dcTicket = dcTicket;
        this.dcLocal = dcLocal;
        this.dcCidade = dcCidade;
    }
    
    public Evento(String dcId, String dcUrl, String dcTicket, String dcLocal, String dcCidade) {
        this.dcId = dcId;
        this.dcUrl = dcUrl;
        this.dcTicket = dcTicket;
        this.dcLocal = dcLocal;
        this.dcCidade = dcCidade;
    }

    public Integer getCdEvento() {
        return cdEvento;
    }

    public void setCdEvento(Integer cdEvento) {
        this.cdEvento = cdEvento;
    }

    public int getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(int cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getDcId() {
        return dcId;
    }

    public void setDcId(String dcId) {
        this.dcId = dcId;
    }

    public String getDcUrl() {
        return dcUrl;
    }

    public void setDcUrl(String dcUrl) {
        this.dcUrl = dcUrl;
    }

    public String getDcTicket() {
        return dcTicket;
    }

    public void setDcTicket(String dcTicket) {
        this.dcTicket = dcTicket;
    }

    public String getDcLocal() {
        return dcLocal;
    }

    public void setDcLocal(String dcLocal) {
        this.dcLocal = dcLocal;
    }

    public String getDcCidade() {
        return dcCidade;
    }

    public void setDcCidade(String dcCidade) {
        this.dcCidade = dcCidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdEvento != null ? cdEvento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Evento)) {
            return false;
        }
        Evento other = (Evento) object;
        if ((this.cdEvento == null && other.cdEvento != null) || (this.cdEvento != null && !this.cdEvento.equals(other.cdEvento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Evento[ cdEvento=" + cdEvento + " ]";
    }
    
}
