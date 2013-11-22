/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import data.Tradcouleur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author etu17965
 */
@Local
public interface TradcouleurFacadeLocal {

    void create(Tradcouleur tradcouleur);

    void edit(Tradcouleur tradcouleur);

    void remove(Tradcouleur tradcouleur);

    Tradcouleur find(Object id);

    List<Tradcouleur> findAll();

    List<Tradcouleur> findRange(int[] range);

    int count();
    
}
