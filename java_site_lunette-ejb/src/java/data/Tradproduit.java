/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author etu17965
 */
@Entity
@Table(name = "TRADPRODUIT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tradproduit.findAll", query = "SELECT t FROM Tradproduit t"),
    @NamedQuery(name = "Tradproduit.findByIdlangue", query = "SELECT t FROM Tradproduit t WHERE t.tradproduitPK.idlangue = :idlangue"),
    @NamedQuery(name = "Tradproduit.findByIdproduit", query = "SELECT t FROM Tradproduit t WHERE t.tradproduitPK.idproduit = :idproduit"),
    @NamedQuery(name = "Tradproduit.findByLibelle", query = "SELECT t FROM Tradproduit t WHERE t.libelle = :libelle"),
    @NamedQuery(name = "Tradproduit.findByDescription", query = "SELECT t FROM Tradproduit t WHERE t.description = :description"),
    @NamedQuery(name = "Tradproduit.findByMonture", query = "SELECT t FROM Tradproduit t WHERE t.monture = :monture"),
    @NamedQuery(name = "Tradproduit.findByGenre", query = "SELECT t FROM Tradproduit t WHERE t.genre = :genre")})
public class Tradproduit implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TradproduitPK tradproduitPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "LIBELLE")
    private String libelle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "MONTURE")
    private String monture;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENRE")
    private char genre;
    @JoinColumn(name = "IDPRODUIT", referencedColumnName = "IDPRODUIT", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Produit produit;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "IDLANGUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Languetrans languetrans;

    public Tradproduit() {
    }

    public Tradproduit(TradproduitPK tradproduitPK) {
        this.tradproduitPK = tradproduitPK;
    }

    public Tradproduit(TradproduitPK tradproduitPK, String libelle, String description, String monture, char genre) {
        this.tradproduitPK = tradproduitPK;
        this.libelle = libelle;
        this.description = description;
        this.monture = monture;
        this.genre = genre;
    }

    public Tradproduit(int idlangue, int idproduit) {
        this.tradproduitPK = new TradproduitPK(idlangue, idproduit);
    }

    public TradproduitPK getTradproduitPK() {
        return tradproduitPK;
    }

    public void setTradproduitPK(TradproduitPK tradproduitPK) {
        this.tradproduitPK = tradproduitPK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMonture() {
        return monture;
    }

    public void setMonture(String monture) {
        this.monture = monture;
    }

    public char getGenre() {
        return genre;
    }

    public void setGenre(char genre) {
        this.genre = genre;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Languetrans getLanguetrans() {
        return languetrans;
    }

    public void setLanguetrans(Languetrans languetrans) {
        this.languetrans = languetrans;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tradproduitPK != null ? tradproduitPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tradproduit)) {
            return false;
        }
        Tradproduit other = (Tradproduit) object;
        if ((this.tradproduitPK == null && other.tradproduitPK != null) || (this.tradproduitPK != null && !this.tradproduitPK.equals(other.tradproduitPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Tradproduit[ tradproduitPK=" + tradproduitPK + " ]";
    }
    
}
