/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Description;

/**
 *
 * @author Unklyf
 */
@Local
public interface DescriptionFacadeLocal {

    /**
     *
     * @param description
     */
    void create(Description description);

    /**
     *
     * @param description
     */
    void edit(Description description);

    /**
     *
     * @param description
     */
    void remove(Description description);

    /**
     *
     * @param id
     * @return
     */
    Description find(Object id);

    /**
     *
     * @return
     */
    List<Description> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Description> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
}
