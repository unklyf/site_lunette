/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import data.Tradproduit;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author etu17965
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
