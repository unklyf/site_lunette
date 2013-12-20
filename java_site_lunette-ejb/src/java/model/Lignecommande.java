/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Unklyf
 */
@Entity
@Table(name = "LIGNECOMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Lignecommande.findAll", query = "SELECT l FROM Lignecommande l"),
    @NamedQuery(name = "Lignecommande.findByIdcommande", query = "SELECT l FROM Lignecommande l WHERE l.lignecommandePK.idcommande = :idcommande"),
    @NamedQuery(name = "Lignecommande.findByIdproduit", query = "SELECT l FROM Lignecommande l WHERE l.lignecommandePK.idproduit = :idproduit"),
    @NamedQuery(name = "Lignecommande.findByQuantitee", query = "SELECT l FROM Lignecommande l WHERE l.quantitee = :quantitee"),
    @NamedQuery(name = "Lignecommande.findByPrixvente", query = "SELECT l FROM Lignecommande l WHERE l.prixvente = :prixvente")})
public class Lignecommande implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @EmbeddedId
    protected LignecommandePK lignecommandePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "QUANTITEE")
    private int quantitee;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIXVENTE")
    private double prixvente;
    @JoinColumn(name = "IDPRODUIT", referencedColumnName = "IDPRODUIT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;
    @JoinColumn(name = "IDCOMMANDE", referencedColumnName = "IDCOMMANDE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;

    /**
     *
     */
    public Lignecommande() {
    }

    
    /**
     *
     * @param lignecommandePK
     */
    public Lignecommande(LignecommandePK lignecommandePK) {
        this.lignecommandePK = lignecommandePK;
    }

    /**
     *
     * @param lignecommandePK
     * @param quantitee
     * @param prixvente
     */
    public Lignecommande(LignecommandePK lignecommandePK, int quantitee, double prixvente) {
        this.lignecommandePK = lignecommandePK;
        this.quantitee = quantitee;
        this.prixvente = prixvente;
    }
    
    /**
     *
     * @param prod
     * @param quantitee
     * @param prixvente
     */
    public Lignecommande(Produit prod, int quantitee, double prixvente) {
        this.produit = prod;
        this.quantitee = quantitee;
        this.prixvente = prixvente;
    }

    /**
     *
     * @param idcommande
     * @param idproduit
     */
    public Lignecommande(int idcommande, int idproduit) {
        this.lignecommandePK = new LignecommandePK(idcommande, idproduit);
    }

    /**
     *
     * @return
     */
    public LignecommandePK getLignecommandePK() {
        return lignecommandePK;
    }

    /**
     *
     * @param lignecommandePK
     */
    public void setLignecommandePK(LignecommandePK lignecommandePK) {
        this.lignecommandePK = lignecommandePK;
    }

    /**
     *
     * @return
     */
    public int getQuantitee() {
        return quantitee;
    }

    /**
     *
     * @param quantitee
     */
    public void setQuantitee(int quantitee) {
        this.quantitee = quantitee;
    }

    /**
     *
     * @return
     */
    public double getPrixvente() {
        return prixvente;
    }

    /**
     *
     * @param prixvente
     */
    public void setPrixvente(double prixvente) {
        this.prixvente = prixvente;
    }

    /**
     *
     * @return
     */
    public Produit getProduit() {
        return produit;
    }

    /**
     *
     * @param produit
     */
    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    /**
     *
     * @return
     */
    public Commande getCommande() {
        return commande;
    }

    /**
     *
     * @param commande
     */
    public void setCommande(Commande commande) {
        this.commande = commande;        
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lignecommandePK != null ? lignecommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Lignecommande)) {
            return false;
        }
        Lignecommande other = (Lignecommande) object;
        if ((this.lignecommandePK == null && other.lignecommandePK != null) || (this.lignecommandePK != null && !this.lignecommandePK.equals(other.lignecommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Lignecommande[ lignecommandePK=" + lignecommandePK + " ]";
    }
    
}
