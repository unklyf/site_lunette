/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Unklyf
 */
@Entity
@Table(name = "PROMOTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promotion.findAll", query = "SELECT p FROM Promotion p"),
    @NamedQuery(name = "Promotion.findByIdpromo", query = "SELECT p FROM Promotion p WHERE p.idpromo = :idpromo"),
    @NamedQuery(name = "Promotion.findByPourcentage", query = "SELECT p FROM Promotion p WHERE p.pourcentage = :pourcentage"),
    @NamedQuery(name = "Promotion.findByDescription", query = "SELECT p FROM Promotion p WHERE p.description = :description"),
    @NamedQuery(name = "Promotion.findByDatedebut", query = "SELECT p FROM Promotion p WHERE p.datedebut = :datedebut"),
    @NamedQuery(name = "Promotion.findByDatefin", query = "SELECT p FROM Promotion p WHERE p.datefin = :datefin")})
public class Promotion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPROMO")
    private Integer idpromo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "POURCENTAGE")
    private short pourcentage;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10000)
    @Column(name = "DESCRIPTION")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEDEBUT")
    @Temporal(TemporalType.DATE)
    private Date datedebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATEFIN")
    @Temporal(TemporalType.DATE)
    private Date datefin;
    @OneToMany(mappedBy = "idpromo")
    private Collection<Produit> produitCollection;

    public Promotion() {
    }

    public Promotion(Integer idpromo) {
        this.idpromo = idpromo;
    }

    public Promotion(Integer idpromo, short pourcentage, String description, Date datedebut, Date datefin) {
        this.idpromo = idpromo;
        this.pourcentage = pourcentage;
        this.description = description;
        this.datedebut = datedebut;
        this.datefin = datefin;
    }

    public Integer getIdpromo() {
        return idpromo;
    }

    public void setIdpromo(Integer idpromo) {
        this.idpromo = idpromo;
    }

    public short getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(short pourcentage) {
        this.pourcentage = pourcentage;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDatedebut() {
        return datedebut;
    }

    public void setDatedebut(Date datedebut) {
        this.datedebut = datedebut;
    }

    public Date getDatefin() {
        return datefin;
    }

    public void setDatefin(Date datefin) {
        this.datefin = datefin;
    }

    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpromo != null ? idpromo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promotion)) {
            return false;
        }
        Promotion other = (Promotion) object;
        if ((this.idpromo == null && other.idpromo != null) || (this.idpromo != null && !this.idpromo.equals(other.idpromo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Promotion[ idpromo=" + idpromo + " ]";
    }
    
}
