/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Tradcouleur;

/**
 *
 * @author Unklyf
 */
@Stateless
public class TradcouleurFacade extends AbstractFacade<Tradcouleur> implements TradcouleurFacadeLocal {
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
    public TradcouleurFacade() {
        super(Tradcouleur.class);
    }
    
}
