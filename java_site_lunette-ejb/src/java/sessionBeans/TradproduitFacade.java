/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Tradproduit;

/**
 *
 * @author Unklyf
 */
@Stateless
public class TradproduitFacade extends AbstractFacade<Tradproduit> implements TradproduitFacadeLocal {
    @PersistenceContext(unitName = "java_site_lunette-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TradproduitFacade() {
        super(Tradproduit.class);
    }
    
}