/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import data.Categorie;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author etu17965
 */
@Local
public interface CategorieFacadeLocal {

    void create(Categorie categorie);

    void edit(Categorie categorie);

    void remove(Categorie categorie);

    Categorie find(Object id);

    List<Categorie> findAll();

    List<Categorie> findRange(int[] range);

    int count();
    
}
