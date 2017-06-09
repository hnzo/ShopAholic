/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import edu.whs.dvi.aufgabe1.entities.Artikel;
import edu.whs.dvi.aufgabe1.entities.Kategorie;
import java.util.Collection;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author hnzo
 */
@Entity
@Table(name="Kategorien")
public class KategorieDO implements Serializable, Kategorie {

    @GeneratedValue
    @Id
    private int katID;
    private Collection<Artikel> artikel;
    private String name;
    @OneToOne
    private Kategorie oberkategorie;

    public void setArtikel(Collection<Artikel> artikel) {
        this.artikel = artikel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOberkategorie(Kategorie oberkategorie) {
        this.oberkategorie = oberkategorie;
    }

    
    @Override
    public Collection<Artikel> getArtikel() {        
        return this.artikel;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Kategorie getOberkategorie() {        
        return this.oberkategorie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.katID;
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
        final KategorieDO other = (KategorieDO) obj;
        if (this.katID != other.katID) {
            return false;
        }
        return true;
    }
    

    @Override
    public String toString() {
        return this.name;
    }
     
    
    
}
