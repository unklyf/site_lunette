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
@Table(name = "FOURNISSEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Fournisseur.findAll", query = "SELECT f FROM Fournisseur f"),
    @NamedQuery(name = "Fournisseur.findByIdfournisseur", query = "SELECT f FROM Fournisseur f WHERE f.idfournisseur = :idfournisseur"),
    @NamedQuery(name = "Fournisseur.findByNom", query = "SELECT f FROM Fournisseur f WHERE f.nom = :nom"),
    @NamedQuery(name = "Fournisseur.findByNumtelephone", query = "SELECT f FROM Fournisseur f WHERE f.numtelephone = :numtelephone"),
    @NamedQuery(name = "Fournisseur.findByMail", query = "SELECT f FROM Fournisseur f WHERE f.mail = :mail")})
public class Fournisseur implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDFOURNISSEUR")
    private Integer idfournisseur;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NUMTELEPHONE")
    private String numtelephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MAIL")
    private String mail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfournisseur")
    private Collection<Produit> produitCollection;

    /**
     *
     */
    public Fournisseur() {
    }

    /**
     *
     * @param idfournisseur
     */
    public Fournisseur(Integer idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    /**
     *
     * @param idfournisseur
     * @param nom
     * @param numtelephone
     * @param mail
     */
    public Fournisseur(Integer idfournisseur, String nom, String numtelephone, String mail) {
        this.idfournisseur = idfournisseur;
        this.nom = nom;
        this.numtelephone = numtelephone;
        this.mail = mail;
    }

    /**
     *
     * @return
     */
    public Integer getIdfournisseur() {
        return idfournisseur;
    }

    /**
     *
     * @param idfournisseur
     */
    public void setIdfournisseur(Integer idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public String getNumtelephone() {
        return numtelephone;
    }

    /**
     *
     * @param numtelephone
     */
    public void setNumtelephone(String numtelephone) {
        this.numtelephone = numtelephone;
    }

    /**
     *
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
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
        hash += (idfournisseur != null ? idfournisseur.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fournisseur)) {
            return false;
        }
        Fournisseur other = (Fournisseur) object;
        if ((this.idfournisseur == null && other.idfournisseur != null) || (this.idfournisseur != null && !this.idfournisseur.equals(other.idfournisseur))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Fournisseur[ idfournisseur=" + idfournisseur + " ]";
    }
    
}
