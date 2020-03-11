package Dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoFenotype {
    Connection dbConnection;
    List<String> kleurlijst = new ArrayList<>();
    List<String> maxbladgroottelijst = new ArrayList<>();
    List<String> bladvormlijst = new ArrayList<>();
    List<String> spruitfenolijst = new ArrayList<>();

    public DaoFenotype(Connection dbConnection) {
        this.dbConnection = dbConnection;
    }

    //Auteur Leandro : alles voor de titledpane Fenotype te kunnen vullen

    //Voor Combobox kleuren
    private static final String GETALLKLEURENBYINITIALISE =
            "SELECT DISTINCT * FROM kleuren";

    //Voor Combobox Bladgrootte
    private static final String GETALLGROOTTESBYINITIALISE =
            "SELECT DISTINCT * FROM maxbladgrootte";

    //Voor Combobox bladvorm
    private static final String GETALLBLADVORMNBYINITIALISE =
            "SELECT DISTINCT * FROM bladvorm";

    //Voor Combobox spruitfenologie
    private static final String GETALLSPRUITFENOBYINITIALISE =
            "SELECT DISTINCT * FROM spruitfenologie";
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
            maxbladgroottelijst.add(bladgrootte);
        }
        return maxbladgroottelijst;

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
