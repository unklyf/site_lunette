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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Unklyf
 */
@Entity
@Table(name = "DESCRIPTION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Description.findAll", query = "SELECT d FROM Description d"),
    @NamedQuery(name = "Description.findByIddescription", query = "SELECT d FROM Description d WHERE d.iddescription = :iddescription")})
public class Description implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDDESCRIPTION")
    private Integer iddescription;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "description1")
    private Collection<Traddescription> traddescriptionCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "iddescription")
    private Collection<Produit> produitCollection;

    /**
     *
     */
    public Description() {
    }

    /**
     *
     * @param iddescription
     */
    public Description(Integer iddescription) {
        this.iddescription = iddescription;
    }

    /**
     *
     * @return
     */
    public Integer getIddescription() {
        return iddescription;
    }

    /**
     *
     * @param iddescription
     */
    public void setIddescription(Integer iddescription) {
        this.iddescription = iddescription;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Traddescription> getTraddescriptionCollection() {
        return traddescriptionCollection;
    }

    /**
     *
     * @param traddescriptionCollection
     */
    public void setTraddescriptionCollection(Collection<Traddescription> traddescriptionCollection) {
        this.traddescriptionCollection = traddescriptionCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    /**
     *
     * @param produitCollection
     */
    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddescription != null ? iddescription.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Description)) {
            return false;
        }
        Description other = (Description) object;
        if ((this.iddescription == null && other.iddescription != null) || (this.iddescription != null && !this.iddescription.equals(other.iddescription))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Description[ iddescription=" + iddescription + " ]";
    }
    
}
