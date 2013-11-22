/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import data.Tradpays;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author etu17965
 */
@Local
public interface TradpaysFacadeLocal {

    void create(Tradpays tradpays);

    void edit(Tradpays tradpays);

    void remove(Tradpays tradpays);

    Tradpays find(Object id);

    List<Tradpays> findAll();

    List<Tradpays> findRange(int[] range);

    int count();
    
}
