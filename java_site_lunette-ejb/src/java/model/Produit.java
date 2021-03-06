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
    @NamedQuery(name = "Produit.findByCategorie", query = "SELECT p FROM Produit p WHERE p.idcategorie.idcategorie = :idcategorie"),
    @NamedQuery(name = "Produit.findAll", query = "SELECT p FROM Produit p"),
    @NamedQuery(name = "Produit.findByIdproduit", query = "SELECT p FROM Produit p WHERE p.idproduit = :idproduit"),
    @NamedQuery(name = "Produit.findByImage", query = "SELECT p FROM Produit p WHERE p.image = :image"),
    @NamedQuery(name = "Produit.findByMarque", query = "SELECT p FROM Produit p WHERE p.marque = :marque"),
    @NamedQuery(name = "Produit.findByModele", query = "SELECT p FROM Produit p WHERE p.modele = :modele"),
    @NamedQuery(name = "Produit.findByPrixunitaire", query = "SELECT p FROM Produit p WHERE p.prixunitaire = :prixunitaire"),
    @NamedQuery(name = "Produit.findByNouveautee", query = "SELECT p FROM Produit p WHERE p.nouveautee = :nouveautee"),
    @NamedQuery(name = "Produit.findByGenre", query = "SELECT p FROM Produit p WHERE p.genre = :genre")})
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "MODELE")
    private String modele;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXUNITAIRE")
    private double prixunitaire;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NOUVEAUTEE")
    private boolean nouveautee;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENRE")
    private char genre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private Collection<Lignecommande> lignecommandeCollection;  
    @JoinColumn(name = "IDPROMO", referencedColumnName = "IDPROMO")
    @ManyToOne
    private Promotion idpromo;
    @JoinColumn(name = "IDFOURNISSEUR", referencedColumnName = "IDFOURNISSEUR")
    @ManyToOne(optional = false)
    private Fournisseur idfournisseur;
    @JoinColumn(name = "IDDESCRIPTION", referencedColumnName = "IDDESCRIPTION")
    @ManyToOne(optional = false)
    private Description iddescription;
    @JoinColumn(name = "IDCOULEURMONT", referencedColumnName = "IDCOULEUR")
    @ManyToOne(optional = false)
    private Couleur idcouleurmont;
    @JoinColumn(name = "IDCOULEURVERRE", referencedColumnName = "IDCOULEUR")
    @ManyToOne(optional = false)
    private Couleur idcouleurverre;
    @JoinColumn(name = "IDCATEGORIE", referencedColumnName = "IDCATEGORIE")
    @ManyToOne(optional = false)
    private Categorie idcategorie;
    

    /**
     *
     */
    public Produit() {
    }

    /**
     *
     * @param idproduit
     */
    public Produit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    /**
     *
     * @param idproduit
     * @param image
     * @param marque
     * @param modele
     * @param prixunitaire
     * @param nouveautee
     * @param genre
     */
    public Produit(Integer idproduit, String image, String marque, String modele, double prixunitaire, boolean nouveautee, char genre) {
        this.idproduit = idproduit;
        this.image = image;
        this.marque = marque;
        this.modele = modele;
        this.prixunitaire = prixunitaire;
        this.nouveautee = nouveautee;
        this.genre = genre;
    }

    
    /**
     *
     * @return
     */
    public Integer getIdproduit() {
        return idproduit;
    }

    /**
     *
     * @param idproduit
     */
    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
    }

    /**
     *
     * @return
     */
    public String getImage() {
        return image;
    }

    /**
     *
     * @param image
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     *
     * @return
     */
    public String getMarque() {
        return marque;
    }

    /**
     *
     * @param marque
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }

    /**
     *
     * @return
     */
    public String getModele() {
        return modele;
    }

    /**
     *
     * @param modele
     */
    public void setModele(String modele) {
        this.modele = modele;
    }

    /**
     *
     * @return
     */
    public double getPrixunitaire() {
        return prixunitaire;
    }

    /**
     *
     * @param prixunitaire
     */
    public void setPrixunitaire(double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    /**
     *
     * @return
     */
    public boolean getNouveautee() {
        return nouveautee;
    }

    /**
     *
     * @param nouveautee
     */
    public void setNouveautee(boolean nouveautee) {
        this.nouveautee = nouveautee;
    }

    /**
     *
     * @return
     */
    public char getGenre() {
        return genre;
    }

    /**
     *
     * @param genre
     */
    public void setGenre(char genre) {
        this.genre = genre;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Lignecommande> getLignecommandeCollection() {
        return lignecommandeCollection;
    }

    /**
     *
     * @param lignecommandeCollection
     */
    public void setLignecommandeCollection(Collection<Lignecommande> lignecommandeCollection) {
        this.lignecommandeCollection = lignecommandeCollection;
    }

    /**
     *
     * @return
     */
    public Promotion getIdpromo() {
        return idpromo;
    }

    /**
     *
     * @param idpromo
     */
    public void setIdpromo(Promotion idpromo) {
        this.idpromo = idpromo;
    }

    /**
     *
     * @return
     */
    public Fournisseur getIdfournisseur() {
        return idfournisseur;
    }

    /**
     *
     * @param idfournisseur
     */
    public void setIdfournisseur(Fournisseur idfournisseur) {
        this.idfournisseur = idfournisseur;
    }

    /**
     *
     * @return
     */
    public Description getIddescription() {
        return iddescription;
    }

    /**
     *
     * @param iddescription
     */
    public void setIddescription(Description iddescription) {
        this.iddescription = iddescription;
    }

    /**
     *
     * @return
     */
    public Couleur getIdcouleurmont() {
        return idcouleurmont;
    }

    /**
     *
     * @param idcouleurmont
     */
    public void setIdcouleurmont(Couleur idcouleurmont) {
        this.idcouleurmont = idcouleurmont;
    }

    /**
     *
     * @return
     */
    public Couleur getIdcouleurverre() {
        return idcouleurverre;
    }

    /**
     *
     * @param idcouleurverre
     */
    public void setIdcouleurverre(Couleur idcouleurverre) {
        this.idcouleurverre = idcouleurverre;
    }

    /**
     *
     * @return
     */
    public Categorie getIdcategorie() {
        return idcategorie;
    }

    /**
     *
     * @param idcategorie
     */
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
