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
public class TraddescriptionPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDDESCRIPTION")
    private int iddescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDLANGUE")
    private int idlangue;

    /**
     *
     */
    public TraddescriptionPK() {
    }

    /**
     *
     * @param iddescription
     * @param idlangue
     */
    public TraddescriptionPK(int iddescription, int idlangue) {
        this.iddescription = iddescription;
        this.idlangue = idlangue;
    }

    /**
     *
     * @return
     */
    public int getIddescription() {
        return iddescription;
    }

    /**
     *
     * @param iddescription
     */
    public void setIddescription(int iddescription) {
        this.iddescription = iddescription;
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
        hash += (int) iddescription;
        hash += (int) idlangue;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TraddescriptionPK)) {
            return false;
        }
        TraddescriptionPK other = (TraddescriptionPK) object;
        if (this.iddescription != other.iddescription) {
            return false;
        }
        if (this.idlangue != other.idlangue) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.TraddescriptionPK[ iddescription=" + iddescription + ", idlangue=" + idlangue + " ]";
    }
    
}
