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
import model.Produit;

/**
 *
 * @author Unklyf
 */
@Stateless
public class ProduitFacade extends AbstractFacade<Produit> implements ProduitFacadeLocal {
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
    public ProduitFacade() {
        super(Produit.class);
    }
    
    /**
     *
     * @param idcategorie
     * @return
     */
    @Override
    public List<Produit> findByCategorie(int idcategorie)
    {
        Query query;
        query = em.createNamedQuery("Produit.findByCategorie");
        query.setParameter("idcategorie", idcategorie);
        return query.getResultList();
    }
    
    /**
     *
     * @param idproduit
     * @return
     */
    @Override
    public Produit findByIdproduit(int idproduit)
    {
        Query query;
        query = em.createNamedQuery("Produit.findByIdproduit");
        query.setParameter("idproduit", idproduit);
        return (Produit) query.getSingleResult();
    }
    
    /**
     *
     * @param marque
     * @return
     */
    @Override
    public List<Produit> findByMarque (String marque) {
        Query query;
        query = em.createNamedQuery("Produit.findByMarque");
        query.setParameter("marque", marque);
        return query.getResultList();
    }
    
    
    
}
