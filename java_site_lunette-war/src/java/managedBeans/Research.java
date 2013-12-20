package managedBeans;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Produit;
import sessionBeans.ProduitFacadeLocal;

/**
 *
 * @author Home
 */
@ManagedBean
@SessionScoped
public class Research {

    @EJB
    private ProduitFacadeLocal produitFacade;

    private List<Produit> listItems;
    private String marque;

    //GETTER / SETTER
    
    /**
     * Creates a new instance of research
     */
    public Research() {
    }
    
    /**
     *
     * @return
     */
    public String getMarque() {
        return marque;
    }

    /**
     *
     * @param marque
     */
    public void setMarque(String marque) {
        this.marque = marque;
    }
    
    /**
     * @param listItems 
     */
    public void setListItems(List<Produit> listItems) {
        this.listItems = produitFacade.findByMarque(marque);
    }
       
    /**
     *
     * @return
     */
    public List<Produit> getListItems() {
        return listItems;
        
    }

    //METHODES
   
    
    
    /**
     * Afficher la recherche
     *
     * @return la page xhtml de la recherche
     * @see String
     */
    public String searchItem () {
        getItems();
        return "research";
    }
    
    /**
     * Obtenir la liste de produit par marque en fonction de la recherche
     *
     * @return une liste de produit en fonction de la recherche
     * @see Produit
     * @see List
     */
    public List<Produit> getItems () {        
        return produitFacade.findByMarque(marque);
        
    }
}