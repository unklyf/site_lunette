/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Tradville;

/**
 *
 * @author Unklyf
 */
@Stateless
public class TradvilleFacade extends AbstractFacade<Tradville> implements TradvilleFacadeLocal {
    @PersistenceContext(unitName = "java_site_lunette-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TradvilleFacade() {
        super(Tradville.class);
    }
    
}
