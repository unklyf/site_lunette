/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import model.Promotion;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author etu17965
 */
@Local
public interface PromotionFacadeLocal {

    void create(Promotion promotion);

    void edit(Promotion promotion);

    void remove(Promotion promotion);

    Promotion find(Object id);

    List<Promotion> findAll();

    List<Promotion> findRange(int[] range);

    int count();
    
}
