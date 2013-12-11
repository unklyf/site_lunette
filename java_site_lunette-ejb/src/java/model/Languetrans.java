/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Unklyf
 */
@Entity
@Table(name = "LANGUETRANS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Languetrans.findAll", query = "SELECT l FROM Languetrans l"),
    @NamedQuery(name = "Languetrans.findByIdlangue", query = "SELECT l FROM Languetrans l WHERE l.idlangue = :idlangue"),
    @NamedQuery(name = "Languetrans.findByLibelle", query = "SELECT l FROM Languetrans l WHERE l.libelle = :libelle")})
public class Languetrans implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDLANGUE")
    private Integer idlangue;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "LIBELLE")
    private String libelle;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languetrans")
    private Collection<Tradpays> tradpaysCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languetrans")
    private Collection<Tradcategorie> tradcategorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languetrans")
    private Collection<Tradcouleur> tradcouleurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "languetrans")
    private Collection<Traddescription> traddescriptionCollection;

    public Languetrans() {
    }

    public Languetrans(Integer idlangue) {
        this.idlangue = idlangue;
    }

    public Languetrans(Integer idlangue, String libelle) {
        this.idlangue = idlangue;
        this.libelle = libelle;
    }

    public Integer getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(Integer idlangue) {
        this.idlangue = idlangue;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @XmlTransient
    public Collection<Tradpays> getTradpaysCollection() {
        return tradpaysCollection;
    }

    public void setTradpaysCollection(Collection<Tradpays> tradpaysCollection) {
        this.tradpaysCollection = tradpaysCollection;
    }

    @XmlTransient
    public Collection<Tradcategorie> getTradcategorieCollection() {
        return tradcategorieCollection;
    }

    public void setTradcategorieCollection(Collection<Tradcategorie> tradcategorieCollection) {
        this.tradcategorieCollection = tradcategorieCollection;
    }

    @XmlTransient
    public Collection<Tradcouleur> getTradcouleurCollection() {
        return tradcouleurCollection;
    }

    public void setTradcouleurCollection(Collection<Tradcouleur> tradcouleurCollection) {
        this.tradcouleurCollection = tradcouleurCollection;
    }

    @XmlTransient
    public Collection<Traddescription> getTraddescriptionCollection() {
        return traddescriptionCollection;
    }

    public void setTraddescriptionCollection(Collection<Traddescription> traddescriptionCollection) {
        this.traddescriptionCollection = traddescriptionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idlangue != null ? idlangue.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Languetrans)) {
            return false;
        }
        Languetrans other = (Languetrans) object;
        if ((this.idlangue == null && other.idlangue != null) || (this.idlangue != null && !this.idlangue.equals(other.idlangue))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Languetrans[ idlangue=" + idlangue + " ]";
    }
    
}
