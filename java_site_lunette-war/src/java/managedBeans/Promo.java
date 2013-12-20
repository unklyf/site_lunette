/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
    private PromotionFacadeLocal promFacade; 
    
    
     /**
     *
     * @return
     */
    public List<Promotion> promoList(){
        List<Promotion> promo = promFacade.findAll();
        return promo;
    }
     
    /**
     *
     * @param i
     * @return
     */
    public ArrayList<Promotion> getLastPromo(int i){
       List<Promotion> prod = promFacade.findAll();
       ArrayList<Promotion> lastPromo = new ArrayList<Promotion>();        
       for(int j= 0; j < i;j++){
            lastPromo.add(prod.get(j));
        }
        return lastPromo;
    }
    
    /**
     *
     * @param prom
     * @return
     */
    public boolean verifPromoDate (Promotion prom){
        boolean verif;
        Date today = new Date();
        Date promdeb = prom.getDatefin();
        if(promdeb.after(today) ){   
            verif=true;    
        }
        else{
              verif = false;
        }
        
        return verif;
    }
     
    
    
}
