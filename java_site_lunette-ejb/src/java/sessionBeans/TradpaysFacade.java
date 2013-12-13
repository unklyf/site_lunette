/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Tradpays;

/**
 *
 * @author Unklyf
 */
@Stateless
public class TradpaysFacade extends AbstractFacade<Tradpays> implements TradpaysFacadeLocal {
    @PersistenceContext(unitName = "java_site_lunette-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TradpaysFacade() {
        super(Tradpays.class);
    }
    
    @Override
    public Tradpays findPays(int idpays, int idlangue)
    {
        Query query;
        query = em.createNamedQuery("Tradpays.findPays");
        query.setParameter("idpays", idpays);
        query.setParameter("idlangue", idlangue);
        return (Tradpays) query.getSingleResult();
    }
    
}
