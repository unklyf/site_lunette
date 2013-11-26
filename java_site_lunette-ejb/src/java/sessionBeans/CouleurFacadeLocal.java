/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Couleur;

/**
 *
 * @author Unklyf
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
