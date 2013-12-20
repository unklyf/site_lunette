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
public class TradcouleurPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCOULEUR")
    private int idcouleur;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANGUE")
    private int idlangue;

    /**
     *
     */
    public TradcouleurPK() {
    }

    /**
     *
     * @param idcouleur
     * @param idlangue
     */
    public TradcouleurPK(int idcouleur, int idlangue) {
        this.idcouleur = idcouleur;
        this.idlangue = idlangue;
    }

    /**
     *
     * @return
     */
    public int getIdcouleur() {
        return idcouleur;
    }

    /**
     *
     * @param idcouleur
     */
    public void setIdcouleur(int idcouleur) {
        this.idcouleur = idcouleur;
    }

    /**
     *
     * @return
     */
    public int getIdlangue() {
        return idlangue;
    }

    /**
     *
     * @param idlangue
     */
    public void setIdlangue(int idlangue) {
        this.idlangue = idlangue;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idcouleur;
        hash += (int) idlangue;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradcouleurPK)) {
            return false;
        }
        TradcouleurPK other = (TradcouleurPK) object;
        if (this.idcouleur != other.idcouleur) {
            return false;
        }
        if (this.idlangue != other.idlangue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TradcouleurPK[ idcouleur=" + idcouleur + ", idlangue=" + idlangue + " ]";
    }
    
}
