package Dao;

import Model.Plant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Auteur Leandro Ostyn

public class DaoPlant {
    private final Connection dbConnection;
    List<Plant> lijstplant = new ArrayList<Plant>();
    private static final String GETALLPLANTSBYINITIALISE =
            "SELECT * FROM plant ";

    private static final String GETPLANTTBYNAAM =
            "SELECT * FROM plant WHERE fgsv LIKE ?";

    private static final String GETPLANTTBYTYPE =
            "SELECT * FROM plant WHERE type = ?";

    private static final String GETPLANTTBYGESLACHT =
            "SELECT * FROM plant WHERE geslacht = ?";

    private static final String GETPLANTTBYSOORT =
            "SELECT * FROM plant WHERE soort = ?";

    private PreparedStatement STMTGETPLANTBYNAAM;
    private PreparedStatement STMTGETPLANTTBYTYPE;
    private PreparedStatement STMTGETPLANTTBYGESLACHT;
    private PreparedStatement STMTGETPLANTTBYSOORT;

    public DaoPlant(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;

    }

    public List<Plant> getallplant() throws SQLException {
        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLPLANTSBYINITIALISE);
        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;
    }


    public List<Plant> getplantbynaam(String naam) throws SQLException {
        STMTGETPLANTBYNAAM = dbConnection.prepareStatement(GETPLANTTBYNAAM);
        STMTGETPLANTBYNAAM.setString(1, "%" + naam + "%");
        ResultSet rs = STMTGETPLANTBYNAAM.executeQuery();
        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;


    }

    public List<Plant> getplanttype(String type) throws SQLException {
        STMTGETPLANTTBYTYPE = dbConnection.prepareStatement(GETPLANTTBYTYPE);
        STMTGETPLANTTBYTYPE.setString(1, type);

        ResultSet rs = STMTGETPLANTTBYTYPE.executeQuery();

        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;


    }

    public List<Plant> getplantgeslacht(String geslacht) throws SQLException {
        STMTGETPLANTTBYGESLACHT = dbConnection.prepareStatement(GETPLANTTBYGESLACHT);
        STMTGETPLANTTBYGESLACHT.setString(1, geslacht);
        ResultSet rs = STMTGETPLANTTBYGESLACHT.executeQuery();

        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;


    }

    public List<Plant> getplantsoort(String soort) throws SQLException {
        STMTGETPLANTTBYSOORT = dbConnection.prepareStatement(GETPLANTTBYSOORT);
        STMTGETPLANTTBYSOORT.setString(1, soort);
        ResultSet rs = STMTGETPLANTTBYSOORT.executeQuery();

        while (rs.next()) {
            Plant plant = new Plant(rs.getInt("plant_ID"), rs.getString("type"), rs.getString("familie"), rs.getString("geslacht"), rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"), rs.getInt("plantdichtheid_min"), rs.getString("fgsv"));
            lijstplant.add(plant);
        }
        return lijstplant;


    }

}
