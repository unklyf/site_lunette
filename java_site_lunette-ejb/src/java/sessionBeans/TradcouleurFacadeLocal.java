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

    /**
     *
     * @param tradcouleur
     */
    void create(Tradcouleur tradcouleur);

    /**
     *
     * @param tradcouleur
     */
    void edit(Tradcouleur tradcouleur);

    /**
     *
     * @param tradcouleur
     */
    void remove(Tradcouleur tradcouleur);

    /**
     *
     * @param id
     * @return
     */
    Tradcouleur find(Object id);

    /**
     *
     * @return
     */
    List<Tradcouleur> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Tradcouleur> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
}
