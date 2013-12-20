/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Tradcategorie;

/**
 *
 * @author Unklyf
 */
@Stateless
public class TradcategorieFacade extends AbstractFacade<Tradcategorie> implements TradcategorieFacadeLocal {
    @PersistenceContext(unitName = "java_site_lunette-ejbPU")
    private EntityManager em;

    /**
     *
     * @return
     */
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    /**
     *
     */
    public TradcategorieFacade() {
        super(Tradcategorie.class);
    }
    
    /**
     *
     * @param idcategorie
     * @param idlangue
     * @return
     */
    @Override
    public Tradcategorie findTradLibelle(int idcategorie, int idlangue){
        Query query;
        query = em.createNamedQuery("Tradcategorie.findTradLibelle");
        query.setParameter("idcategorie", idcategorie);
        query.setParameter("idlangue", idlangue);
        return (Tradcategorie) query.getSingleResult();
    }
    
}
