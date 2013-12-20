/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Pays;

/**
 *
 * @author Unklyf
 */
@Local
public interface PaysFacadeLocal {

    /**
     *
     * @param pays
     */
    void create(Pays pays);

    /**
     *
     * @param pays
     */
    void edit(Pays pays);

    /**
     *
     * @param pays
     */
    void remove(Pays pays);

    /**
     *
     * @param id
     * @return
     */
    Pays find(Object id);

    /**
     *
     * @return
     */
    List<Pays> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Pays> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
}
