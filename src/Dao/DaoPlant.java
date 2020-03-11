package Dao;

import Model.Plant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Auteur Leandro Ostyn

public class DaoPlant{

    private final Connection dbConnection;
    // een lijst aan om alle gevonden planten op te slaan
    List<Plant> lijstplant = new ArrayList<Plant>();


    //Constructor


    public DaoPlant(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;

    }

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


    //prepare alle Statements waar nodig
    private PreparedStatement STMTGETPLANTBYNAAM;
    private PreparedStatement STMTGETPLANTTBYFAMILIE;
    private PreparedStatement STMTGETPLANTTBYTYPE;
    private PreparedStatement STMTGETPLANTTBYGESLACHT;
    private PreparedStatement STMTGETPLANTTBYSOORT;


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

}
