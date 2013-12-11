/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package managedBeans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sessionBeans.CategorieFacadeLocal;
import model.Produit;
import sessionBeans.ProduitFacadeLocal;


/**
 *
 * @author Unklyf
 */
@ManagedBean (name="categorie")
@ViewScoped
public class Categorie implements Serializable {

 
    /*
    @EJB
    private CategorieFacadeLocal catFacade; 
    */
    @EJB
    private ProduitFacadeLocal prodFacade; 
      
    
    public List<Produit> prodList(){
        List<Produit> prod = prodFacade.findAll();
        return prod;
    }
    
    public List<Produit> prodCatList(int idcategorie){
        List<Produit> prod = prodFacade.findByCategorie(idcategorie);
        return prod;
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
    
    public double calculPrix(Produit p){
        return (p.getPrixunitaire())- (p.getIdpromo().getPourcentage()* p.getPrixunitaire()/100);
    }

 }
