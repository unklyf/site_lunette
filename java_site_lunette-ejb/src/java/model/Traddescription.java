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
@Table(name = "TRADDESCRIPTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Traddescription.findAll", query = "SELECT t FROM Traddescription t"),
    @NamedQuery(name = "Traddescription.findDescription", query = "SELECT t FROM Traddescription t WHERE t.traddescriptionPK.iddescription = :iddescription AND t.traddescriptionPK.idlangue = :idlangue"),
    @NamedQuery(name = "Traddescription.findByIddescription", query = "SELECT t FROM Traddescription t WHERE t.traddescriptionPK.iddescription = :iddescription"),
    @NamedQuery(name = "Traddescription.findByIdlangue", query = "SELECT t FROM Traddescription t WHERE t.traddescriptionPK.idlangue = :idlangue"),
    @NamedQuery(name = "Traddescription.findByDescription", query = "SELECT t FROM Traddescription t WHERE t.description = :description")})
public class Traddescription implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TraddescriptionPK traddescriptionPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32672)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "IDLANGUE", referencedColumnName = "IDLANGUE", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Languetrans languetrans;
    @JoinColumn(name = "IDDESCRIPTION", referencedColumnName = "IDDESCRIPTION", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Description description1;

    public Traddescription() {
    }

    public Traddescription(TraddescriptionPK traddescriptionPK) {
        this.traddescriptionPK = traddescriptionPK;
    }

    public Traddescription(TraddescriptionPK traddescriptionPK, String description) {
        this.traddescriptionPK = traddescriptionPK;
        this.description = description;
    }

    public Traddescription(int iddescription, int idlangue) {
        this.traddescriptionPK = new TraddescriptionPK(iddescription, idlangue);
    }

    public TraddescriptionPK getTraddescriptionPK() {
        return traddescriptionPK;
    }

    public void setTraddescriptionPK(TraddescriptionPK traddescriptionPK) {
        this.traddescriptionPK = traddescriptionPK;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Languetrans getLanguetrans() {
        return languetrans;
    }

    public void setLanguetrans(Languetrans languetrans) {
        this.languetrans = languetrans;
    }

    public Description getDescription1() {
        return description1;
    }

    public void setDescription1(Description description1) {
        this.description1 = description1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (traddescriptionPK != null ? traddescriptionPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Traddescription)) {
            return false;
        }
        Traddescription other = (Traddescription) object;
        if ((this.traddescriptionPK == null && other.traddescriptionPK != null) || (this.traddescriptionPK != null && !this.traddescriptionPK.equals(other.traddescriptionPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Traddescription[ traddescriptionPK=" + traddescriptionPK + " ]";
    }
    
}
