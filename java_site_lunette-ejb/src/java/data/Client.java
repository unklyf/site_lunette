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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author etu17965
 */
@Entity
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdclient", query = "SELECT c FROM Client c WHERE c.idclient = :idclient"),
    @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Client.findByNumtelephone", query = "SELECT c FROM Client c WHERE c.numtelephone = :numtelephone"),
    @NamedQuery(name = "Client.findByMail", query = "SELECT c FROM Client c WHERE c.mail = :mail"),
    @NamedQuery(name = "Client.findByMotdepasse", query = "SELECT c FROM Client c WHERE c.motdepasse = :motdepasse"),
    @NamedQuery(name = "Client.findByAvatar", query = "SELECT c FROM Client c WHERE c.avatar = :avatar"),
    @NamedQuery(name = "Client.findByPseudo", query = "SELECT c FROM Client c WHERE c.pseudo = :pseudo")})
public class Client implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "IDCLIENT")
    private Integer idclient;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "NOM")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PRENOM")
    private String prenom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NUMTELEPHONE")
    private String numtelephone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MAIL")
    private String mail;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "MOTDEPASSE")
    private String motdepasse;
    @Size(max = 255)
    @Column(name = "AVATAR")
    private String avatar;
    @Size(max = 40)
    @Column(name = "PSEUDO")
    private String pseudo;
    @JoinColumn(name = "IDADRESSE", referencedColumnName = "IDADRESSE")
    @ManyToOne(optional = false)
    private Adresse idadresse;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idclient")
    private Collection<Commande> commandeCollection;

    public Client() {
    }

    public Client(Integer idclient) {
        this.idclient = idclient;
    }

    public Client(Integer idclient, String nom, String prenom, String numtelephone, String mail, String motdepasse) {
        this.idclient = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.numtelephone = numtelephone;
        this.mail = mail;
        this.motdepasse = motdepasse;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumtelephone() {
        return numtelephone;
    }

    public void setNumtelephone(String numtelephone) {
        this.numtelephone = numtelephone;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public Adresse getIdadresse() {
        return idadresse;
    }

    public void setIdadresse(Adresse idadresse) {
        this.idadresse = idadresse;
    }

    @XmlTransient
    public Collection<Commande> getCommandeCollection() {
        return commandeCollection;
    }

    public void setCommandeCollection(Collection<Commande> commandeCollection) {
        this.commandeCollection = commandeCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idclient != null ? idclient.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Client)) {
            return false;
        }
        Client other = (Client) object;
        if ((this.idclient == null && other.idclient != null) || (this.idclient != null && !this.idclient.equals(other.idclient))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.Client[ idclient=" + idclient + " ]";
    }
    
}
