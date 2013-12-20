package managedBeans;

import java.io.Serializable;
import model.Client;
import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.validator.ValidatorException;
import model.Tradpays;
import sessionBeans.ClientFacadeLocal;
import sessionBeans.TradpaysFacadeLocal;


@ManagedBean (name="connexion")
@SessionScoped

public class Connexion implements Serializable{
    
    
    @EJB
    private TradpaysFacadeLocal tradPaysFacade;
    
    @EJB
    private ClientFacadeLocal clientFacade;
    
    @ManagedProperty("#{language}")
    private Language lang;
    
    private String pseudo;    
    private String motdepasse;
    private boolean connected = false;
    private boolean erreur = false;
    private Client cli;
    
    /**
    * Creates a new instance of connexion
    */
    public Connexion() {
    }

    //GETTER / SETTER
    
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
     * 
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
  
    
     //METHODES
    
     /**
     * Connection du client
     * 
     * @return page xhtml index si connection reussie sinon re page xhtml login
     * @throws ValidatorException
     * @see String
     */
    public String login() throws ValidatorException {
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
     * Deconnection du client
     *
     * @return la page xhtml index
     * @see String
     */
    public String logout() {
        setConnected(false);
        return "index";
    }
    
    /**
     * Banniere client adapte connection
     *
     * @return interface pour un visiteur ou pour un client connecte
     * @see String
     */
    public String afficherCompte(){
       if(isConnected())
           return "connected";
       else
           return "guest";
    }
    
    
    /**
     * Affiche les erreurs de connection
     *
     * @return une class css afin d afficher l erreur
     * @see String
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
     * Affiche le libelle du pays du client en fonction de la langue du site
     * 
     * @return la traduction du pays du client
     * @see Tradpays
     */
    public Tradpays getTradpays(){
      return tradPaysFacade.findPays(cli.getIdpays().getIdpays(),lang.getId());
    } 
    
    /**
     * Verification connection client pour confirmer une commande
     *
     * @return page xhtml login si non connecte et confirmation commande si connecte
     * @see String
     */
    public String commander(){
       if(isConnected())
           return "commande";
       else
           return "login";
    }
    
    
}
