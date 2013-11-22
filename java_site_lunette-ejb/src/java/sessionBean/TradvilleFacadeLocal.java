/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import model.Tradville;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author etu17965
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
