/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import edu.whs.dvi.aufgabe1.entities.Kunde;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author hnzo
 */

@Entity
@Table(name="Kunden")
public class KundeDO implements Serializable, Kunde {

    @GeneratedValue
    @Id
    private long kundennr;
    private String email;
    private String name;
    private String plz;
    private String strasse;
    private String vorname;
    private String ort;

    public KundeDO() {}


    public KundeDO(String email, long kundennr, String name, String plz, String strasse, String vorname, String ort) {
        this.kundennr = kundennr;
        this.email = email;
        this.name = name;
        this.plz = plz;
        this.strasse = strasse;
        this.vorname = vorname;
        this.ort = ort;
    }

    public void setKundennr(long kundennr) {
        this.kundennr = kundennr;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getEmail() {
        return this.email;
    }

    @Override
    public long getKundennr() {
        return this.kundennr;
    }

    @Override
    public String getName() {
   return this.name;
    }

    @Override
    public String getPLZ() {
        return this.plz;
    }

    @Override
    public String getStrasse() {
        return this.strasse;
    }

    @Override
    public String getVorname() {
        return this.vorname;
    }

    @Override
    public String getWohnort() {
        return this.ort;
    }
    
    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + (int) (this.kundennr ^ (this.kundennr >>> 32));
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
        final KundeDO other = (KundeDO) obj;
        if (this.kundennr != other.kundennr) {
            return false;
        }
        return true;
    }

}
