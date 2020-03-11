package Dao;

import Model.Plant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Auteur Leandro Ostyn

public class DaoPlant {

    private final Connection dbConnection;
    // een lijst aan om alle gevonden planten op te slaan
    List<Plant> lijstplant = new ArrayList<Plant>();
    List<String> familielijst = new ArrayList<>();
    List<String> typelijst = new ArrayList<>();
    List<String> geslachtlijst = new ArrayList<>();
    List<String> soortlijst = new ArrayList<>();
    List<String> variantlijst = new ArrayList<>();

    //Constructor


    public DaoPlant(Connection dbConnection) throws SQLException {
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
            "SELECT DISTINCT * FROM variatie";


    //Planten opvragen bij opstart, indien geen ingegeven zoekcriteria er toch iets weergegeven wordt.
    private static final String GETALLPLANTSBYINITIALISE =
            "SELECT * FROM plant ";


    //Planten opzoeken d.m.v.  plantennaam
    private static final String GETPLANTTBYNAAM =
            "SELECT * FROM plant WHERE fgsv LIKE ?";

    //Planten opzoeken d.m.v. Volledige PlantenFamilie
    private static final String GETPLANTTBYFAMILIE =
            "SELECT * FROM plant WHERE familie LIKE ?";

    //Planten opzoeken d.m.v. Volledige plantentype
    private static final String GETPLANTTBYTYPE =
            "SELECT * FROM plant WHERE type = ?";

    //Planten opzoeken d.m.v. Volledige plantenGeslacht
    private static final String GETPLANTTBYGESLACHT =
            "SELECT * FROM plant WHERE geslacht = ?";

    //Planten opzoeken d.m.v. Volledige plantenSoort
    private static final String GETPLANTTBYSOORT =
            "SELECT * FROM plant WHERE soort = ?";

    //Combobox opvullen  in functie van  type
    private static final String GETFAMILIEBYTYPE =
            "SELECT * FROM familie WHERE type_id =(select type_id from type where type_naam = ?)";

    //Combobox opvullen  in functie van  Familie
    private static final String GETGESLACHTBYFAMILIE =
            "SELECT * FROM geslacht WHERE familie_id =(select familie_id from familie where familie_naam = ?)";


    //prepare alle Statements waar nodig
    private PreparedStatement STMTGETPLANTBYNAAM;
    private PreparedStatement STMTGETPLANTTBYFAMILIE;
    private PreparedStatement STMTGETPLANTTBYTYPE;
    private PreparedStatement STMTGETPLANTTBYGESLACHT;
    private PreparedStatement STMTGETPLANTTBYSOORT;
    private PreparedStatement STMTGETFAMILIEBYTYPE;
    private PreparedStatement STMTGETGETGESLACHTBYFAMILIE;


    //eigen functie : alle planten in een lijst steken bij initialisatie
    public List<Plant> getallplant() throws SQLException {

        //Statement creeren
        Statement stmt = dbConnection.createStatement();

        //de query uitvoeren en hier van de resultaat opslaan in de variabel "rs"
        ResultSet rs = stmt.executeQuery(GETALLPLANTSBYINITIALISE);

        //een loop maken om alle planten op te slaan in een lijst zolang er een "volgende" plant aanwezig is in de resultaatset.
        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;
    }


    //eigen functie : alle planten in een lijst steken dmv Naam (FGSV tabel)
    public List<Plant> getplantbynaam(String naam) throws SQLException {
        //Statement Voorbereiden met de naam van de correcte query
        STMTGETPLANTBYNAAM = dbConnection.prepareStatement(GETPLANTTBYNAAM);

        //de "?" benoemen met de correcte variabel zodat de query klopt. , de % worden gebruikt indien de gebruiker niet de correcte naam weet.
        STMTGETPLANTBYNAAM.setString(1, "%" + naam + "%");

        //de query uitvoeren en hier van de resultaat opslaan in de variabel "rs"
        ResultSet rs = STMTGETPLANTBYNAAM.executeQuery();
        //een loop maken om alle planten op te slaan in een lijst zolang er een "volgende" plant aanwezig is in de resultaatset.
        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;


    }

    //eigen functie : alle planten in een lijst steken dmv familie (familie tabel)
    public List<Plant> getplantfamilie(String familie) throws SQLException {

        //Statement Voorbereiden met de naam van de correcte query
        STMTGETPLANTTBYFAMILIE = dbConnection.prepareStatement(GETPLANTTBYFAMILIE);

        //de "?" benoemen met de correcte variabel zodat de query klopt. , deze halen we uit de GUI dmv de functie.
        STMTGETPLANTTBYFAMILIE.setString(1, familie);

        //de query uitvoeren en hier van de resultaat opslaan in de variabel "rs"
        ResultSet rs = STMTGETPLANTTBYFAMILIE.executeQuery();

        //een loop maken om alle planten op te slaan in een lijst zolang er een "volgende" plant aanwezig is in de resultaatset.
        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;


    }


    //eigen functie : alle planten in een lijst steken dmv type (type tabel)
    public List<Plant> getplanttype(String type) throws SQLException {

        //Statement Voorbereiden met de naam van de correcte query
        STMTGETPLANTTBYTYPE = dbConnection.prepareStatement(GETPLANTTBYTYPE);

        //de "?" benoemen met de correcte variabel zodat de query klopt. , deze halen we uit de GUI dmv de functie.
        STMTGETPLANTTBYTYPE.setString(1, type);

        //de query uitvoeren en hier van de resultaat opslaan in de variabel "rs"
        ResultSet rs = STMTGETPLANTTBYTYPE.executeQuery();

        //een loop maken om alle planten op te slaan in een lijst zolang er een "volgende" plant aanwezig is in de resultaatset.
        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;


    }

    //eigen functie : alle planten in een lijst steken dmv geslacht (geslacht tabel)
    public List<Plant> getplantgeslacht(String geslacht) throws SQLException {

        //Statement Voorbereiden met de naam van de correcte query
        STMTGETPLANTTBYGESLACHT = dbConnection.prepareStatement(GETPLANTTBYGESLACHT);

        //de "?" benoemen met de correcte variabel zodat de query klopt. , deze halen we uit de GUI dmv de functie.
        STMTGETPLANTTBYGESLACHT.setString(1, geslacht);

        //de query uitvoeren en hier van de resultaat opslaan in de variabel "rs"
        ResultSet rs = STMTGETPLANTTBYGESLACHT.executeQuery();

        //een loop maken om alle planten op te slaan in een lijst zolang er een "volgende" plant aanwezig is in de resultaatset.
        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;


    }

    //eigen functie : alle planten in een lijst steken dmv soort (soort tabel)
    public List<Plant> getplantsoort(String soort) throws SQLException {

        //Statement Voorbereiden met de naam van de correcte query
        STMTGETPLANTTBYSOORT = dbConnection.prepareStatement(GETPLANTTBYSOORT);

        //de "?" benoemen met de correcte variabel zodat de query klopt. , deze halen we uit de GUI dmv de functie.
        STMTGETPLANTTBYSOORT.setString(1, soort);

        //de query uitvoeren en hier van de resultaat opslaan in de variabel "rs"
        ResultSet rs = STMTGETPLANTTBYSOORT.executeQuery();

        //een loop maken om alle planten op te slaan in een lijst zolang er een "volgende" plant aanwezig is in de resultaatset.
        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;


    }

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
    public List<String> Familiebytpye(String type) throws SQLException {
        //Statement Voorbereiden met de naam van de correcte query
        STMTGETFAMILIEBYTYPE = dbConnection.prepareStatement(GETFAMILIEBYTYPE);

        //de "?" benoemen met de correcte variabel zodat de query klopt. , de % worden gebruikt indien de gebruiker niet de correcte naam weet.
       STMTGETFAMILIEBYTYPE.setString(1, type);

        ResultSet rs = STMTGETFAMILIEBYTYPE.executeQuery();
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
    public List<String> Geslachtbyfamilie(String familie) throws SQLException {
        //Statement Voorbereiden met de naam van de correcte query
        STMTGETGETGESLACHTBYFAMILIE = dbConnection.prepareStatement(GETGESLACHTBYFAMILIE);

        //de "?" benoemen met de correcte variabel zodat de query klopt. , de % worden gebruikt indien de gebruiker niet de correcte naam weet.
        STMTGETGETGESLACHTBYFAMILIE.setString(1, familie);

        ResultSet rs = STMTGETFAMILIEBYTYPE.executeQuery();
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
            String variant = rs.getString("variatie_naam");
            variantlijst.add(variant);
        }
        return variantlijst;

    }

}
