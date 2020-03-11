//Auteur: Ayoub Ibourt
package Dao;

import Model.Abiotische_Factoren;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoAbiotischeFactoren {

    private final Connection dbConnection;
    List<Abiotische_Factoren> lijstabiotisch = new ArrayList<Abiotische_Factoren>();

    //Auteur Leandro:
    List<String> lijstBezonning= new ArrayList<String>();
    List<String> lijstVochtbehoefte= new ArrayList<String>();
    List<String> lijstGrondsoort= new ArrayList<String>();


    //Auteur Ayoub
    private static final String GETALLABIOTISCHEFACTOREN =
            "SELECT * FROM abiotische_factoren AND abiotisch_multi";

    private static final String GETABIOTISCHBYBEZONNING =
            "SELECT * FROM abiotische_factoren WHERE bezonning = ?";
    private static final String GETABIOTISCHBYGRONDSOORT =
            "SELECT * FROM abiotische_factoren WHERE grondsoort = ?";
    private static final String GETABIOTISCHBYVOCHTBEHOEFTE =
            "SELECT * FROM abiotische_factoren WHERE vochtbehoefte = ?";
    private static final String GETABIOTISCHBYVOEDINGSBEHOEFTE =
            "SELECT * FROM abiotische_factoren WHERE voedingsbehoefte = ?";
    private static final String GETABIOTISCHBYREACTIE =
            "SELECT * FROM abiotische_factoren WHERE reactie_antagonistische_omg = ?";

    // QUERRIES ABIOTISCH MULTI
    private static final String GETABIOTISCHBYEIGENSCHAP =
            "SELECT * FROM abiotisch_multi WHERE eigenschap = ?";
    private static final String GETABIOTISCHBYWAARDE =
            "SELECT * FROM abiotisch_multi WHERE waarde = ?";

    private PreparedStatement STMTGETABIOTISCHBYBEZONNING;
    private PreparedStatement STMTGETABIOTISCHBYGRONDSOORT;
    private PreparedStatement STMTGETABIOTISCHBYVOCHTBEHOEFTE;
    private PreparedStatement STMTGETABIOTISCHBYVOEDINGSBEHOEFTE;
    private PreparedStatement STMTGETABIOTISCHBYREACTIE;

    //PREPAREDSTATEMENTS VAN ABIOTISCH MULTI
    private PreparedStatement STMTGETABIOTISCHBYEIGENSCHAP;
    private PreparedStatement STMTGETABIOTISCHBYWAARDE;

    public DaoAbiotischeFactoren(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
    }

    public List<Abiotische_Factoren> getallabiotischefactoren() throws SQLException {
        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLABIOTISCHEFACTOREN);

        while (rs.next()) {
            Abiotische_Factoren abiotische_factoren = new Abiotische_Factoren(rs.getInt("abiotische_ID"), rs.getString("bezonning"), rs.getString("grondsoort"), rs.getString("vochtbehoefte"), rs.getString("voedingsbehoefte"), rs.getString("reactie_antagonistische_omg"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstabiotisch.add(abiotische_factoren);
        }
        return lijstabiotisch;
    }


    public List<Abiotische_Factoren> getabiotischebybezonning(String bezonning) throws SQLException {
        STMTGETABIOTISCHBYBEZONNING = dbConnection.prepareStatement(GETABIOTISCHBYBEZONNING);
        STMTGETABIOTISCHBYBEZONNING.setString(1, bezonning);
        ResultSet rs = STMTGETABIOTISCHBYBEZONNING.executeQuery();

        while (rs.next()) {
            Abiotische_Factoren abiotische_factoren = new Abiotische_Factoren(rs.getInt("abiotische_ID"), rs.getString("bezonning"), rs.getString("grondsoort"), rs.getString("vochtbehoefte"), rs.getString("voedingsbehoefte"), rs.getString("reactie_antagonistische_omg"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstabiotisch.add(abiotische_factoren);
        }
        return lijstabiotisch;
    }


    public List<Abiotische_Factoren> getabiotischebygrondsoort(String grondsoort) throws SQLException {
        STMTGETABIOTISCHBYGRONDSOORT = dbConnection.prepareStatement(GETABIOTISCHBYGRONDSOORT);
        STMTGETABIOTISCHBYGRONDSOORT.setString(1, grondsoort);
        ResultSet rs = STMTGETABIOTISCHBYGRONDSOORT.executeQuery();

        while (rs.next()) {
            Abiotische_Factoren abiotische_factoren = new Abiotische_Factoren(rs.getInt("abiotische_ID"), rs.getString("bezonning"), rs.getString("grondsoort"), rs.getString("vochtbehoefte"), rs.getString("voedingsbehoefte"), rs.getString("reactie_antagonistische_omg"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstabiotisch.add(abiotische_factoren);
        }
        return lijstabiotisch;
    }

    public List<Abiotische_Factoren> getabiotischebyvochtbehoefte(String vochtbehoefte) throws SQLException {
        STMTGETABIOTISCHBYVOCHTBEHOEFTE = dbConnection.prepareStatement(GETABIOTISCHBYVOCHTBEHOEFTE);
        STMTGETABIOTISCHBYVOCHTBEHOEFTE.setString(1, vochtbehoefte);
        ResultSet rs = STMTGETABIOTISCHBYVOCHTBEHOEFTE.executeQuery();

        while (rs.next()) {
            Abiotische_Factoren abiotische_factoren = new Abiotische_Factoren(rs.getInt("abiotische_ID"), rs.getString("bezonning"), rs.getString("grondsoort"), rs.getString("vochtbehoefte"), rs.getString("voedingsbehoefte"), rs.getString("reactie_antagonistische_omg"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstabiotisch.add(abiotische_factoren);
        }
        return lijstabiotisch;
    }

    public List<Abiotische_Factoren> getabiotischebyvoedingsbehoefte(String voedingsbehoefte) throws SQLException {
        STMTGETABIOTISCHBYVOEDINGSBEHOEFTE = dbConnection.prepareStatement(GETABIOTISCHBYVOEDINGSBEHOEFTE);
        STMTGETABIOTISCHBYVOEDINGSBEHOEFTE.setString(1, voedingsbehoefte);
        ResultSet rs = STMTGETABIOTISCHBYVOEDINGSBEHOEFTE.executeQuery();

        while (rs.next()) {
            Abiotische_Factoren abiotische_factoren = new Abiotische_Factoren(rs.getInt("abiotische_ID"), rs.getString("bezonning"), rs.getString("grondsoort"), rs.getString("vochtbehoefte"), rs.getString("voedingsbehoefte"), rs.getString("reactie_antagonistische_omg"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstabiotisch.add(abiotische_factoren);
        }
        return lijstabiotisch;
    }

    public List<Abiotische_Factoren> getabiotischebyreactie(String reactie) throws SQLException {
        STMTGETABIOTISCHBYREACTIE = dbConnection.prepareStatement(GETABIOTISCHBYREACTIE);
        STMTGETABIOTISCHBYREACTIE.setString(1, reactie);
        ResultSet rs = STMTGETABIOTISCHBYREACTIE.executeQuery();

        while (rs.next()) {
            Abiotische_Factoren abiotische_factoren = new Abiotische_Factoren(rs.getInt("abiotische_ID"), rs.getString("bezonning"), rs.getString("grondsoort"), rs.getString("vochtbehoefte"), rs.getString("voedingsbehoefte"), rs.getString("reactie_antagonistische_omg"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstabiotisch.add(abiotische_factoren);
        }
        return lijstabiotisch;
    }

    // GETTERS VAN ABIOTISCH MULTI
    public List<Abiotische_Factoren> getabiotischebyeigenschap(String eigenschap) throws SQLException {
        STMTGETABIOTISCHBYEIGENSCHAP = dbConnection.prepareStatement(GETABIOTISCHBYEIGENSCHAP);
        STMTGETABIOTISCHBYEIGENSCHAP.setString(1, eigenschap);
        ResultSet rs = STMTGETABIOTISCHBYEIGENSCHAP.executeQuery();

        while (rs.next()) {
            Abiotische_Factoren abiotische_factoren = new Abiotische_Factoren(rs.getInt("abiotische_ID"), rs.getString("bezonning"), rs.getString("grondsoort"), rs.getString("vochtbehoefte"), rs.getString("voedingsbehoefte"), rs.getString("reactie_antagonistische_omg"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstabiotisch.add(abiotische_factoren);
        }
        return lijstabiotisch;
    }

    public List<Abiotische_Factoren> getabiotischebywaarde(String waarde) throws SQLException {
        STMTGETABIOTISCHBYWAARDE = dbConnection.prepareStatement(GETABIOTISCHBYWAARDE);
        STMTGETABIOTISCHBYWAARDE.setString(1, waarde);
        ResultSet rs = STMTGETABIOTISCHBYWAARDE.executeQuery();

        while (rs.next()) {
            Abiotische_Factoren abiotische_factoren = new Abiotische_Factoren(rs.getInt("abiotische_ID"), rs.getString("bezonning"), rs.getString("grondsoort"), rs.getString("vochtbehoefte"), rs.getString("voedingsbehoefte"), rs.getString("reactie_antagonistische_omg"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstabiotisch.add(abiotische_factoren);
        }
        return lijstabiotisch;
    }

//Auteur Leandro :
    //eigen functie maken om de bezonning in combobox te steken
    public List<String> BezonningIni() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLABIOTISCHEFACTOREN);
        while ((rs.next())) {
            String bezonning = rs.getString("bezonning");
            lijstBezonning.add(bezonning);
        }
        return lijstBezonning;

    }
    //Auteur Leandro :
    //eigen functie maken om de bezonning in combobox te steken
    public List<String> VochtbehoefteIni() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLABIOTISCHEFACTOREN);
        while ((rs.next())) {
            String Vochtbehoefte = rs.getString("vochtbehoefte");
            lijstVochtbehoefte.add(Vochtbehoefte);
        }
        return lijstVochtbehoefte;

    }

    //Auteur Leandro :
    //eigen functie maken om de Grondsoort in combobox te steken
    public List<String> GrondsoortIni() throws SQLException {

        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLABIOTISCHEFACTOREN);
        while ((rs.next())) {
            String Grondsoort = rs.getString("grondsoort");
            lijstVochtbehoefte.add(Grondsoort);
        }
        return lijstVochtbehoefte;

    }

}
