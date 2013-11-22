/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import data.Fournisseur;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author etu17965
 */
@Stateless
public class FournisseurFacade extends AbstractFacade<Fournisseur> implements FournisseurFacadeLocal {
    @PersistenceContext(unitName = "java_site_lunette-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FournisseurFacade() {
        super(Fournisseur.class);
    }
    
}
