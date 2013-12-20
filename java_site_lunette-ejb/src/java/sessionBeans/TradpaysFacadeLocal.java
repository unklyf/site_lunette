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

    /**
     *
     * @param tradpays
     */
    void create(Tradpays tradpays);

    /**
     *
     * @param tradpays
     */
    void edit(Tradpays tradpays);

    /**
     *
     * @param tradpays
     */
    void remove(Tradpays tradpays);

    /**
     *
     * @param id
     * @return
     */
    Tradpays find(Object id);

    /**
     *
     * @return
     */
    List<Tradpays> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Tradpays> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
    /**
     *
     * @param idpays
     * @param idlangue
     * @return
     */
    Tradpays findPays(int idpays, int idlangue);
    
}
