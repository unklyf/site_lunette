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

    void create(Languetrans languetrans);

    void edit(Languetrans languetrans);

    void remove(Languetrans languetrans);

    Languetrans find(Object id);

    List<Languetrans> findAll();

    List<Languetrans> findRange(int[] range);

    int count();
    
}
