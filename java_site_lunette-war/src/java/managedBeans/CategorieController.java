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



@ManagedBean (name="categorie")
@ViewScoped
public class CategorieController implements Serializable {

    
    @EJB
    private CategorieFacadeLocal catFacade; 
    
    
    @EJB
    private ProduitFacadeLocal prodFacade; 
      
    @EJB
    private TradcategorieFacadeLocal tradCatFacade;
    
    @ManagedProperty("#{language}")
    private Language lang;
    
    //private int CatID;
    private Boolean bool=true;
    private List<Produit> listProduit;
    
    
    //GETTER / SETTER
    
    /**
     * Initialiser le catalogue avec tous les articles
     */
    @PostConstruct    
    public void init() {
        listProduit = getAllProduit();
    }
    
    
    /**
     *
     * @param listProduit
     * @see List
     * @see Produit
     */
    public void setListProduit(List<Produit> listProduit) {
        this.listProduit = listProduit;
    }

    /**
     *
     * @return
     * @see List
     * @see Produit
     */
    public List<Produit> getListProduit() {
        return listProduit;
    }
    
    /**
     * Obtenir tous les produits (init)
     * 
     * @return
     * @see List
     * @see Produit
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
    public int getCatID() {
        return CatID;
    }
    public void setCatID(int CatID) {
        this.CatID = CatID;
    }
    */
    
    //METHODES
    
    /**
     *
     * @return la liste de toutes les categories
     * @see List
     * @see Categorie
     */
    public List<Categorie> catList(){
        List<Categorie> cat = catFacade.findAll(); 
        return cat;
    }
    
    
    /**
     * Verification promo correspond à ajourd hui
     *
     * @param prod le produit sur lequel on doit verifier la validite de la promo
     * @return booleen qui renvoie la validite de la promo actuelle
     * @see Produit
     * @see Boolean
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
     * Calcul du prix promo d un produit
     *
     * @param p produit sur lequel on calcule la promo
     * @return le prix du produit en promotion
     * @see Double
     */
    public double calculPrix(Produit p){
        return (p.getPrixunitaire())- (p.getIdpromo().getPourcentage()* p.getPrixunitaire()/100);
    }
    
    
    public Produit getProduit(int id){
        return prodFacade.findByIdproduit(id);
    }
    
    
    /**
     * Selectionner une categorie a afficher
     * 
     * @param id de la categorie selectionnee
     */
    public void selectCategorie (int id) {
        listProduit= prodFacade.findByCategorie(id);
        bool=false;
    }
    
    /**
     * Cacher le titre Tous les artices quand article selectionne
     * 
     * @return la page xhtml du catalogue ou hide qui sera une class css pour cacher un titre texte
     * @see String
     */
    public String setHide(){
        if(bool== false){
            return "hide";        
        }
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
