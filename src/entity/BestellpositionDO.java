/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import edu.whs.dvi.aufgabe1.entities.Artikel;
import edu.whs.dvi.aufgabe1.entities.Bestellposition;
import edu.whs.dvi.aufgabe1.entities.Bestellung;
import javax.persistence.*;
import java.io.Serializable;

/**
 *
 * @author hnzo
 */

@Entity
@IdClass(bestellpositionPK.class)
@Table(name="Bestellpositionen")
public class BestellpositionDO implements Serializable, Bestellposition {
    
    @EmbeddedId
    private bestellpositionPK positionPK;
    private int anzahl;
    @ManyToOne
    private ArtikelDO artikel;
    @ManyToOne
    private BestellungDO bestellung;
    private long preis;


    public BestellpositionDO() {
    }

    public BestellpositionDO(int anzahl, ArtikelDO artikel, BestellungDO bestellung, long preis) {
        this.anzahl = anzahl;
        this.artikel = artikel;
        this.bestellung = bestellung;
        this.preis = preis;
        
    }

    public void setPreis(long preis) {
        this.preis = preis;
    }

    public void setBestellung(BestellungDO bestellung) {
        this.bestellung = bestellung;
    }

    public void setAnzahl(int anzahl) {
        this.anzahl = anzahl;
    }

    public void setArtikel(ArtikelDO artikel) {
        this.artikel = artikel;
    }

    @Override
    public int getAnzahl() {
        return this.anzahl;
    }

    @Override
    public Artikel getArtikel() {
        return this.artikel;
    }

    @Override
    public Bestellung getBestellung() {
        return this.bestellung;
    }

    @Override
    public long getPreis() {
        return this.preis;
    }
    
    
    
}
