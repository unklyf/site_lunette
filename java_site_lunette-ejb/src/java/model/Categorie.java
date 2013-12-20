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
 * @author Unklyf
 */
@Entity
@Table(name = "CATEGORIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categorie.findAll", query = "SELECT c FROM Categorie c"),
    @NamedQuery(name = "Categorie.findByIdcategorie", query = "SELECT c FROM Categorie c WHERE c.idcategorie = :idcategorie")})
public class Categorie implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCATEGORIE")
    private Integer idcategorie;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categorie")
    private Collection<Tradcategorie> tradcategorieCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idcategorie")
    private Collection<Produit> produitCollection;

    /**
     *
     */
    public Categorie() {
    }

    /**
     *
     * @param idcategorie
     */
    public Categorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    /**
     *
     * @return
     */
    public Integer getIdcategorie() {
        return idcategorie;
    }

    /**
     *
     * @param idcategorie
     */
    public void setIdcategorie(Integer idcategorie) {
        this.idcategorie = idcategorie;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Tradcategorie> getTradcategorieCollection() {
        return tradcategorieCollection;
    }

    /**
     *
     * @param tradcategorieCollection
     */
    public void setTradcategorieCollection(Collection<Tradcategorie> tradcategorieCollection) {
        this.tradcategorieCollection = tradcategorieCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    /**
     *
     * @param produitCollection
     */
    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcategorie != null ? idcategorie.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categorie)) {
            return false;
        }
        Categorie other = (Categorie) object;
        if ((this.idcategorie == null && other.idcategorie != null) || (this.idcategorie != null && !this.idcategorie.equals(other.idcategorie))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Categorie[ idcategorie=" + idcategorie + " ]";
    }
    
}
