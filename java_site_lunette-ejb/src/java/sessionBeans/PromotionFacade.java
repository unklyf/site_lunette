/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Promotion;

/**
 *
 * @author Unklyf
 */
@Stateless
public class PromotionFacade extends AbstractFacade<Promotion> implements PromotionFacadeLocal {
    @PersistenceContext(unitName = "java_site_lunette-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PromotionFacade() {
        super(Promotion.class);
    }
    
}
