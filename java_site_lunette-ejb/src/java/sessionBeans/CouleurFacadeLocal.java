/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Couleur;

/**
 *
 * @author Unklyf
 */
@Local
public interface CouleurFacadeLocal {

    /**
     *
     * @param couleur
     */
    void create(Couleur couleur);

    /**
     *
     * @param couleur
     */
    void edit(Couleur couleur);

    /**
     *
     * @param couleur
     */
    void remove(Couleur couleur);

    /**
     *
     * @param id
     * @return
     */
    Couleur find(Object id);

    /**
     *
     * @return
     */
    List<Couleur> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Couleur> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
}
