/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author etu17965
 */
@Embeddable
public class LignecommandePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOMMANDE")
    private int idcommande;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRODUIT")
    private int idproduit;

    public LignecommandePK() {
    }

    public LignecommandePK(int idcommande, int idproduit) {
        this.idcommande = idcommande;
        this.idproduit = idproduit;
    }

    public int getIdcommande() {
        return idcommande;
    }

    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    public int getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(int idproduit) {
        this.idproduit = idproduit;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcommande;
        hash += (int) idproduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LignecommandePK)) {
            return false;
        }
        LignecommandePK other = (LignecommandePK) object;
        if (this.idcommande != other.idcommande) {
            return false;
        }
        if (this.idproduit != other.idproduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.LignecommandePK[ idcommande=" + idcommande + ", idproduit=" + idproduit + " ]";
    }
    
}
