/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Lignecommande;

/**
 *
 * @author Unklyf
 */
@Local
public interface LignecommandeFacadeLocal {

    /**
     *
     * @param lignecommande
     */
    void create(Lignecommande lignecommande);

    /**
     *
     * @param lignecommande
     */
    void edit(Lignecommande lignecommande);

    /**
     *
     * @param lignecommande
     */
    void remove(Lignecommande lignecommande);

    /**
     *
     * @param id
     * @return
     */
    Lignecommande find(Object id);

    /**
     *
     * @return
     */
    List<Lignecommande> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Lignecommande> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
}
