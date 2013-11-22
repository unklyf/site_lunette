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
@Table(name = "TRADPAYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tradpays.findAll", query = "SELECT t FROM Tradpays t"),
    @NamedQuery(name = "Tradpays.findByIdlangue", query = "SELECT t FROM Tradpays t WHERE t.tradpaysPK.idlangue = :idlangue"),
    @NamedQuery(name = "Tradpays.findByIdpays", query = "SELECT t FROM Tradpays t WHERE t.tradpaysPK.idpays = :idpays"),
    @NamedQuery(name = "Tradpays.findByLibelle", query = "SELECT t FROM Tradpays t WHERE t.libelle = :libelle")})
public class Tradpays implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TradpaysPK tradpaysPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "LIBELLE")
    private String libelle;
    @JoinColumn(name = "IDPAYS", referencedColumnName = "IDPAYS", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Pays pays;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "IDLANGUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Languetrans languetrans;

    public Tradpays() {
    }

    public Tradpays(TradpaysPK tradpaysPK) {
        this.tradpaysPK = tradpaysPK;
    }

    public Tradpays(TradpaysPK tradpaysPK, String libelle) {
        this.tradpaysPK = tradpaysPK;
        this.libelle = libelle;
    }

    public Tradpays(int idlangue, int idpays) {
        this.tradpaysPK = new TradpaysPK(idlangue, idpays);
    }

    public TradpaysPK getTradpaysPK() {
        return tradpaysPK;
    }

    public void setTradpaysPK(TradpaysPK tradpaysPK) {
        this.tradpaysPK = tradpaysPK;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Pays getPays() {
        return pays;
    }

    public void setPays(Pays pays) {
        this.pays = pays;
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
        hash += (tradpaysPK != null ? tradpaysPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tradpays)) {
            return false;
        }
        Tradpays other = (Tradpays) object;
        if ((this.tradpaysPK == null && other.tradpaysPK != null) || (this.tradpaysPK != null && !this.tradpaysPK.equals(other.tradpaysPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Tradpays[ tradpaysPK=" + tradpaysPK + " ]";
    }
    
}
