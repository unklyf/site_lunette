/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Tradproduit;

/**
 *
 * @author Unklyf
 */
@Local
public interface TradproduitFacadeLocal {

    void create(Tradproduit tradproduit);

    void edit(Tradproduit tradproduit);

    void remove(Tradproduit tradproduit);

    Tradproduit find(Object id);

    List<Tradproduit> findAll();

    List<Tradproduit> findRange(int[] range);

    int count();
    
}
