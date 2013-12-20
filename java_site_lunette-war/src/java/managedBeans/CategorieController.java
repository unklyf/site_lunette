/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import sessionBeans.CategorieFacadeLocal;
import model.Produit;
import model.Categorie;
import sessionBeans.ProduitFacadeLocal;
import sessionBeans.TradcategorieFacadeLocal;
import model.Tradcategorie;


/**
 *
 * @author Unklyf
 */
@ManagedBean (name="categorie")
@ViewScoped
public class CategorieController implements Serializable {

    private int CatID;
    private Boolean bool=true;
    private List<Produit> listProduit;
    
    @EJB
    private CategorieFacadeLocal catFacade; 
    
    
    @EJB
    private ProduitFacadeLocal prodFacade; 
      
    @EJB
    private TradcategorieFacadeLocal tradCatFacade;
    
    @ManagedProperty("#{language}")
    private Language lang;
    
    /**
     *
     */
    @PostConstruct    
    public void init() {
        listProduit = getAllProduit();
    }
    
    
    /**
     *
     * @param listProduit
     */
    public void setListProduit(List<Produit> listProduit) {
        this.listProduit = listProduit;
    }

    /**
     *
     * @return
     */
    public List<Produit> getListProduit() {
        return listProduit;
    }
    
    /**
     *
     * @return
     */
    public List<Produit> getAllProduit() {
        return prodFacade.findAll();
    }
    
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
    public int getCatID() {
        return CatID;
    }

    /**
     *
     * @param CatID
     */
    public void setCatID(int CatID) {
        this.CatID = CatID;
    }
    
    /**
     *
     * @return
     */
    public List<Categorie> catList(){
        List<Categorie> cat = catFacade.findAll(); 
        return cat;
    }
    
    /**
     *
     * @param prod
     * @return
     */
    public boolean verifPromo (Produit prod){
        boolean verif;
        if(prod.getIdpromo() !=null){   
            Date today = new Date();
            Date promdeb = prod.getIdpromo().getDatedebut();
            Date promfin = prod.getIdpromo().getDatefin();
            verif=false;
             if((promdeb.before(today) || promdeb.equals(today)) && (promfin.after(today) || promfin.equals(today))){
                verif=true; 
             }
        }
        else{
              verif = false;
        }
        
        return verif;
    }
    
    /**
     *
     * @param p
     * @return
     */
    public double calculPrix(Produit p){
        return (p.getPrixunitaire())- (p.getIdpromo().getPourcentage()* p.getPrixunitaire()/100);
    }
    
    /**
     *
     * @param id
     * @return
     */
    public Produit getProduit(int id){
        return prodFacade.findByIdproduit(id);
    }
    
    /**
     *
     * @param id
     */
    public void selectCategorie (int id) {
        listProduit= prodFacade.findByCategorie(id);
        bool=false;
    }
    
    /**
     *
     * @return
     */
    public String setHide(){
        if(bool== false){
            return "hide";        }
        else 
        {
            return "catalogue";
        }   
    }
    
    /**
     *
     * @param cat
     * @return
     */
    public Tradcategorie getTradCategorie(int cat){
        return tradCatFacade.findTradLibelle(cat,lang.getId());
    }

 }
