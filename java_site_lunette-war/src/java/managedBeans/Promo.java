/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Produit;
import model.Promotion;
import sessionBeans.PromotionFacadeLocal;

/**
 *
 * @author Home
 */
@ManagedBean (name="promo")
@ViewScoped
public class Promo implements Serializable{
    
    
    @EJB
    private PromotionFacadeLocal prodFacade; 
    
    
     public List<Promotion> promoList(){
        List<Promotion> promo = prodFacade.findAll();
        return promo;
    }
     
    
    
}
