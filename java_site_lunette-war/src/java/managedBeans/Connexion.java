/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.util.List;
import model.Client;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessionBeans.ClientFacadeLocal;


/**
 *
 * @author Unklyf
 */
@ManagedBean (name="connexion")
@SessionScoped

public class Connexion {
    
    @EJB
    private ClientFacadeLocal clientFacade;

    private String pseudo;    
    private String motdepasse;
    private boolean connected = false;
    private boolean erreur = false;
    
    /**
    * Creates a new instance of connexion
    */
    public Connexion() {
    }

    /**
        * @return the pseudo
    */
    public String getPseudo() {
        return pseudo;
    }

    /**
    * @param pseudo the pseudo to set
    */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
    * @return the password
    */
    public String getMotdepasse() {
        return motdepasse;
    }

    /**
    * @param password the password to set
    */
    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }
    
    
    public String login() {
        List<Client> cli = clientFacade.connect(this.getPseudo(), this.getMotdepasse());
        if (!cli.isEmpty()) {
            setConnected(true);
            setErreur(false);
            return "index";
        }
        else {
            setErreur(true);
            return null;
        }
          
    }
    
    public String logout() {
        setConnected(false);
        return "index";
    }

    /**
    * @return the connected
    */
    public boolean isConnected() {
        return connected;
    }

    /**
     * @param connected the connected to set
     */
    public void setConnected(boolean connected) {
        this.connected = connected;
    }
    
     /**
    * @return the erreur
    */
    public boolean isErreur() {
        return erreur;
    }

    /**
    * @param erreur the erreur to set
    */
    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }
    
       
    public String afficherCompte(){
       if(isConnected())
           return "connected";
       else
           return "guest";
   }
    
   
    
    public String afficherErreur () {
        if (erreur) {
            return "erreur";    
        }
        else {
            return "none";
        }
            
    }
    
    
}