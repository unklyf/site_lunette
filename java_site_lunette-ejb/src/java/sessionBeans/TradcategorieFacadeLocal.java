/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Tradcategorie;

/**
 *
 * @author Unklyf
 */
@Local
public interface TradcategorieFacadeLocal {

    void create(Tradcategorie tradcategorie);

    void edit(Tradcategorie tradcategorie);

    void remove(Tradcategorie tradcategorie);

    Tradcategorie find(Object id);

    List<Tradcategorie> findAll();

    List<Tradcategorie> findRange(int[] range);

    int count();
    
}
