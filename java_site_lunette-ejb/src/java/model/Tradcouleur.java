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
 * @author etu17965
 */
@Entity
@Table(name = "TRADCOULEUR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tradcouleur.findAll", query = "SELECT t FROM Tradcouleur t"),
    @NamedQuery(name = "Tradcouleur.findByIdcouleur", query = "SELECT t FROM Tradcouleur t WHERE t.tradcouleurPK.idcouleur = :idcouleur"),
    @NamedQuery(name = "Tradcouleur.findByIdlangue", query = "SELECT t FROM Tradcouleur t WHERE t.tradcouleurPK.idlangue = :idlangue"),
    @NamedQuery(name = "Tradcouleur.findByLibelle", query = "SELECT t FROM Tradcouleur t WHERE t.libelle = :libelle")})
public class Tradcouleur implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TradcouleurPK tradcouleurPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "LIBELLE")
    private String libelle;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "IDLANGUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Languetrans languetrans;
    @JoinColumn(name = "IDCOULEUR", referencedColumnName = "IDCOULEUR", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Couleur couleur;

    public Tradcouleur() {
    }

    public Tradcouleur(TradcouleurPK tradcouleurPK) {
        this.tradcouleurPK = tradcouleurPK;
    }

    public Tradcouleur(TradcouleurPK tradcouleurPK, String libelle) {
        this.tradcouleurPK = tradcouleurPK;
        this.libelle = libelle;
    }

    public Tradcouleur(int idcouleur, int idlangue) {
        this.tradcouleurPK = new TradcouleurPK(idcouleur, idlangue);
    }

    public TradcouleurPK getTradcouleurPK() {
        return tradcouleurPK;
    }

    public void setTradcouleurPK(TradcouleurPK tradcouleurPK) {
        this.tradcouleurPK = tradcouleurPK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Languetrans getLanguetrans() {
        return languetrans;
    }

    public void setLanguetrans(Languetrans languetrans) {
        this.languetrans = languetrans;
    }

    public Couleur getCouleur() {
        return couleur;
    }

    public void setCouleur(Couleur couleur) {
        this.couleur = couleur;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (tradcouleurPK != null ? tradcouleurPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tradcouleur)) {
            return false;
        }
        Tradcouleur other = (Tradcouleur) object;
        if ((this.tradcouleurPK == null && other.tradcouleurPK != null) || (this.tradcouleurPK != null && !this.tradcouleurPK.equals(other.tradcouleurPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Tradcouleur[ tradcouleurPK=" + tradcouleurPK + " ]";
    }
    
}
