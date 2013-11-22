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
public class TradvillePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANGUE")
    private int idlangue;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDVILLE")
    private int idville;

    public TradvillePK() {
    }

    public TradvillePK(int idlangue, int idville) {
        this.idlangue = idlangue;
        this.idville = idville;
    }

    public int getIdlangue() {
        return idlangue;
    }

    public void setIdlangue(int idlangue) {
        this.idlangue = idlangue;
    }

    public int getIdville() {
        return idville;
    }

    public void setIdville(int idville) {
        this.idville = idville;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idlangue;
        hash += (int) idville;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TradvillePK)) {
            return false;
        }
        TradvillePK other = (TradvillePK) object;
        if (this.idlangue != other.idlangue) {
            return false;
        }
        if (this.idville != other.idville) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "data.TradvillePK[ idlangue=" + idlangue + ", idville=" + idville + " ]";
    }
    
}
