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

    /**
     * Creates a new instance of research
     */
    public Research() {
    }
    
    private String marque;

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
     *
     * @return
     */
    public String searchItem () {
        getItems();
        return "research";
    }
     
     /**
     *
     * @return
     */
    public List<Produit> getItems () {        
        return produitFacade.findByMarque(marque);
        
    }

   
    /**
     *
     * @return
     */
    public List<Produit> getListItems() {
        return listItems;
    }

   
    /**
     *
     * @param listItems
     */
    public void setListItems(List<Produit> listItems) {
        this.listItems = produitFacade.findByMarque(marque);
    }
}