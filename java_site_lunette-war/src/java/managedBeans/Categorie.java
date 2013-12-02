/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.util.List;
import javax.ejb.EJB;
import model.Produit;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import sessionBeans.ProduitFacadeLocal;

/**
 *
 * @author Unklyf
 */
@ManagedBean (name="categorie")
@SessionScoped
public class Categorie {

    @EJB
    private ProduitFacadeLocal prodFacade;   
    
    public List<Produit> prodList(){
        List<Produit> prod = prodFacade.findAll();
        return prod;
    }

    
    
    
    
}
