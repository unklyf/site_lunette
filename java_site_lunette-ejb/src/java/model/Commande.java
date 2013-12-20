/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
@Table(name = "COMMANDE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Commande.findAll", query = "SELECT c FROM Commande c"),
    @NamedQuery(name = "Commande.findByClient", query = "SELECT c FROM Commande c WHERE c.idclient = :idclient"),
    @NamedQuery(name = "Commande.findByIdcommande", query = "SELECT c FROM Commande c WHERE c.idcommande = :idcommande"),
    @NamedQuery(name = "Commande.findByDatecommande", query = "SELECT c FROM Commande c WHERE c.datecommande = :datecommande"),
    @NamedQuery(name = "Commande.findByEtat", query = "SELECT c FROM Commande c WHERE c.etat = :etat"),
    @NamedQuery(name = "Commande.findByEtatpaiement", query = "SELECT c FROM Commande c WHERE c.etatpaiement = :etatpaiement")})
public class Commande implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCOMMANDE")
    private Integer idcommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DATECOMMANDE")
    @Temporal(TemporalType.DATE)
    private Date datecommande;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ETAT")
    private String etat;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ETATPAIEMENT")
    private String etatpaiement;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "commande")
    private Collection<Lignecommande> lignecommandeCollection;
    @JoinColumn(name = "IDCLIENT", referencedColumnName = "IDCLIENT")
    @ManyToOne(optional = false)
    private Client idclient;

    /**
     *
     */
    public Commande() {
    }

    /**
     *
     * @param idcommande
     */
    public Commande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    /**
     *
     * @param idcommande
     * @param datecommande
     * @param etat
     * @param etatpaiement
     */
    public Commande(Integer idcommande, Date datecommande, String etat, String etatpaiement) {
        this.idcommande = idcommande;
        this.datecommande = datecommande;
        this.etat = etat;
        this.etatpaiement = etatpaiement;
    }
    
    /**
     *
     * @param datecommande
     * @param etat
     * @param etatpaiement
     * @param idclient
     */
    public Commande(Date datecommande, String etat, String etatpaiement, Client idclient) {
        this.datecommande = datecommande;
        this.etat = etat;
        this.etatpaiement = etatpaiement;
        this.idclient= idclient;
    }

    /**
     *
     * @return
     */
    public Integer getIdcommande() {
        return idcommande;
    }

    /**
     *
     * @param idcommande
     */
    public void setIdcommande(Integer idcommande) {
        this.idcommande = idcommande;
    }

    /**
     *
     * @return
     */
    public Date getDatecommande() {
        return datecommande;
    }

    /**
     *
     * @param datecommande
     */
    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }

    /**
     *
     * @return
     */
    public String getEtat() {
        return etat;
    }

    /**
     *
     * @param etat
     */
    public void setEtat(String etat) {
        this.etat = etat;
    }

    /**
     *
     * @return
     */
    public String getEtatpaiement() {
        return etatpaiement;
    }

    /**
     *
     * @param etatpaiement
     */
    public void setEtatpaiement(String etatpaiement) {
        this.etatpaiement = etatpaiement;
    }

    /**
     *
     * @return
     */
    @XmlTransient
    public Collection<Lignecommande> getLignecommandeCollection() {
        return lignecommandeCollection;
    }
    
    /**
     *
     * @param lignecommandeCollection
     */
    public void setLignecommandeCollection(Collection<Lignecommande> lignecommandeCollection) {
        this.lignecommandeCollection = lignecommandeCollection;
    }

    /**
     *
     * @return
     */
    public Client getIdclient() {
        return idclient;
    }

    /**
     *
     * @param idclient
     */
    public void setIdclient(Client idclient) {
        this.idclient = idclient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcommande != null ? idcommande.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Commande)) {
            return false;
        }
        Commande other = (Commande) object;
        if ((this.idcommande == null && other.idcommande != null) || (this.idcommande != null && !this.idcommande.equals(other.idcommande))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Commande[ idcommande=" + idcommande + " ]";
    }
    
}
