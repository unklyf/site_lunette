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
@Table(name = "TRADVILLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tradville.findAll", query = "SELECT t FROM Tradville t"),
    @NamedQuery(name = "Tradville.findByIdlangue", query = "SELECT t FROM Tradville t WHERE t.tradvillePK.idlangue = :idlangue"),
    @NamedQuery(name = "Tradville.findByIdville", query = "SELECT t FROM Tradville t WHERE t.tradvillePK.idville = :idville"),
    @NamedQuery(name = "Tradville.findByLibelle", query = "SELECT t FROM Tradville t WHERE t.libelle = :libelle")})
public class Tradville implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TradvillePK tradvillePK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "LIBELLE")
    private String libelle;
    @JoinColumn(name = "IDVILLE", referencedColumnName = "IDVILLE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ville ville;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "IDLANGUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Languetrans languetrans;

    public Tradville() {
    }

    public Tradville(TradvillePK tradvillePK) {
        this.tradvillePK = tradvillePK;
    }

    public Tradville(TradvillePK tradvillePK, String libelle) {
        this.tradvillePK = tradvillePK;
        this.libelle = libelle;
    }

    public Tradville(int idlangue, int idville) {
        this.tradvillePK = new TradvillePK(idlangue, idville);
    }

    public TradvillePK getTradvillePK() {
        return tradvillePK;
    }

    public void setTradvillePK(TradvillePK tradvillePK) {
        this.tradvillePK = tradvillePK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
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
        hash += (tradvillePK != null ? tradvillePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tradville)) {
            return false;
        }
        Tradville other = (Tradville) object;
        if ((this.tradvillePK == null && other.tradvillePK != null) || (this.tradvillePK != null && !this.tradvillePK.equals(other.tradvillePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Tradville[ tradvillePK=" + tradvillePK + " ]";
    }
    
}
