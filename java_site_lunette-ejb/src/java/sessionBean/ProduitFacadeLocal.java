/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import data.Produit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author etu17965
 */
@Local
public interface ProduitFacadeLocal {

    void create(Produit produit);

    void edit(Produit produit);

    void remove(Produit produit);

    Produit find(Object id);

    List<Produit> findAll();

    List<Produit> findRange(int[] range);

    int count();
    
}
