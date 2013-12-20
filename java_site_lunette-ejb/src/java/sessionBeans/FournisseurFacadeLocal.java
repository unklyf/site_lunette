/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Fournisseur;

/**
 *
 * @author Unklyf
 */
@Local
public interface FournisseurFacadeLocal {

    /**
     *
     * @param fournisseur
     */
    void create(Fournisseur fournisseur);

    /**
     *
     * @param fournisseur
     */
    void edit(Fournisseur fournisseur);

    /**
     *
     * @param fournisseur
     */
    void remove(Fournisseur fournisseur);

    /**
     *
     * @param id
     * @return
     */
    Fournisseur find(Object id);

    /**
     *
     * @return
     */
    List<Fournisseur> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Fournisseur> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
}
