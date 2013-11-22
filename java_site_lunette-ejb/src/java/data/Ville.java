/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author etu17965
 */
@Entity
@Table(name = "VILLE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ville.findAll", query = "SELECT v FROM Ville v"),
    @NamedQuery(name = "Ville.findByIdville", query = "SELECT v FROM Ville v WHERE v.idville = :idville"),
    @NamedQuery(name = "Ville.findByCodepostal", query = "SELECT v FROM Ville v WHERE v.codepostal = :codepostal")})
public class Ville implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDVILLE")
    private Integer idville;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEPOSTAL")
    private int codepostal;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ville")
    private Collection<Tradville> tradvilleCollection;
    @JoinColumn(name = "IDPAYS", referencedColumnName = "IDPAYS")
    @ManyToOne(optional = false)
    private Pays idpays;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idville")
    private Collection<Adresse> adresseCollection;

    public Ville() {
    }

    public Ville(Integer idville) {
        this.idville = idville;
    }

    public Ville(Integer idville, int codepostal) {
        this.idville = idville;
        this.codepostal = codepostal;
    }

    public Integer getIdville() {
        return idville;
    }

    public void setIdville(Integer idville) {
        this.idville = idville;
    }

    public int getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
    }

    @XmlTransient
    public Collection<Tradville> getTradvilleCollection() {
        return tradvilleCollection;
    }

    public void setTradvilleCollection(Collection<Tradville> tradvilleCollection) {
        this.tradvilleCollection = tradvilleCollection;
    }

    public Pays getIdpays() {
        return idpays;
    }

    public void setIdpays(Pays idpays) {
        this.idpays = idpays;
    }

    @XmlTransient
    public Collection<Adresse> getAdresseCollection() {
        return adresseCollection;
    }

    public void setAdresseCollection(Collection<Adresse> adresseCollection) {
        this.adresseCollection = adresseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idville != null ? idville.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ville)) {
            return false;
        }
        Ville other = (Ville) object;
        if ((this.idville == null && other.idville != null) || (this.idville != null && !this.idville.equals(other.idville))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Ville[ idville=" + idville + " ]";
    }
    
}
