/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Client;

/**
 *
 * @author Home
 */
@Local
public interface ClientFacadeLocal {

    /**
     *
     * @param client
     */
    void create(Client client);

    /**
     *
     * @param client
     */
    void edit(Client client);

    /**
     *
     * @param client
     */
    void remove(Client client);

    /**
     *
     * @param id
     * @return
     */
    Client find(Object id);

    /**
     *
     * @return
     */
    List<Client> findAll();

    /**
     *
     * @param range
     * @return
     */
    List<Client> findRange(int[] range);

    /**
     *
     * @return
     */
    int count();
    
    /**
     *
     * @param pseudo
     * @param motdepasse
     * @return
     */
    Client connect(String pseudo, String motdepasse);
    
    /**
     *
     * @param pseudo
     * @return
     */
    List<Client> findByLogin(String pseudo);
    
}
