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
public class TradcategoriePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCATEGORIE")
    private int idcategorie;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANGUE")
    private int idlangue;

    /**
     *
     */
    public TradcategoriePK() {
    }

    /**
     *
     * @param idcategorie
     * @param idlangue
     */
    public TradcategoriePK(int idcategorie, int idlangue) {
        this.idcategorie = idcategorie;
        this.idlangue = idlangue;
    }

    /**
     *
     * @return
     */
    public int getIdcategorie() {
        return idcategorie;
    }

    /**
     *
     * @param idcategorie
     */
    public void setIdcategorie(int idcategorie) {
        this.idcategorie = idcategorie;
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
        hash += (int) idcategorie;
        hash += (int) idlangue;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradcategoriePK)) {
            return false;
        }
        TradcategoriePK other = (TradcategoriePK) object;
        if (this.idcategorie != other.idcategorie) {
            return false;
        }
        if (this.idlangue != other.idlangue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TradcategoriePK[ idcategorie=" + idcategorie + ", idlangue=" + idlangue + " ]";
    }
    
}
