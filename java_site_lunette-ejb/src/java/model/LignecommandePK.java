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
 * @author Unklyf
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

    /**
     *
     */
    public LignecommandePK() {
    }

    /**
     *
     * @param idcommande
     * @param idproduit
     */
    public LignecommandePK(int idcommande, int idproduit) {
        this.idcommande = idcommande;
        this.idproduit = idproduit;
    }

    /**
     *
     * @return
     */
    public int getIdcommande() {
        return idcommande;
    }

    /**
     *
     * @param idcommande
     */
    public void setIdcommande(int idcommande) {
        this.idcommande = idcommande;
    }

    /**
     *
     * @return
     */
    public int getIdproduit() {
        return idproduit;
    }

    /**
     *
     * @param idproduit
     */
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
        return "model.LignecommandePK[ idcommande=" + idcommande + ", idproduit=" + idproduit + " ]";
    }
    
}
