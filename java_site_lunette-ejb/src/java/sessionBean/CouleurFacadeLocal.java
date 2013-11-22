/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import data.Couleur;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author etu17965
 */
@Local
public interface CouleurFacadeLocal {

    void create(Couleur couleur);

    void edit(Couleur couleur);

    void remove(Couleur couleur);

    Couleur find(Object id);

    List<Couleur> findAll();

    List<Couleur> findRange(int[] range);

    int count();
    
}
