/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Tradcategorie;

/**
 *
 * @author Unklyf
 */
@Stateless
public class TradcategorieFacade extends AbstractFacade<Tradcategorie> implements TradcategorieFacadeLocal {
    @PersistenceContext(unitName = "java_site_lunette-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TradcategorieFacade() {
        super(Tradcategorie.class);
    }
    
}