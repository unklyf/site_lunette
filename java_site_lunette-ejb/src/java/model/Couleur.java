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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author etu17965
 */
@Entity
@Table(name = "COULEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Couleur.findAll", query = "SELECT c FROM Couleur c"),
    @NamedQuery(name = "Couleur.findByIdcouleur", query = "SELECT c FROM Couleur c WHERE c.idcouleur = :idcouleur")})
public class Couleur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOULEUR")
    private Integer idcouleur;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "couleur")
    private Collection<Tradcouleur> tradcouleurCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcouleur")
    private Collection<Produit> produitCollection;

    public Couleur() {
    }

    public Couleur(Integer idcouleur) {
        this.idcouleur = idcouleur;
    }

    public Integer getIdcouleur() {
        return idcouleur;
    }

    public void setIdcouleur(Integer idcouleur) {
        this.idcouleur = idcouleur;
    }

    @XmlTransient
    public Collection<Tradcouleur> getTradcouleurCollection() {
        return tradcouleurCollection;
    }

    public void setTradcouleurCollection(Collection<Tradcouleur> tradcouleurCollection) {
        this.tradcouleurCollection = tradcouleurCollection;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcouleur != null ? idcouleur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Couleur)) {
            return false;
        }
        Couleur other = (Couleur) object;
        if ((this.idcouleur == null && other.idcouleur != null) || (this.idcouleur != null && !this.idcouleur.equals(other.idcouleur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Couleur[ idcouleur=" + idcouleur + " ]";
    }
    
}
