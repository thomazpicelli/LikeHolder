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
@Table(name = "MUSICA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Musica.findAll", query = "SELECT m FROM Musica m"),
    @NamedQuery(name = "Musica.findByCdMusica", query = "SELECT m FROM Musica m WHERE m.cdMusica = :cdMusica"),
    @NamedQuery(name = "Musica.findByCdUsuario", query = "SELECT m FROM Musica m WHERE m.cdUsuario = :cdUsuario"),
    @NamedQuery(name = "Musica.findByDcId", query = "SELECT m FROM Musica m WHERE m.dcId = :dcId"),
    @NamedQuery(name = "Musica.findByDcUrl", query = "SELECT m FROM Musica m WHERE m.dcUrl = :dcUrl"),
    @NamedQuery(name = "Musica.findByDcUri", query = "SELECT m FROM Musica m WHERE m.dcUri = :dcUri"),
    @NamedQuery(name = "Musica.findByNmMusica", query = "SELECT m FROM Musica m WHERE m.nmMusica = :nmMusica"),
    @NamedQuery(name = "Musica.findByNmArtista", query = "SELECT m FROM Musica m WHERE m.nmArtista = :nmArtista")})
public class Musica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_MUSICA")
    private Integer cdMusica;
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
    @Column(name = "DC_URI")
    private String dcUri;
    @Basic(optional = false)
    @Column(name = "NM_MUSICA")
    private String nmMusica;
    @Basic(optional = false)
    @Column(name = "NM_ARTISTA")
    private String nmArtista;

    public Musica() {
    }

    public Musica(Integer cdMusica) {
        this.cdMusica = cdMusica;
    }

    public Musica(Integer cdMusica, int cdUsuario, String dcId, String dcUrl, String dcUri, String nmMusica, String nmArtista) {
        this.cdMusica = cdMusica;
        this.cdUsuario = cdUsuario;
        this.dcId = dcId;
        this.dcUrl = dcUrl;
        this.dcUri = dcUri;
        this.nmMusica = nmMusica;
        this.nmArtista = nmArtista;
    }
    
    public Musica(String dcId, String dcUrl, String dcUri, String nmMusica, String nmArtista) {
        this.dcId = dcId;
        this.dcUrl = dcUrl;
        this.dcUri = dcUri;
        this.nmMusica = nmMusica;
        this.nmArtista = nmArtista;
    }
    public Musica(int cdUsuario, String dcId, String dcUrl, String dcUri, String nmMusica, String nmArtista) {
        this.cdUsuario = cdUsuario;
        this.dcId = dcId;
        this.dcUrl = dcUrl;
        this.dcUri = dcUri;
        this.nmMusica = nmMusica;
        this.nmArtista = nmArtista;
    }

    public Integer getCdMusica() {
        return cdMusica;
    }

    public void setCdMusica(Integer cdMusica) {
        this.cdMusica = cdMusica;
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

    public String getDcUri() {
        return dcUri;
    }

    public void setDcUri(String dcUri) {
        this.dcUri = dcUri;
    }

    public String getNmMusica() {
        return nmMusica;
    }

    public void setNmMusica(String nmMusica) {
        this.nmMusica = nmMusica;
    }

    public String getNmArtista() {
        return nmArtista;
    }

    public void setNmArtista(String nmArtista) {
        this.nmArtista = nmArtista;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cdMusica != null ? cdMusica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Musica)) {
            return false;
        }
        Musica other = (Musica) object;
        if ((this.cdMusica == null && other.cdMusica != null) || (this.cdMusica != null && !this.cdMusica.equals(other.cdMusica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Musica[ cdMusica=" + cdMusica + " ]";
    }
    
}
