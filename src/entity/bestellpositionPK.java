/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 *
 * @author hnzo
 */
@Embeddable
public class bestellpositionPK implements Serializable {
    
    public int artikelnr;
    public int bestellnr;

    public bestellpositionPK() {
    }

    public bestellpositionPK(int artikelnr, int bestellnr) {
        this.artikelnr = artikelnr;
        this.bestellnr = bestellnr;
    }

    public int getArtikelnr() {
        return artikelnr;
    }

    public void setArtikelnr(int artikelnr) {
        this.artikelnr = artikelnr;
    }

    public int getBestellnr() {
        return bestellnr;
    }

    public void setBestellnr(int bestellnr) {
        this.bestellnr = bestellnr;
    }

    
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.artikelnr;
        hash = 83 * hash + this.bestellnr;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final bestellpositionPK other = (bestellpositionPK) obj;
        if (this.artikelnr != other.artikelnr) {
            return false;
        }
        if (this.bestellnr != other.bestellnr) {
            return false;
        }
        return true;
    }
     
    
}
