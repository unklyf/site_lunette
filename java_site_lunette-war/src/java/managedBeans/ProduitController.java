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
    private TraddescriptionFacadeLocal descFacade;
        
    @ManagedProperty("#{language}")
    private Language lang;

    private int prodID; 
    
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
    public int getProdID() {
        return prodID;
    }

    /**
     *
     * @param prodID
     */
    public void setProdID(int prodID) {
        this.prodID = prodID;
    }
    
    /**
     *
     * @return
     */
    public Produit getProduit(){
        return prodFacade.findByIdproduit(getProdID());
    }
    
    
    //METHODES
    
    /**
     * Obtenir plus d infos sur un produit
     * 
     * @param id du produit que l on veut selectionner
     * @return la page xhtml du produit
     * @see String
     */
    public String selectProduit (int id) {
        setProdID(id);
        return "produit";
    }
      
    /**
     * Obtenir la traduction de la description du produit 
     * 
     * @return la traduction de la description du produit 
     * @see Traddescription
     */
    public Traddescription getTraddescription(){
        return descFacade.findDescription(getProduit().getIddescription().getIddescription(),lang.getId());
    }
    
    /**
     * Obtenir les dernieres nouveautee de produit
     * 
     * @param i nbre de produit desiree
     * @return liste de nouveaux produit
     * @see Produit
     * @see ArrayList
     */
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
