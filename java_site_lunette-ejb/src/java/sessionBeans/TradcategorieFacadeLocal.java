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

    /**
     *
     * @param tradcategorie
     */
    void create(Tradcategorie tradcategorie);

    /**
     *
     * @param tradcategorie
     */
    void edit(Tradcategorie tradcategorie);

    /**
     *
     * @param tradcategorie
     */
    void remove(Tradcategorie tradcategorie);

    /**
     *
     * @param id
     * @return
     */
    Tradcategorie find(Object id);

    /**
     *
     * @return
     */
    List<Tradcategorie> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Tradcategorie> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
     /**
     *
     * @param idcategorie
     * @param idlangue
     * @return
     */
    Tradcategorie findTradLibelle(int idcategorie, int idlangue);
    
}
