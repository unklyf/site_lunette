/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Client;

/**
 *
 * @author Unklyf
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> implements ClientFacadeLocal {
    @PersistenceContext(unitName = "java_site_lunette-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }
    
    @Override
    public List<Client> connect(String pseudo,String motdepasse)
    {
        Query query;
        query = em.createNamedQuery("Client.connect");
        query.setParameter("pseudo", pseudo);
        query.setParameter("motdepasse", motdepasse);
        return query.getResultList();
    }
    
    
}
