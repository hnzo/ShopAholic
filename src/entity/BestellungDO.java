/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import edu.whs.dvi.aufgabe1.entities.Bestellposition;
import edu.whs.dvi.aufgabe1.entities.Bestellung;
import edu.whs.dvi.aufgabe1.entities.Kunde;
import edu.whs.dvi.aufgabe2.entities.Versand;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author hnzo
 */

@Entity
@Table(name="Bestellungen")
public class BestellungDO implements Serializable, Bestellung {
    
    @OneToOne
    private Date bestelldatum;
    @GeneratedValue
    @Id
    private long bestellnr;
    @OneToMany
    private Kunde kunde;
    private List<Bestellposition> positionen;
    @OneToOne
    private Versand versand;

    public BestellungDO() {
    }

    public BestellungDO(Date bestelldatum, long bestellnr, Kunde kunde, List<Bestellposition> positionen, Versand versand) {
        this.bestelldatum = bestelldatum;
        this.bestellnr = bestellnr;
        this.kunde = kunde;
        this.positionen = positionen;
        this.versand = versand;
    }

    public void setBestelldatum(Date bestelldatum) {
        this.bestelldatum = bestelldatum;
    }

    public void setBestellnr(long bestellnr) {
        this.bestellnr = bestellnr;
    }

    public void setKunde(Kunde kunde) {
        this.kunde = kunde;
    }

    public void setPositionen(List<Bestellposition> positionen) {
        this.positionen = positionen;
    }

    public void setVersand(Versand versand) {
        this.versand = versand;
    }

     
    @Override
    public Date getBestelldatum() {
        return this.bestelldatum;
    }

    @Override
    public long getBestellnr() {
        return this.bestellnr;
    }

    @Override
    public Kunde getKunde() {
        return this.kunde;
    }

    @Override
    public Collection<Bestellposition> getPositionen() {
        return this.positionen;
    }

    @Override
    public Versand getVersand() {
        return this.versand;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + (int) (this.bestellnr ^ (this.bestellnr >>> 32));
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
        final BestellungDO other = (BestellungDO) obj;
        if (this.bestellnr != other.bestellnr) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "" + this.bestellnr;
    }
    
    
    
}
