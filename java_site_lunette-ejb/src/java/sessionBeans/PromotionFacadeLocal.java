/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Promotion;

/**
 *
 * @author Unklyf
 */
@Local
public interface PromotionFacadeLocal {

    /**
     *
     * @param promotion
     */
    void create(Promotion promotion);

    /**
     *
     * @param promotion
     */
    void edit(Promotion promotion);

    /**
     *
     * @param promotion
     */
    void remove(Promotion promotion);

    /**
     *
     * @param id
     * @return
     */
    Promotion find(Object id);

    /**
     *
     * @return
     */
    List<Promotion> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Promotion> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
}
