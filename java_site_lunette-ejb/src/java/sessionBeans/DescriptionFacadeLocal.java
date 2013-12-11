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

    void create(Description description);

    void edit(Description description);

    void remove(Description description);

    Description find(Object id);

    List<Description> findAll();

    List<Description> findRange(int[] range);

    int count();
    
}
