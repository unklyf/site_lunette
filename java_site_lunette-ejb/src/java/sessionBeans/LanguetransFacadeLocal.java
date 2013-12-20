/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Languetrans;

/**
 *
 * @author Unklyf
 */
@Local
public interface LanguetransFacadeLocal {

    /**
     *
     * @param languetrans
     */
    void create(Languetrans languetrans);

    /**
     *
     * @param languetrans
     */
    void edit(Languetrans languetrans);

    /**
     *
     * @param languetrans
     */
    void remove(Languetrans languetrans);

    /**
     *
     * @param id
     * @return
     */
    Languetrans find(Object id);

    /**
     *
     * @return
     */
    List<Languetrans> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Languetrans> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
}
