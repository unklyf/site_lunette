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
import model.Commande;
import model.Client;

/**
 *
 * @author Unklyf
 */
@Stateless
public class CommandeFacade extends AbstractFacade<Commande> implements CommandeFacadeLocal {
    @PersistenceContext(unitName = "java_site_lunette-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CommandeFacade() {
        super(Commande.class);
    }
    
    @Override
    public List<Commande> findByClient(Client idclient)
    {
        Query query;
        query = em.createNamedQuery("Commande.findByClient");
        query.setParameter("idclient", idclient);
        return query.getResultList();
    }
}
