/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBeans;

import java.util.List;
import javax.ejb.Local;
import model.Adresse;

/**
 *
 * @author Unklyf
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
