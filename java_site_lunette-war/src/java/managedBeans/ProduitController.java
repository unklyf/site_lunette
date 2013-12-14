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
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import sessionBeans.ProduitFacadeLocal;
import model.Produit;
import model.Traddescription;
import sessionBeans.TraddescriptionFacadeLocal;


/**
 *
 * @author Unklyf
 */
@ManagedBean (name="selectProd")
@SessionScoped
public class ProduitController implements Serializable{

    
    @EJB
    private ProduitFacadeLocal prodFacade; 
    
    @EJB
    private TraddescriptionFacadeLocal descFacade;; 
    
    @ManagedProperty("#{language}")
    private Language lang;

    private int prodID; 
    
    public Language getLang() {
        return lang;
    }

    public void setLang(Language lang) {
        this.lang = lang;
    }
    
    public int getProdID() {
        return prodID;
    }

    public void setProdID(int prodID) {
        this.prodID = prodID;
    }
    
    
    public String selectProduit (int id) {
        setProdID(id);
        return "produit";
    }
    
    public Produit getProduit(){
        return prodFacade.findByIdproduit(getProdID());
    }
    
    public Traddescription getTraddescription(){
        return descFacade.findDescription(getProduit().getIddescription().getIddescription(),lang.getId());
    }
    
    public ArrayList<Produit> getLastProd(int i){
        List<Produit> prod = prodFacade.findAll();
        ArrayList<Produit> lastProd = new ArrayList<Produit>();        
        for(int j= 0; j < prod.size();j++){
            if(prod.get(j).getNouveautee() && lastProd.size() < i)
                lastProd.add(prod.get(j));
        }
        return lastProd;
    }

}
