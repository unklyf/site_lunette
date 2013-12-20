package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Promotion;
import sessionBeans.PromotionFacadeLocal;


@ManagedBean (name="promo")
@ViewScoped
public class Promo implements Serializable{
    
    
    @EJB
    private PromotionFacadeLocal promFacade; 
    
    
    //GETTER / SETTER
     /**
     *
     * @return
     */
    public List<Promotion> promoList(){
        List<Promotion> promo = promFacade.findAll();
        return promo;
    }
     
    
    //METHODES
    
    /**
     * Obtenir les dernieres promotions
     * 
     * @param i nbre de promo souhaitee
     * @return une liste de promo en cours
     * @see ArrayList
     * @see Promotion
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
     * Verifier si une promo est en d actualite
     *
     * @param prom a verifier
     * @return
     * @see Boolean
     * @see Promotion
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
