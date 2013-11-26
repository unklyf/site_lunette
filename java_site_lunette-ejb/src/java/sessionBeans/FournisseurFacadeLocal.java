/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Fournisseur;

/**
 *
 * @author Unklyf
 */
@Local
public interface FournisseurFacadeLocal {

    void create(Fournisseur fournisseur);

    void edit(Fournisseur fournisseur);

    void remove(Fournisseur fournisseur);

    Fournisseur find(Object id);

    List<Fournisseur> findAll();

    List<Fournisseur> findRange(int[] range);

    int count();
    
}
