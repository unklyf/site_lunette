/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import java.util.List;
import java.util.regex.Pattern;
import javax.ejb.EJB;
import model.Client;
import sessionBeans.ClientFacadeLocal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.validator.ValidatorException;




/**
 *
 * @author Home
 */
@ManagedBean (name="createClient")
@RequestScoped
public class CreateClient implements Serializable{

   
    
    @ManagedProperty("#{connexion}")
    private Connexion connexion;

    /**
     *
     * @return
     */
    public Connexion getConnexion() {
        return connexion;
    }

    /**
     *
     * @param connexion
     */
    public void setConnexion(Connexion connexion) {
        this.connexion = connexion;
    }
    
    
    
    @EJB
    private ClientFacadeLocal clientFacade;
    
 
    
    private String nom;
    private String prenom;
    private String mail;
    private String rue;
    private short numero;
    private Character boite;
    private int codepostal;
    private String ville;
    private int pays;
    private String tel;
    private String pseudo;
    private String motdepasse;
    private String motdepasseverif;
    
    private boolean erreurPseudo;
    private boolean erreurPassword;
    private boolean erreurMail;

    /**
     *
     * @return
     */
    public String getMotdepasseverif() {
        return motdepasseverif;
    }

    /**
     *
     * @param motdepasseverif
     */
    public void setMotdepasseverif(String motdepasseverif) {
        this.motdepasseverif = motdepasseverif;
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
    public int getPays() {
        return pays;
    }

    /**
     *
     * @param pays
     */
    public void setPays(int pays) {
        this.pays = pays;
    }

    /**
     *
     * @return
     */
    public String getTel() {
        return tel;
    }

    /**
     *
     * @param tel
     */
    public void setTel(String tel) {
        this.tel = tel;
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
     * @throws ValidatorException
     */
    public String addClient()throws ValidatorException {   
      if (Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail)) {
            if(motdepasse.equals(this.motdepasseverif)){
                Client cli = new Client(this.getNom(),this.getPrenom(), this.getMail(),this.getMotdepasse(),this.getPseudo(),this.getRue(),this.getNumero(),this.getCodepostal(),this.getVille(), this.getPays(),this.getTel());
                if(this.getBoite()!= null)
                    cli.setBoite(this.getBoite());
                List<Client> testcli = clientFacade.findByLogin(this.getPseudo());
                if(testcli.isEmpty()){
                    clientFacade.create(cli);
                    connexion.setCli(cli);
                    connexion.setConnected(true);
                    connexion.setErreur(false);
                    return "compte";
                }
                else {
                    setErreurPseudo(true);
                    return "register";
                }
            }
            else{
                setErreurPassword(true);
                return "register";
            }
        }
        else {
            setErreurMail(true);
            return "register";
        }   
    }
    
    

    
    /**
     *
     * @return
     */
    public boolean isErreurPassword() {
        return erreurPassword;
    }

    
    /**
     *
     * @param erreur
     */
    public void setErreurPassword (boolean erreur) {
        this.erreurPassword = erreur;
    }
    
     /**
     *
     * @return
     */
    public String setBoldErreurPassword () {
        if (isErreurPassword()) {
           // setErreurPassword(false);
            return "erreur";
        }
        else {
           // setErreurPassword(false);
            return "hide";
        }
            
    }
     
     /**
     *
     * @return
     */
    public boolean isErreurPseudo() {
        return erreurPseudo;
    }
     
     /**
     *
     * @param erreur
     */
    public void setErreurPseudo (boolean erreur) {
        this.erreurPseudo = erreur;
    }
     
     /**
     *
     * @return
     */
    public String setBoldErreurPseudo () {
        if (isErreurPseudo()) {          
            return "erreur";
        }
        else {          
            return "hide";
        }
        // setErreurPseudo(false);
            
    }

    /**
     *
     * @return
     */
    public boolean isErreurMail() {
        return erreurMail;
    }

    
    /**
     *
     * @param erreur
     */
    public void setErreurMail (boolean erreur) {
        this.erreurMail = erreur;
    }
    
     /**
     *
     * @return
     */
    public String setBoldErreurMail () {
        if (isErreurMail()) {
           // setErreurMail(false);
            return "erreur";
        }
        else {
           // setErreurMail(false);
            return "hide";
        }
            
    }
     
    

    
}