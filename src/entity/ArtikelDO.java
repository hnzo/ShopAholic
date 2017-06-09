/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import edu.whs.dvi.aufgabe1.entities.Artikel;
import edu.whs.dvi.aufgabe1.entities.Kategorie;
import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author hnzo
 */

@Entity
@Table(name="Artikel")
public class ArtikelDO implements Serializable, Artikel {

    @GeneratedValue
    @Id
    private long ArtikelNr;
    private String Beschreibung;
    @ManyToOne
    private Kategorie Kategorie;
    private long Lagerbestand;
    private String Name;
    private long Preis;

    public ArtikelDO() {
    }
    
        
    @Override
    public long getArtikelNr() {        
        return this.ArtikelNr; 
    }

    @Override
    public String getBeschreibung() {
        return this.Beschreibung;
    }

    @Override
    public Kategorie getKategorie() {
        return this.Kategorie;
    }

    @Override
    public long getLagerbestand() {
        return this.Lagerbestand;
    }

    @Override
    public String getName() {
        return this.Name;
    }

    @Override
    public long getPreis() {
        return this.Preis;
    }

    @Override
    public String toString() {        
        return this.Name; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.ArtikelNr ^ (this.ArtikelNr >>> 32));
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
        final ArtikelDO other = (ArtikelDO) obj;
        if (this.ArtikelNr != other.ArtikelNr) {
            return false;
        }
        return true;
    }

    
    
    
}
