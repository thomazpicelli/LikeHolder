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
@Table(name = "USUARIO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByCdUsuario", query = "SELECT u FROM Usuario u WHERE u.cdUsuario = :cdUsuario"),
    @NamedQuery(name = "Usuario.findByNmUsuario", query = "SELECT u FROM Usuario u WHERE u.nmUsuario = :nmUsuario"),
    @NamedQuery(name = "Usuario.findByDcEmail", query = "SELECT u FROM Usuario u WHERE u.dcEmail = :dcEmail"),
    @NamedQuery(name = "Usuario.findByNmUsername", query = "SELECT u FROM Usuario u WHERE u.nmUsername = :nmUsername"),
    @NamedQuery(name = "Usuario.findByNmPassword", query = "SELECT u FROM Usuario u WHERE u.nmPassword = :nmPassword"),
    @NamedQuery(name = "Usuario.findByNmNivel", query = "SELECT u FROM Usuario u WHERE u.nmNivel = :nmNivel")})
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CD_USUARIO")
    private Integer cdUsuario;
    @Basic(optional = false)
    @Column(name = "NM_USUARIO")
    private String nmUsuario;
    @Basic(optional = false)
    @Column(name = "DC_EMAIL")
    private String dcEmail;
    @Basic(optional = false)
    @Column(name = "NM_USERNAME")
    private String nmUsername;
    @Basic(optional = false)
    @Column(name = "NM_PASSWORD")
    private String nmPassword;
    @Basic(optional = false)
    @Column(name = "NM_NIVEL")
    private String nmNivel;

    public Usuario() {
    }

    public Usuario(Integer cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public Usuario(Integer cdUsuario, String nmUsuario, String dcEmail, String nmUsername, String nmPassword, String nmNivel) {
        this.cdUsuario = cdUsuario;
        this.nmUsuario = nmUsuario;
        this.dcEmail = dcEmail;
        this.nmUsername = nmUsername;
        this.nmPassword = nmPassword;
        this.nmNivel = nmNivel;
    }

    public Integer getCdUsuario() {
        return cdUsuario;
    }

    public void setCdUsuario(Integer cdUsuario) {
        this.cdUsuario = cdUsuario;
    }

    public String getNmUsuario() {
        return nmUsuario;
    }

    public void setNmUsuario(String nmUsuario) {
        this.nmUsuario = nmUsuario;
    }

    public String getDcEmail() {
        return dcEmail;
    }

    public void setDcEmail(String dcEmail) {
        this.dcEmail = dcEmail;
    }

    public String getNmUsername() {
        return nmUsername;
    }

    public void setNmUsername(String nmUsername) {
        this.nmUsername = nmUsername;
    }

    public String getNmPassword() {
        return nmPassword;
    }

    public void setNmPassword(String nmPassword) {
        this.nmPassword = nmPassword;
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
        hash += (cdUsuario != null ? cdUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.cdUsuario == null && other.cdUsuario != null) || (this.cdUsuario != null && !this.cdUsuario.equals(other.cdUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.br.lp3.entities.Usuario[ cdUsuario=" + cdUsuario + " ]";
    }
    
}
