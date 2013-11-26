/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Tradpays;

/**
 *
 * @author Unklyf
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
