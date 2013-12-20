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
public class TradpaysPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANGUE")
    private int idlangue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDPAYS")
    private int idpays;

    /**
     *
     */
    public TradpaysPK() {
    }

    /**
     *
     * @param idlangue
     * @param idpays
     */
    public TradpaysPK(int idlangue, int idpays) {
        this.idlangue = idlangue;
        this.idpays = idpays;
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

    /**
     *
     * @return
     */
    public int getIdpays() {
        return idpays;
    }

    /**
     *
     * @param idpays
     */
    public void setIdpays(int idpays) {
        this.idpays = idpays;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idlangue;
        hash += (int) idpays;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradpaysPK)) {
            return false;
        }
        TradpaysPK other = (TradpaysPK) object;
        if (this.idlangue != other.idlangue) {
            return false;
        }
        if (this.idpays != other.idpays) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TradpaysPK[ idlangue=" + idlangue + ", idpays=" + idpays + " ]";
    }
    
}
