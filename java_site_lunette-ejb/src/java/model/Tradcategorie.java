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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Unklyf
 */
@Entity
@Table(name = "TRADCATEGORIE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tradcategorie.findTradLibelle", query = "SELECT t FROM Tradcategorie t WHERE t.tradcategoriePK.idcategorie = :idcategorie AND t.tradcategoriePK.idlangue = :idlangue"),
    @NamedQuery(name = "Tradcategorie.findAll", query = "SELECT t FROM Tradcategorie t"),
    @NamedQuery(name = "Tradcategorie.findByIdcategorie", query = "SELECT t FROM Tradcategorie t WHERE t.tradcategoriePK.idcategorie = :idcategorie"),
    @NamedQuery(name = "Tradcategorie.findByIdlangue", query = "SELECT t FROM Tradcategorie t WHERE t.tradcategoriePK.idlangue = :idlangue"),
    @NamedQuery(name = "Tradcategorie.findByLibelle", query = "SELECT t FROM Tradcategorie t WHERE t.libelle = :libelle")})
public class Tradcategorie implements Serializable {
    private static final long serialVersionUID = 1L;
    /**
     *
     */
    @EmbeddedId
    protected TradcategoriePK tradcategoriePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "LIBELLE")
    private String libelle;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "IDLANGUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Languetrans languetrans;
    @JoinColumn(name = "IDCATEGORIE", referencedColumnName = "IDCATEGORIE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Categorie categorie;

    /**
     *
     */
    public Tradcategorie() {
    }

    /**
     *
     * @param tradcategoriePK
     */
    public Tradcategorie(TradcategoriePK tradcategoriePK) {
        this.tradcategoriePK = tradcategoriePK;
    }

    /**
     *
     * @param tradcategoriePK
     * @param libelle
     */
    public Tradcategorie(TradcategoriePK tradcategoriePK, String libelle) {
        this.tradcategoriePK = tradcategoriePK;
        this.libelle = libelle;
    }

    /**
     *
     * @param idcategorie
     * @param idlangue
     */
    public Tradcategorie(int idcategorie, int idlangue) {
        this.tradcategoriePK = new TradcategoriePK(idcategorie, idlangue);
    }

    /**
     *
     * @return
     */
    public TradcategoriePK getTradcategoriePK() {
        return tradcategoriePK;
    }

    /**
     *
     * @param tradcategoriePK
     */
    public void setTradcategoriePK(TradcategoriePK tradcategoriePK) {
        this.tradcategoriePK = tradcategoriePK;
    }

    /**
     *
     * @return
     */
    public String getLibelle() {
        return libelle;
    }

    /**
     *
     * @param libelle
     */
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    /**
     *
     * @return
     */
    public Languetrans getLanguetrans() {
        return languetrans;
    }

    /**
     *
     * @param languetrans
     */
    public void setLanguetrans(Languetrans languetrans) {
        this.languetrans = languetrans;
    }

    /**
     *
     * @return
     */
    public Categorie getCategorie() {
        return categorie;
    }

    /**
     *
     * @param categorie
     */
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tradcategoriePK != null ? tradcategoriePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tradcategorie)) {
            return false;
        }
        Tradcategorie other = (Tradcategorie) object;
        if ((this.tradcategoriePK == null && other.tradcategoriePK != null) || (this.tradcategoriePK != null && !this.tradcategoriePK.equals(other.tradcategoriePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tradcategorie[ tradcategoriePK=" + tradcategoriePK + " ]";
    }
    
}
