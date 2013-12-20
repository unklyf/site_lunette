/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Commande;
import model.Client;

/**
 *
 * @author Unklyf
 */
@Local
public interface CommandeFacadeLocal {

    /**
     *
     * @param commande
     */
    void create(Commande commande);

    /**
     *
     * @param commande
     */
    void edit(Commande commande);

    /**
     *
     * @param commande
     */
    void remove(Commande commande);

    /**
     *
     * @param id
     * @return
     */
    Commande find(Object id);

    /**
     *
     * @return
     */
    List<Commande> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Commande> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
    /**
     *
     * @param idclient
     * @return
     */
    List<Commande> findByClient(Client idclient);
    
}
