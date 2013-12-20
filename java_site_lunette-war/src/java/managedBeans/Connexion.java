/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import model.Client;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;
import model.Tradpays;
import sessionBeans.ClientFacadeLocal;
import sessionBeans.TradpaysFacadeLocal;


/**
 *
 * @author Unklyf
 */
@ManagedBean (name="connexion")
@SessionScoped

public class Connexion implements Serializable{
    
    
    @EJB
    private TradpaysFacadeLocal tradPaysFacade;
    
    @EJB
    private ClientFacadeLocal clientFacade;
    
    @ManagedProperty("#{language}")
    private Language lang;

    /**
     *
     * @return
     */
    public Language getLang() {
        return lang;
    }

    /**
     *
     * @param lang
     */
    public void setLang(Language lang) {
        this.lang = lang;
    }

    private String pseudo;    
    private String motdepasse;
    private boolean connected = false;
    private boolean erreur = false;
    private Client cli;

    /**
     *
     * @return
     */
    public Client getCli() {
        return cli;
    }

    /**
     *
     * @param cli
     */
    public void setCli(Client cli) {
        this.cli = cli;
    }
    
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
     * @param motdepasse 
     */
    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
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
  
    /*public String login() {
        cli = clientFacade.connect(this.getPseudo(), this.getMotdepasse());
        if (cli!= null) {
            setErreur(false);
            setConnected(true);
            return "index";
        }
        else {
            setErreur(true);
            return throw new ;
        }
          
    }*/
    
     /**
     *
     * @return
     * @throws ValidatorException
     */
    public String login() throws ValidatorException {
        // coerce the value to an int
            try {
                cli = clientFacade.connect(this.getPseudo(), this.getMotdepasse());
                if (cli!= null) {
                    setErreur(false);
                    setConnected(true);
                    return "index";
                }      
            }
            catch(EJBException e){
                setErreur(true);
                /*FacesMessage msg = new FacesMessage("Erreur login/mot de passe");
                FacesContext.getCurrentInstance().addMessage(pseudo, msg);*/
            }
            return "login";
            
    }
    
            
    /**
     *
     * @return
     */
    public String logout() {
        setConnected(false);
        return "index";
    }
    
    /**
     *
     * @return
     */
    public String afficherCompte(){
       if(isConnected())
           return "connected";
       else
           return "guest";
    }
    
    
    /**
     *
     * @return
     */
    public String afficherErreur() {
        if (erreur) {            
            return "erreur";
        }
        else {
            setErreur(false);
            return "hide";
        }
            
    }
    
    
    /**
     *
     * @return
     */
    public Tradpays getTradpays(){
      return tradPaysFacade.findPays(cli.getIdpays().getIdpays(),lang.getId());
    } 
    
    /**
     *
     * @return
     */
    public String commander(){
       if(isConnected())
           return "commande";
       else
           return "login";
    }
    
    
}
