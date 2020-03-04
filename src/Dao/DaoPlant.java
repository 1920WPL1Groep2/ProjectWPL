package Dao;

import Model.Plant;

import java.security.PublicKey;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//Auteur Leandro Ostyn

public class DaoPlant
{
    private final Connection dbConnection;

    private static final String GETALLPLANTSBYINITIALISE =
            "SELECT * FROM plant ";
    
    private static final String GETPLANTTBYNAAM =
            "SELECT * FROM plant WHERE fgsv LIKE ?";

    private static final String GETPLANTTBYTYPE =
            "SELECT * FROM plant WHERE type = ?";





    private PreparedStatement STMTGETPLANTBYNAAM;
    private PreparedStatement STMTGETPLANTTBYTYPE;
    private PreparedStatement STMTGETALLPLANTSBYINITIALISE;

    public DaoPlant(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;

    }

    public List<Plant> getallplant()throws SQLException{
        List<Plant> lijstplant= new ArrayList<Plant>();
        STMTGETALLPLANTSBYINITIALISE=dbConnection.prepareStatement(GETALLPLANTSBYINITIALISE);
        ResultSet rs = STMTGETPLANTBYNAAM.executeQuery();
        while (rs.next()){
            Plant plant= new Plant(rs.getInt("plant_ID"),rs.getString("type"),rs.getString("familie"),rs.getString("geslacht"),rs.getString("soort"), rs.getString("variatie"), rs.getInt("plantdichtheid_min"),rs.getInt("plantdichtheid_min"));
                lijstplant.add(plant);}
return lijstplant;
            }


   /* public Plant getplantnaam(String naam) throws SQLException {
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
*/
}
