/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "PRODUIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByIdproduit", query = "SELECT p FROM Produit p WHERE p.idproduit = :idproduit"),
    @NamedQuery(name = "Produit.findByImage", query = "SELECT p FROM Produit p WHERE p.image = :image"),
    @NamedQuery(name = "Produit.findByMarque", query = "SELECT p FROM Produit p WHERE p.marque = :marque"),
    @NamedQuery(name = "Produit.findByPrixunitaire", query = "SELECT p FROM Produit p WHERE p.prixunitaire = :prixunitaire")})
public class Produit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPRODUIT")
    private Integer idproduit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "IMAGE")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MARQUE")
    private String marque;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXUNITAIRE")
    private BigDecimal prixunitaire;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Lignecommande> lignecommandeCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Tradproduit> tradproduitCollection;
    @JoinColumn(name = "IDPROMO", referencedColumnName = "IDPROMO")
    @ManyToOne
    private Promotion idpromo;
    @JoinColumn(name = "IDFOURNISSEUR", referencedColumnName = "IDFOURNISSEUR")
    @ManyToOne(optional = false)
    private Fournisseur idfournisseur;
    @JoinColumn(name = "IDCOULEUR", referencedColumnName = "IDCOULEUR")
    @ManyToOne(optional = false)
    private Couleur idcouleur;
    @JoinColumn(name = "IDCATEGORIE", referencedColumnName = "IDCATEGORIE")
    @ManyToOne(optional = false)
    private Categorie idcategorie;

    public Produit() {
    }

    public Produit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public Produit(Integer idproduit, String image, String marque, BigDecimal prixunitaire) {
        this.idproduit = idproduit;
        this.image = image;
        this.marque = marque;
        this.prixunitaire = prixunitaire;
    }

    public Integer getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public BigDecimal getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(BigDecimal prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    @XmlTransient
    public Collection<Lignecommande> getLignecommandeCollection() {
        return lignecommandeCollection;
    }

    public void setLignecommandeCollection(Collection<Lignecommande> lignecommandeCollection) {
        this.lignecommandeCollection = lignecommandeCollection;
    }

    @XmlTransient
    public Collection<Tradproduit> getTradproduitCollection() {
        return tradproduitCollection;
    }

    public void setTradproduitCollection(Collection<Tradproduit> tradproduitCollection) {
        this.tradproduitCollection = tradproduitCollection;
    }

    public Promotion getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(Promotion idpromo) {
        this.idpromo = idpromo;
    }

    public Fournisseur getIdfournisseur() {
        return idfournisseur;
    }

    public void setIdfournisseur(Fournisseur idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    public Couleur getIdcouleur() {
        return idcouleur;
    }

    public void setIdcouleur(Couleur idcouleur) {
        this.idcouleur = idcouleur;
    }

    public Categorie getIdcategorie() {
        return idcategorie;
    }

    public void setIdcategorie(Categorie idcategorie) {
        this.idcategorie = idcategorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproduit != null ? idproduit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produit)) {
            return false;
        }
        Produit other = (Produit) object;
        if ((this.idproduit == null && other.idproduit != null) || (this.idproduit != null && !this.idproduit.equals(other.idproduit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Produit[ idproduit=" + idproduit + " ]";
    }
    
}
