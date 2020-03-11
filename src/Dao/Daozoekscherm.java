package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

//Auteur : Leandro Ostyn
public class Daozoekscherm {
    private final Connection dbConnection;
    List<String> familielijst = new ArrayList<>();
    List<String> typelijst = new ArrayList<>();
    List<String> geslachtlijst = new ArrayList<>();
    List<String> soortlijst = new ArrayList<>();
    List<String> variantlijst = new ArrayList<>();
    List<String> kleurlijst = new ArrayList<>();
    List<String> maxgroottelijst = new ArrayList<>();
    List<String> bladvormlijst = new ArrayList<>();
    List<String> spruitfenolijst = new ArrayList<>();
    //Constructor
    public Daozoekscherm(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    //Eerst de "main" zoekpane opvullen met alle bestaande :

    //Voor combobox Familie
    public static final String GETALLFAMILIEBYINITIALISE =
            "SELECT DISTINCT * FROM familie";
    //Voor combobox Type
    private static final String GETALLTYPEBYINITIALISE =
            "SELECT DISTINCT * FROM type";

    //Voor Combobox Geslacht
    private static final String GETALLGESLACHTBYINITIALISE =
            "SELECT DISTINCT * FROM geslacht";

    //Voor Combobox Soort
    private static final String GETALLSOORTBYINITIALISE =
            "SELECT DISTINCT * FROM soort";

    //Voor Combobox Variant
    private static final String GETALLVARIANTTBYINITIALISE =
            "SELECT DISTINCT * FROM variant";

    //Voor Combobox kleuren
    private static final String GETALLKLEURENBYINITIALISE =
            "SELECT DISTINCT * FROM kleuren";

    //Voor Combobox Grootte
    private static final String GETALLGROOTTESBYINITIALISE =
            "SELECT DISTINCT * FROM maxbladgrootte";

    //Voor Combobox bladvorm
    private static final String GETALLBLADVORMNBYINITIALISE =
            "SELECT DISTINCT * FROM bladvorm";

    //Voor Combobox spruitfenologie
    private static final String GETALLSPRUITFENOBYINITIALISE =
            "SELECT DISTINCT * FROM spruitfenologie";


    //Eigen functie om combobox Familie te vullen
    public List<String> Familie() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLFAMILIEBYINITIALISE);
        while ((rs.next())) {
            String familie = rs.getString("familie_naam");
            familielijst.add(familie);
        }
        return familielijst;

    }

    //Eigen functie om combobox Type te vullen
    public List<String> Type() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLTYPEBYINITIALISE);
        while ((rs.next())) {
            String type = rs.getString("type_naam");
            typelijst.add(type);
        }
        return typelijst;

    }

    //Eigen functie om combobox Geslacht te vullen
    public List<String> Geslacht() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLGESLACHTBYINITIALISE);
        while ((rs.next())) {
            String geslacht = rs.getString("geslacht_naam");
            geslachtlijst.add(geslacht);
        }
        return geslachtlijst;

    }
    //Eigen functie om combobox Soort te vullen
    public List<String> Soort() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLSOORTBYINITIALISE);
        while ((rs.next())) {
            String soort = rs.getString("soort_naam");
            soortlijst.add(soort);
        }
        return soortlijst;

    }
    //Eigen functie om combobox variant te vullen
    public List<String> Variant() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLVARIANTTBYINITIALISE);
        while ((rs.next())) {
            String variant = rs.getString("variant_naam");
            soortlijst.add(variant);
        }
        return variantlijst;

    }
    //Auteur Leandro : alles voor de titledpane Fenotype te kunnen vullen

    //Eigen functie om combobox waar kleuren nodig zijn te vullen
    public List<String> Kleuren() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLKLEURENBYINITIALISE);
        while ((rs.next())) {
            String kleur = rs.getString("kleur");
            kleurlijst.add(kleur);
        }
        return kleurlijst;

    }

    public List<String> bladvorm() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLBLADVORMNBYINITIALISE);
        while ((rs.next())) {
            String bladvorm = rs.getString("waarde");
            bladvormlijst.add(bladvorm);
        }
        return bladvormlijst;

    }
    public List<String> Grootte() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLGROOTTESBYINITIALISE);
        while ((rs.next())) {
            String bladgrootte = rs.getString("waarde");
            maxgroottelijst.add(bladgrootte);
        }
        return maxgroottelijst;

    }
    public List<String> Spruitfeno() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLSPRUITFENOBYINITIALISE);
        while ((rs.next())) {
            String spruitfeno = rs.getString("waarde");
            spruitfenolijst.add(spruitfeno);
        }
        return spruitfenolijst;

    }
    //Auteur Leandro : alles voor de titledpane Fenotype te kunnen vullen

    
}
