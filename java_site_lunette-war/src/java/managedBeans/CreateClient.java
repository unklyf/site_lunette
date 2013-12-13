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

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    
    @ManagedProperty("#{connexion}")
    private Connexion connexion;

    public Connexion getConnexion() {
        return connexion;
    }

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

    public String getMotdepasseverif() {
        return motdepasseverif;
    }

    public void setMotdepasseverif(String motdepasseverif) {
        this.motdepasseverif = motdepasseverif;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getRue() {
        return rue;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public short getNumero() {
        return numero;
    }

    public void setNumero(short numero) {
        this.numero = numero;
    }

    public Character getBoite() {
        return boite;
    }

    public void setBoite(Character boite) {
        this.boite = boite;
    }

    public int getCodepostal() {
        return codepostal;
    }

    public void setCodepostal(int codepostal) {
        this.codepostal = codepostal;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public int getPays() {
        return pays;
    }

    public void setPays(int pays) {
        this.pays = pays;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
    
    public String addClient()throws ValidatorException {   
      if (Pattern.matches("^[_a-z0-9-]+(\\.[_a-z0-9-]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)+$", mail)) {
            if(motdepasse.equals(this.motdepasseverif)){
                Client cli = new Client(this.getNom(),this.getPrenom(), this.getMail(),this.getMotdepasse(),this.getPseudo(),this.getRue(),this.getNumero(),this.getCodepostal(),this.getVille(), this.getPays());
                if(!this.getTel().isEmpty())
                    cli.setNumtelephone(this.getTel());
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
    
    

    
    public boolean isErreurPassword() {
        return erreurPassword;
    }

    
    public void setErreurPassword (boolean erreur) {
        this.erreurPassword = erreur;
    }
    
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
     
     public boolean isErreurPseudo() {
        return erreurPseudo;
    }
     
     public void setErreurPseudo (boolean erreur) {
        this.erreurPseudo = erreur;
    }
     
     public String setBoldErreurPseudo () {
        if (isErreurPseudo()) {          
            return "erreur";
        }
        else {          
            return "hide";
        }
        // setErreurPseudo(false);
            
    }

    public boolean isErreurMail() {
        return erreurMail;
    }

    
    public void setErreurMail (boolean erreur) {
        this.erreurMail = erreur;
    }
    
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