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
@Table(name = "PAYS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pays.findAll", query = "SELECT p FROM Pays p"),
    @NamedQuery(name = "Pays.findByIdpays", query = "SELECT p FROM Pays p WHERE p.idpays = :idpays")})
public class Pays implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDPAYS")
    private Integer idpays;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idpays")
    private Collection<Client> clientCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pays")
    private Collection<Tradpays> tradpaysCollection;

    /**
     *
     */
    public Pays() {
    }

    /**
     *
     * @param idpays
     */
    public Pays(Integer idpays) {
        this.idpays = idpays;
    }

    /**
     *
     * @return
     */
    public Integer getIdpays() {
        return idpays;
    }

    /**
     *
     * @param idpays
     */
    public void setIdpays(Integer idpays) {
        this.idpays = idpays;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Client> getClientCollection() {
        return clientCollection;
    }

    /**
     *
     * @param clientCollection
     */
    public void setClientCollection(Collection<Client> clientCollection) {
        this.clientCollection = clientCollection;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Tradpays> getTradpaysCollection() {
        return tradpaysCollection;
    }

    /**
     *
     * @param tradpaysCollection
     */
    public void setTradpaysCollection(Collection<Tradpays> tradpaysCollection) {
        this.tradpaysCollection = tradpaysCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpays != null ? idpays.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pays)) {
            return false;
        }
        Pays other = (Pays) object;
        if ((this.idpays == null && other.idpays != null) || (this.idpays != null && !this.idpays.equals(other.idpays))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Pays[ idpays=" + idpays + " ]";
    }
    
}
