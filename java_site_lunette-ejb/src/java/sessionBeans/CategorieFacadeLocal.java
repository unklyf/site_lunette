/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Categorie;

/**
 *
 * @author Unklyf
 */
@Local
public interface CategorieFacadeLocal {

    /**
     *
     * @param categorie
     */
    void create(Categorie categorie);

    /**
     *
     * @param categorie
     */
    void edit(Categorie categorie);

    /**
     *
     * @param categorie
     */
    void remove(Categorie categorie);

    /**
     *
     * @param id
     * @return
     */
    Categorie find(Object id);

    /**
     *
     * @return
     */
    List<Categorie> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Categorie> findRange(int[] range);
    
    /**
     *
     * @return
     */
    int count();
    
    /**
     *
     * @param idcategorie
     * @return
     */
    Categorie findByIdcategorie(int idcategorie);
    
}
