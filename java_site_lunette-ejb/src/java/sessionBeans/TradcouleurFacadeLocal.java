/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Tradcouleur;

/**
 *
 * @author Unklyf
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
