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

    void create(Traddescription traddescription);

    void edit(Traddescription traddescription);

    void remove(Traddescription traddescription);

    Traddescription find(Object id);

    List<Traddescription> findAll();

    List<Traddescription> findRange(int[] range);

    int count();
    
    Traddescription findDescription(int iddescription, int idlangue);
    
 
}
