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
/**
 *
 * @author Unklyf
 */
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
    private double total;
    private int quantitee;
    private boolean cache;

    public boolean isCache() {
        return cache;
    }

    public void setCache(boolean cache) {
        this.cache = cache;
    }

    public Connexion getConnexion() {
        return connexion;
    }

    public void setConnexion(Connexion connexion) {
        this.connexion = connexion;
    }
    
    public int getQuantitee() {
        return quantitee;
    }

    public void setQuantitee(int quantitee) {
        this.quantitee = quantitee;
    }


    public double getTotal() {
        return this.CalculTotal();
    }
    
    public void setCaddie(HashMap caddie) {
        this.caddie = caddie;
    }

    public void setTotal(double total) {
        this.total = total;
    }

  
    public HashMap getCaddie() {
        return caddie;
    }
    
    public List<Lignecommande> getMapAsList (){
         return new ArrayList<Lignecommande> (caddie.values());       
    }
    
    public Lignecommande getElmt (int id){
         return (Lignecommande) caddie.get(id);       
    }
    
    public String removeItem(Integer id){
        caddie.remove(id);
        return "cart";
    }
    
    public String addItem(Produit prod){
        caddie.put(prod.getIdproduit(),new Lignecommande(prod, quantitee, prod.getPrixunitaire()));
        return "cart";
    }
    
    public String upQte(Produit prod){
        quantitee=getElmt(prod.getIdproduit()).getQuantitee()+1;
        caddie.remove(prod.getIdproduit());
        caddie.put(prod.getIdproduit(),new Lignecommande(prod, quantitee, prod.getPrixunitaire()));
        return "cart";
    }
    
    public String downQte(Produit prod){
        quantitee=getElmt(prod.getIdproduit()).getQuantitee()-1;
        if(quantitee!=0){
            caddie.remove(prod.getIdproduit());
            caddie.put(prod.getIdproduit(),new Lignecommande(prod, quantitee, prod.getPrixunitaire()));
            setQuantitee(0);
        }
        else
            removeItem(prod.getIdproduit());
            return "cart";
    }
    
    public double calculTotalProduit(Produit prod){
        double totprod;   
        if(prod.getIdpromo()!=null){
           totprod = 0;
           if(verifPromo(prod)){
               totprod = calculPrix(prod) * getElmt(prod.getIdproduit()).getQuantitee();
           }
        }
        else{
            totprod = prod.getPrixunitaire() * getElmt(prod.getIdproduit()).getQuantitee();
        }
        
        return totprod;
    }
    
    public double CalculTotal(){
        double total=0;
        List <Lignecommande> liste =getMapAsList();
        for(int i=0; i< liste.size();i++){
            total += calculTotalProduit(liste.get(i).getProduit());
        }     
        return total;
    }
    
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
    
    public double calculPrix(Produit prod){        
        double prix =(prod.getPrixunitaire())- (prod.getIdpromo().getPourcentage()* prod.getPrixunitaire()/100);
        caddie.remove(prod.getIdproduit());
        caddie.put(prod.getIdproduit(),new Lignecommande(prod, quantitee,prix));
        return prix;
    }
    
    public String cloturerCommande(){
        Date today = new Date();
        com= new Commande(today,"En cours de traitement","Paye", connexion.getCli() );
        commFacade.create(com);
        
        for(Entry<Integer,Lignecommande> select :caddie.entrySet()){    
            
            //ajout coll
            Lignecommande ligneCom = select.getValue();
            
            //set id
            ligneCom.setCommande(com);
            ligneCom.setLignecommandePK(new LignecommandePK(com.getIdcommande(), ligneCom.getProduit().getIdproduit()));
            ligneCom.getCommande().addLignecommande(ligneCom);
            com.addLignecommande(ligneCom);
            //com.getLignecommandeCollection().add(ligneCom);
            
            //create ligne            
            licommFacade.create(ligneCom);
        }
        //vider panier
        caddie.clear();
        return "compte"; 
    }
    
    public List <Commande> getAllCommande(){
        return commFacade.findByClient(connexion.getCli());
    }
    
}

