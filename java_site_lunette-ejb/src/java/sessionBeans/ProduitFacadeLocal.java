/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Produit;

/**
 *
 * @author Unklyf
 */
@Local
public interface ProduitFacadeLocal {

    /**
     *
     * @param produit
     */
    void create(Produit produit);

    /**
     *
     * @param produit
     */
    void edit(Produit produit);

    /**
     *
     * @param produit
     */
    void remove(Produit produit);

    /**
     *
     * @param id
     * @return
     */
    Produit find(Object id);

    /**
     *
     * @return
     */
    List<Produit> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Produit> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
    /**
     *
     * @param idcategorie
     * @return
     */
    List<Produit> findByCategorie(int idcategorie);
    
    /**
     *
     * @param idproduit
     * @return
     */
    Produit findByIdproduit(int idproduit);
    
    /**
     *
     * @param marque
     * @return
     */
    List<Produit> findByMarque (String marque);
    
}
