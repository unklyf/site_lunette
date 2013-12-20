package managedBeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import javax.ejb.EJB;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import model.Commande;
import model.Lignecommande;
import model.LignecommandePK;
import model.Produit;
import sessionBeans.CommandeFacadeLocal;
import sessionBeans.LignecommandeFacadeLocal;


@ManagedBean (name="cart")
@SessionScoped
public class Cart implements Serializable{

    @ManagedProperty("#{connexion}")
    private Connexion connexion;
   
    @EJB
    private CommandeFacadeLocal commFacade;
    
    @EJB
    private LignecommandeFacadeLocal licommFacade;
    
    private HashMap <Integer, Lignecommande> caddie = new HashMap <Integer, Lignecommande> ();
      
    private Commande com;
    private int quantitee;
    //private boolean cache;

    
    //GETTER/SETTER
    /**
    public boolean isCache() {
        return cache;
    }
    public void setCache(boolean cache) {
        this.cache = cache;
    }*/

    /**
     *
     * @return
     */
    public Connexion getConnexion() {
        return connexion;
    }

    /**
     *
     * @param connexion
     */
    public void setConnexion(Connexion connexion) {
        this.connexion = connexion;
    }
    
    /**
     *
     * @return
     */
    public int getQuantitee() {
        return quantitee;
    }

    /**
     *
     * @param quantitee
     */
    public void setQuantitee(int quantitee) {
        this.quantitee = quantitee;
    }


    /**
     *
     * @return
     */
    public double getTotal() {
        return this.CalculTotal();
    }
    
    /**
     *
     * @param caddie
     */
    public void setCaddie(HashMap caddie) {
        this.caddie = caddie;
    }

    
  
    /**
     *
     * @return
     */
    public HashMap getCaddie() {
        return caddie;
    }
    
    //METHODES
    
    /**
     *
     * @return  le cpanier en tant que list
     * @see List
     * @see Lignecommande
     */
    public List<Lignecommande> getMapAsList (){
         return new ArrayList<Lignecommande> (caddie.values());       
    }
    
    /** 
    public Lignecommande getElmt (int id){
         return (Lignecommande) caddie.get(id);       
    }*/
   
    /**
     * Enlever un article du panier
     * 
     * @param id du produit a supprimer
     * @return la page xhtml du panier
     * @see String
     */
    public String removeItem(Integer id){
        caddie.remove(id);
        return "cart";
    }
    
    /**
     * Ajouter un produit au panier
     * 
     * @param prod a ajouter au panier
     * @return la page xhtml du panier
     * @see Produit
     * @see String
     */
    public String addItem(Produit prod){
        caddie.put(prod.getIdproduit(),new Lignecommande(prod, quantitee, prod.getPrixunitaire()));
        return "cart";
    }
    
    /**
     * Augmenter la qte du panier
     * 
     * @param id du produit a augmenter
     * @return la page xhtml du panier
     * @see String
     */
    public String upQte(int id){
        quantitee= caddie.get(id).getQuantitee();
        quantitee +=1;
        caddie.get(id).setQuantitee(quantitee);
        return "cart";
    }
    
    /**
     * Diminuer la qte du panier
     * 
     * @param id du produit a diminuer
     * @return la page xhtml du panier
     * @see String
     */
    public String downQte(int id){
        quantitee= caddie.get(id).getQuantitee();
        quantitee -=1;
        if(quantitee!=0){
            caddie.get(id).setQuantitee(quantitee);
        }
        else
            caddie.remove(id);
        
        return "cart";
    }
    
    /**
     * Calcul du prix promo d un produit
     *
     * @param prod produit sur lequel on calcule la promo
     * @return le prix du produit en promotion
     * @see Double
     */
    public double calculPrix(Produit prod){        
        double prix =(prod.getPrixunitaire()) - (prod.getIdpromo().getPourcentage()* prod.getPrixunitaire()/100);
        caddie.get(prod.getIdproduit()).setPrixvente(prix);
        return prix;
    }
    
    
    /**
     * Calcul total d un produit multiplie par sa quantitee
     * 
     * @param prod produit sur lequel on calcule le prix
     * @return le prix du produit
     * @see Double
     */
    public double calculTotalProduit(Produit prod){
        double totprod=0;   
        if(prod.getIdpromo()!=null){
           if(verifPromo(prod)){
               totprod = calculPrix(prod) * caddie.get(prod.getIdproduit()).getQuantitee();
           }
        }
        else{
            totprod = prod.getPrixunitaire() * (caddie.get(prod.getIdproduit()).getQuantitee());
        }
        
        return totprod;
    }
    
    
    /**
     * Calcul du total a payer pour le panier
     * 
     * @return le total du panier
     * @see Double
     */
    public double CalculTotal(){
        double totalc=0;
        List <Lignecommande> liste =getMapAsList();
        for(int i=0; i< liste.size();i++){
            totalc += calculTotalProduit(liste.get(i).getProduit());
        }
        return totalc;
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
        boolean verif=false;
        if(prod.getIdpromo() !=null){   
            Date today = new Date();
            Date promdeb = prod.getIdpromo().getDatedebut();
            Date promfin = prod.getIdpromo().getDatefin();
             if((promdeb.before(today) || promdeb.equals(today)) && (promfin.after(today) || promfin.equals(today))){
                verif=true; 
             }
        }        
        return verif;
    }
    
    
    /**
     * Enregistrement de la commande dans la BD
     *
     * @return La page web du compte avec le recapitulatif commande
     * @see String
     */
    public String cloturerCommande(){
        Date today = new Date();
        com= new Commande(today,"En cours de traitement","Paye", connexion.getCli());     
        commFacade.create(com);
      
        for(Entry<Integer,Lignecommande> select :caddie.entrySet()){    
            
            //ajout coll
            Lignecommande ligneCom = select.getValue();
             
            ligneCom.setCommande(com);
            ligneCom.setLignecommandePK(new LignecommandePK(com.getIdcommande(), ligneCom.getProduit().getIdproduit()));          
            com.getLignecommandeCollection().add(ligneCom);
      
            //create ligne            
            licommFacade.create(ligneCom);
            commFacade.edit(com);
        }
        //vider panier
        caddie.clear();
        return "compte"; 
    }
   
    /**
     * Afficher les commandes
     *
     * @return Une liste de toutes les commandes du client connecte
     * @see List
     * @see Commande
     */
    public List <Commande> getAllCommande(){                
        return commFacade.findByClient(connexion.getCli());
    }
    
    
    
    
}

