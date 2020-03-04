package Dao;

import Model.Plant;

import java.sql.*;

//Auteur Leandro Ostyn

public class DaoPlant
{
    private final Connection dbConnection;
    
    private static final String GETPLANTTBYNAAM =
            "SELECT * FROM plant WHERE fgsv LIKE ?";

    private static final String GETPLANTTBYTYPE =
            "SELECT * FROM plant WHERE type = ?";





    private PreparedStatement STMTGETPLANTBYNAAM;
    private PreparedStatement STMTGETPLANTTBYTYPE;

    public DaoPlant(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;

    }

    public Plant getplantnaam(String naam) throws SQLException {
        STMTGETPLANTBYNAAM = dbConnection.prepareStatement(GETPLANTTBYNAAM);
        String niets= "niet gelukt";
        STMTGETPLANTBYNAAM.setString(1, "%"+naam+"%");

        ResultSet rs = STMTGETPLANTBYNAAM.executeQuery();

        while (rs.next()) {
            Plant plant = new Plant(rs.getString("type"))
            int plantid = rs.getInt("plant_ID");
            String plantnaam = rs.getString("type");
            String familie = rs.getString("familie");
            System.out.println(plantid + "\t" + plantnaam +
                    "\t" + familie);
              return plantnaam;
        }
        return niets;

    }
    public void getplanttype(String type) throws SQLException {
        STMTGETPLANTTBYTYPE = dbConnection.prepareStatement(GETPLANTTBYTYPE);
        String niets= "niet gelukt";
        STMTGETPLANTTBYTYPE.setString(1, type);

        ResultSet rs = STMTGETPLANTTBYTYPE.executeQuery();

        while (rs.next()) {
            int plantid = rs.getInt("plant_ID");
            String plantnaam = rs.getString("type");
            String familie = rs.getString("familie");
            System.out.println(plantid + "\t" + plantnaam +
                    "\t" + familie);

        }


    }

}
