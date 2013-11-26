/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Tradville;

/**
 *
 * @author Unklyf
 */
@Local
public interface TradvilleFacadeLocal {

    void create(Tradville tradville);

    void edit(Tradville tradville);

    void remove(Tradville tradville);

    Tradville find(Object id);

    List<Tradville> findAll();

    List<Tradville> findRange(int[] range);

    int count();
    
}
