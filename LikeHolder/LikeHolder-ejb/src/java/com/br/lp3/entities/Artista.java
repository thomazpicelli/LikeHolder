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
@Table(name = "ARTISTA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Artista.findAll", query = "SELECT a FROM Artista a"),
    @NamedQuery(name = "Artista.findByCdArtista", query = "SELECT a FROM Artista a WHERE a.cdArtista = :cdArtista"),
    @NamedQuery(name = "Artista.findByCdUsuario", query = "SELECT a FROM Artista a WHERE a.cdUsuario = :cdUsuario"),
    @NamedQuery(name = "Artista.findByDcId", query = "SELECT a FROM Artista a WHERE a.dcId = :dcId"),
    @NamedQuery(name = "Artista.findByDcUrl", query = "SELECT a FROM Artista a WHERE a.dcUrl = :dcUrl"),
    @NamedQuery(name = "Artista.findByNmArtista", query = "SELECT a FROM Artista a WHERE a.nmArtista = :nmArtista"),
    @NamedQuery(name = "Artista.findByCdFollower", query = "SELECT a FROM Artista a WHERE a.cdFollower = :cdFollower"),
    @NamedQuery(name = "Artista.findByDcImg", query = "SELECT a FROM Artista a WHERE a.dcImg = :dcImg"),
    @NamedQuery(name = "Artista.findByCdHeight", query = "SELECT a FROM Artista a WHERE a.cdHeight = :cdHeight"),
    @NamedQuery(name = "Artista.findByCdWidth", query = "SELECT a FROM Artista a WHERE a.cdWidth = :cdWidth")})
public class Artista implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_ARTISTA")
    private Integer cdArtista;
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
    @Column(name = "NM_ARTISTA")
    private String nmArtista;
    @Column(name = "CD_FOLLOWER")
    private Integer cdFollower;
    @Column(name = "DC_IMG")
    private String dcImg;
    @Column(name = "CD_HEIGHT")
    private Integer cdHeight;
    @Column(name = "CD_WIDTH")
    private Integer cdWidth;

    public Artista() {
    }

    public Artista(Integer cdArtista) {
        this.cdArtista = cdArtista;
    }

    public Artista(Integer cdArtista, int cdUsuario, String dcId, String dcUrl, String nmArtista) {
        this.cdArtista = cdArtista;
        this.cdUsuario = cdUsuario;
        this.dcId = dcId;
        this.dcUrl = dcUrl;
        this.nmArtista = nmArtista;
    }
    
    public Artista(String dcId, String dcUrl, String nmArtista, Integer cdFollower, String dcImg, Integer cdHeight, Integer cdWidth) {
        this.dcId = dcId;
        this.dcUrl = dcUrl;
        this.nmArtista = nmArtista;
        this.cdFollower = cdFollower;
        this.dcImg = dcImg;
        this.cdHeight = cdHeight;
        this.cdWidth = cdWidth;
    }
    public Artista(int CdUsuario, String dcId, String dcUrl, String nmArtista, Integer cdFollower, String dcImg, Integer cdHeight, Integer cdWidth) {
        this.cdUsuario = CdUsuario;
        this.dcId = dcId;
        this.dcUrl = dcUrl;
        this.nmArtista = nmArtista;
        this.cdFollower = cdFollower;
        this.dcImg = dcImg;
        this.cdHeight = cdHeight;
        this.cdWidth = cdWidth;
    }

    public Integer getCdArtista() {
        return cdArtista;
    }

    public void setCdArtista(Integer cdArtista) {
        this.cdArtista = cdArtista;
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

    public String getNmArtista() {
        return nmArtista;
    }

    public void setNmArtista(String nmArtista) {
        this.nmArtista = nmArtista;
    }

    public Integer getCdFollower() {
        return cdFollower;
    }

    public void setCdFollower(Integer cdFollower) {
        this.cdFollower = cdFollower;
    }

    public String getDcImg() {
        return dcImg;
    }

    public void setDcImg(String dcImg) {
        this.dcImg = dcImg;
    }

    public Integer getCdHeight() {
        return cdHeight;
    }

    public void setCdHeight(Integer cdHeight) {
        this.cdHeight = cdHeight;
    }

    public Integer getCdWidth() {
        return cdWidth;
    }

    public void setCdWidth(Integer cdWidth) {
        this.cdWidth = cdWidth;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdArtista != null ? cdArtista.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Artista)) {
            return false;
        }
        Artista other = (Artista) object;
        if ((this.cdArtista == null && other.cdArtista != null) || (this.cdArtista != null && !this.cdArtista.equals(other.cdArtista))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Artista[ cdArtista=" + cdArtista + " ]";
    }
    
}
