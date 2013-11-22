/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sessionBean;

import data.Lignecommande;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author etu17965
 */
@Local
public interface LignecommandeFacadeLocal {

    void create(Lignecommande lignecommande);

    void edit(Lignecommande lignecommande);

    void remove(Lignecommande lignecommande);

    Lignecommande find(Object id);

    List<Lignecommande> findAll();

    List<Lignecommande> findRange(int[] range);

    int count();
    
}
