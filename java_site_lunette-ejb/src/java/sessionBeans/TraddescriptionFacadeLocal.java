/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Traddescription;

/**
 *
 * @author Unklyf
 */
@Local
public interface TraddescriptionFacadeLocal {

    /**
     *
     * @param traddescription
     */
    void create(Traddescription traddescription);

    /**
     *
     * @param traddescription
     */
    void edit(Traddescription traddescription);

    /**
     *
     * @param traddescription
     */
    void remove(Traddescription traddescription);

    /**
     *
     * @param id
     * @return
     */
    Traddescription find(Object id);

    /**
     *
     * @return
     */
    List<Traddescription> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Traddescription> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
    /**
     *
     * @param iddescription
     * @param idlangue
     * @return
     */
    Traddescription findDescription(int iddescription, int idlangue);
    
 
}
