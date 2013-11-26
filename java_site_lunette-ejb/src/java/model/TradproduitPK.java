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
public class TradproduitPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANGUE")
    private int idlangue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPRODUIT")
    private int idproduit;

    public TradproduitPK() {
    }

    public TradproduitPK(int idlangue, int idproduit) {
        this.idlangue = idlangue;
        this.idproduit = idproduit;
    }

    public int getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(int idlangue) {
        this.idlangue = idlangue;
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
        hash += (int) idlangue;
        hash += (int) idproduit;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradproduitPK)) {
            return false;
        }
        TradproduitPK other = (TradproduitPK) object;
        if (this.idlangue != other.idlangue) {
            return false;
        }
        if (this.idproduit != other.idproduit) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TradproduitPK[ idlangue=" + idlangue + ", idproduit=" + idproduit + " ]";
    }
    
}
