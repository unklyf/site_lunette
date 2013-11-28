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
@ManagedBean
@SessionScoped

public class connexion {
    
    @EJB
    private ClientFacadeLocal clientFacade;

    private String pseudo;    
    private String motdepasse;
    private boolean connected = false;
    private boolean erreur = false;
    
    /**
    * Creates a new instance of connexion
    */
    public connexion() {
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
    
    public String outcomeAccount() {
        
        if (isConnected())
            return "compte";
        else
            return "login";   
    }
    
    public String bienvenue() {
        
        if (isConnected())
            return pseudo;
        else
            return "";   
    }
    
    
   public String compte(){
       if(isConnected())
           return "msg.menu_compte";
       else
           return "msg.menu_login";
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
    
    public String setBoldErreur () {
        if (erreur) {
            setErreur(false);
            return "erreur";
        }
        else {
            setErreur(false);
            return "hide";
        }
            
    }
    
    
}
