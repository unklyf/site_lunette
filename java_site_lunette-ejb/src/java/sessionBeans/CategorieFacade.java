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
import model.Categorie;

/**
 *
 * @author Unklyf
 */
@Stateless
public class CategorieFacade extends AbstractFacade<Categorie> implements CategorieFacadeLocal {
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
    public CategorieFacade() {
        super(Categorie.class);
    }
    
      
    /**
     *
     * @param idcategorie
     * @return
     */
    @Override
    public Categorie findByIdcategorie(int idcategorie)
    {
        Query query;
        query = em.createNamedQuery("Categorie.findByIdcategorie");
        query.setParameter("idcategorie", idcategorie);
        return (Categorie) query.getSingleResult();
    }
    
    
    
}
