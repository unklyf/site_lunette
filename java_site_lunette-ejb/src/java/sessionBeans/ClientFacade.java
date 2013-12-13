/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Client;
import java.util.List;


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
    
    @Override
    public void create (Client cli) {
        
        em.persist(cli);
    }

    public ClientFacade() {
        super(Client.class);
    }
    
    @Override
    public Client connect(String pseudo,String motdepasse)
    {
        Query query;
        query = em.createNamedQuery("Client.connect");
        query.setParameter("pseudo", pseudo);
        query.setParameter("motdepasse", motdepasse);
        return (Client)query.getSingleResult();
    }
    
    @Override
    public List<Client> findByLogin(String pseudo) {
        Query query;
        query = em.createNamedQuery("Client.findByPseudo");
        query.setParameter("pseudo", pseudo);
        return query.getResultList();
    }
    
}
