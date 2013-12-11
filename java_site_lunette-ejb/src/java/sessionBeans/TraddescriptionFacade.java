/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Traddescription;

/**
 *
 * @author Unklyf
 */
@Stateless
public class TraddescriptionFacade extends AbstractFacade<Traddescription> implements TraddescriptionFacadeLocal {
    @PersistenceContext(unitName = "java_site_lunette-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TraddescriptionFacade() {
        super(Traddescription.class);
    }
    
    @Override
    public Traddescription findDescription(int iddescription, int idlangue)
    {
        Query query;
        query = em.createNamedQuery("Traddescription.findDescription");
        query.setParameter("iddescription", iddescription);
        query.setParameter("idlangue", idlangue);
        return (Traddescription) query.getSingleResult();
    }
    
}
