/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import model.Client;
import sessionBeans.ClientFacadeLocal;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;




/**
 *
 * @author Home
 */
@ManagedBean
@SessionScoped
public class createClient {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @EJB
    private ClientFacadeLocal clientFacade;
    
    private String nom;
    private String prenom;
    private boolean erreur;
    private String mail;
    private String rue;
    private int numero;
    private String boite;
    private int codepostal;
    private String ville;
    private String pays;
    private int tel;
    //private String Pseudo()

    public int getTel() {
        return tel;
    }

    public String getPays() {
        return pays;
    }

    public String getVille() {
        return ville;
    }

    public int getCodepostal() {
        return codepostal;
    }

    public String getBoite() {
        return boite;
    }

    public int getNumero() {
        return numero;
    }

    public String getRue() {
        return rue;
    }

    public String getMail() {
        return mail;
    }
    
    public String getNom() {
        return nom;
    }
    public String getPrenom() {
        return prenom;
    }
    
    public void setErreur(boolean erreur) {
        this.erreur = erreur;
    }
    
    public boolean isErreur() {
        return erreur;
    }
    

}
