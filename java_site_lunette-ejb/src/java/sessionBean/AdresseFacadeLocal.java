/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import data.Adresse;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author etu17965
 */
@Local
public interface AdresseFacadeLocal {

    void create(Adresse adresse);

    void edit(Adresse adresse);

    void remove(Adresse adresse);

    Adresse find(Object id);

    List<Adresse> findAll();

    List<Adresse> findRange(int[] range);

    int count();
    
}
