/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "CLIENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Client.connect", query = "SELECT c FROM Client c WHERE c.pseudo = :pseudo AND c.motdepasse = :motdepasse"),
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByIdclient", query = "SELECT c FROM Client c WHERE c.idclient = :idclient"),
    @NamedQuery(name = "Client.findByNom", query = "SELECT c FROM Client c WHERE c.nom = :nom"),
    @NamedQuery(name = "Client.findByPrenom", query = "SELECT c FROM Client c WHERE c.prenom = :prenom"),
    @NamedQuery(name = "Client.findByNumtelephone", query = "SELECT c FROM Client c WHERE c.numtelephone = :numtelephone"),
    @NamedQuery(name = "Client.findByMail", query = "SELECT c FROM Client c WHERE c.mail = :mail"),
    @NamedQuery(name = "Client.findByMotdepasse", query = "SELECT c FROM Client c WHERE c.motdepasse = :motdepasse"),
    @NamedQuery(name = "Client.findByPseudo", query = "SELECT c FROM Client c WHERE c.pseudo = :pseudo"),
    @NamedQuery(name = "Client.findByRue", query = "SELECT c FROM Client c WHERE c.rue = :rue"),
    @NamedQuery(name = "Client.findByNumero", query = "SELECT c FROM Client c WHERE c.numero = :numero"),
    @NamedQuery(name = "Client.findByBoite", query = "SELECT c FROM Client c WHERE c.boite = :boite"),
    @NamedQuery(name = "Client.findByCodepostal", query = "SELECT c FROM Client c WHERE c.codepostal = :codepostal"),
    @NamedQuery(name = "Client.findByVille", query = "SELECT c FROM Client c WHERE c.ville = :ville")})
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
    @Size(max = 50)
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PSEUDO")
    private String pseudo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "RUE")
    private String rue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMERO")
    private short numero;
    @Column(name = "BOITE")
    private Character boite;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODEPOSTAL")
    private int codepostal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "VILLE")
    private String ville;
    @JoinColumn(name = "IDPAYS", referencedColumnName = "IDPAYS")
    @ManyToOne(optional = false)
    private Pays idpays;

    /**
     *
     */
    public Client() {
    }

    /**
     *
     * @param idclient
     */
    public Client(Integer idclient) {
        this.idclient = idclient;
    }

    /**
     *
     * @param idclient
     * @param nom
     * @param prenom
     * @param mail
     * @param motdepasse
     * @param pseudo
     * @param rue
     * @param numero
     * @param codepostal
     * @param ville
     */
    public Client(Integer idclient, String nom, String prenom, String mail, String motdepasse, String pseudo, String rue, short numero, int codepostal, String ville) {
        this.idclient = idclient;
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motdepasse = motdepasse;
        this.pseudo = pseudo;
        this.rue = rue;
        this.numero = numero;
        this.codepostal = codepostal;
        this.ville = ville;
    }
    
    /**
     *
     * @param nom
     * @param prenom
     * @param mail
     * @param motdepasse
     * @param pseudo
     * @param rue
     * @param numero
     * @param codepostal
     * @param ville
     * @param pays
     * @param tel
     */
    public Client(String nom, String prenom, String mail, String motdepasse, String pseudo, String rue, short numero, int codepostal, String ville,int pays,String tel) {    
        this.nom = nom;
        this.prenom = prenom;
        this.mail = mail;
        this.motdepasse = motdepasse;
        this.pseudo = pseudo;
        this.rue = rue;
        this.numero = numero;
        this.codepostal = codepostal;
        this.ville = ville;
        this.idpays = new Pays(pays);
        this.numtelephone =tel;
    }

    /**
     *
     * @return
     */
    public Integer getIdclient() {
        return idclient;
    }

    /**
     *
     * @param idclient
     */
    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
    }

    /**
     *
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     *
     * @param nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     *
     * @return
     */
    public String getPrenom() {
        return prenom;
    }

    /**
     *
     * @param prenom
     */
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    /**
     *
     * @return
     */
    public String getNumtelephone() {
        return numtelephone;
    }

    /**
     *
     * @param numtelephone
     */
    public void setNumtelephone(String numtelephone) {
        this.numtelephone = numtelephone;
    }

    /**
     *
     * @return
     */
    public String getMail() {
        return mail;
    }

    /**
     *
     * @param mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     *
     * @return
     */
    public String getMotdepasse() {
        return motdepasse;
    }

    /**
     *
     * @param motdepasse
     */
    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    /**
     *
     * @return
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     *
     * @param pseudo
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     *
     * @return
     */
    public String getRue() {
        return rue;
    }

    /**
     *
     * @param rue
     */
    public void setRue(String rue) {
        this.rue = rue;
    }

    /**
     *
     * @return
     */
    public short getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(short numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public Character getBoite() {
        return boite;
    }

    /**
     *
     * @param boite
     */
    public void setBoite(Character boite) {
        this.boite = boite;
    }

    /**
     *
     * @return
     */
    public int getCodepostal() {
        return codepostal;
    }

    /**
     *
     * @param codepostal
     */
    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
    }

    /**
     *
     * @return
     */
    public String getVille() {
        return ville;
    }

    /**
     *
     * @param ville
     */
    public void setVille(String ville) {
        this.ville = ville;
    }

    /**
     *
     * @return
     */
    public Pays getIdpays() {
        return idpays;
    }

    /**
     *
     * @param idpays
     */
    public void setIdpays(Pays idpays) {
        this.idpays = idpays;
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
        return "model.Client[ idclient=" + idclient + " ]";
    }
    
}
