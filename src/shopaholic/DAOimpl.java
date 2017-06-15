/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shopaholic;

import edu.whs.dvi.ApplicationException;
import edu.whs.dvi.aufgabe1.dataaccess.DataAccessObject;
import edu.whs.dvi.aufgabe1.entities.Artikel;
import edu.whs.dvi.aufgabe1.entities.Bestellung;
import edu.whs.dvi.aufgabe1.entities.Kategorie;
import edu.whs.dvi.aufgabe1.entities.Kunde;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Properties;
import entity.KategorieDO;

/**
 *
 * @author hnzo
 */
public class DAOimpl implements DataAccessObject{

    String url = "jdbc:derby://localhost:1527/dvi-praktikum";
    //String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    Statement stmt;
    Connection con = null;
    Properties prop;
    
    
    
    public DAOimpl() {
        prop = new Properties();
        prop.put("user", "root");
        prop.put("password", "root");
        
//        try {
//            Class.forName(driver);
//        } catch (ClassNotFoundException e) {
//            System.out.println("Failed to load Jdbc-Odbc Bridge...:" 
//                    + e.getMessage());
//        }
        
        try {           
            con = DriverManager.getConnection(url, prop);
            con.setAutoCommit(false);
            
            stmt = con.createStatement();
        } catch (SQLException ex) {
            System.out.println("SQL Exception occured: " + ex.getMessage());
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void close() throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Bestellung> getAllBestellungFor(long l) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<KategorieDO> getAllKategorie(Kategorie ktgr) {
        ArrayList<KategorieDO> al = new ArrayList<>();
        
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM KATEGORIEN");

            while (rs.next()) {
                al.add(new KategorieDO(rs.getString(2), rs.getInt(1), rs.getInt(4), rs.getString(3)));
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
            rollback();
        }

        for (Kategorie kats : al) {

            switch (kats.getKategorieNr()) {
                case 1:
                    for (Kategorie kats2 : al) {
                        if (kats2.getElternKat() == kats.getKategorieNr()) {
                            kats.addUnterkategorie(kats2);
                        }

                    }
                    break;

                case 2:
                    for (Kategorie kats2 : al) {
                        if (kats2.getElternKat() == kats.getKategorieNr()) {
                            kats.addUnterkategorie(kats2);
                        }
                    }
                    break;

                case 3:
                    for (Kategorie kats2 : al) {
                        if (kats2.getElternKat() == kats.getKategorieNr()) {
                            kats.addUnterkategorie(kats2);
                        }
                    }
                    break;

                default:
                    break;
            }
        }

        return al;
    }

    @Override
    public Collection<Kunde> getAllKunde() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int hashCode() {
        return super.hashCode(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeKunde(long l) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bestellung startBestellung(Map<Artikel, Integer> map, long l) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Bestellung startBestellung(Map<Artikel, Integer> map, String string, String string1, String string2, String string3, String string4, String string5) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void updateKunde(long l, String string, String string1, String string2, String string3, String string4, String string5) throws ApplicationException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

