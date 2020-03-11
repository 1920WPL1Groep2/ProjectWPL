//Auteur: Ayoub Ibourt
package Dao;

import Model.Commensalisme;
import Model.PlantID;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoCommensalisme {
    private final Connection dbConnection;
    List<Commensalisme> lijstcom = new ArrayList<Commensalisme>();
    private static final String GETALLCOMMENSALISME =
            "SELECT * FROM commensalisme AND commensalisme_multi";
    private static final String GETCOMBYSTRATEGIE =
            "SELECT * FROM commensalisme WHERE strategie = ?";
    private static final String GETCOMBYONTWIKKELINSSNELHEID =
            "SELECT * FROM commensalisme WHERE ontwikkelingssnelheid = ?";
    // QUERRIES COMMENSALISME MULTI
    private static final String GETCOMBYEIGENSCHAP =
            "SELECT * FROM commensalisme_multi WHERE eigenschap = ?";
    private static final String GETCOMBYWAARDE =
            "SELECT * FROM commensalisme_multi WHERE waarde = ?";

    private PreparedStatement STMTGETCOMBYSTRATEGIE;
    private PreparedStatement STMTGETCOMBYONTWIKKELINSSNELHEID;
    // PREPAREDSTATEMENTS VAN COMMENSALISME MULTI
    private PreparedStatement STMTGETCOMBYEIGENSCHAP;
    private PreparedStatement STMTGETCOMBYWAARDE;

    public DaoCommensalisme(Connection dbConnection) throws SQLException {
        this.dbConnection = dbConnection;
    }

    public List<Commensalisme> getallcommensalisme() throws SQLException {
        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLCOMMENSALISME);
        while (rs.next()) {
            Commensalisme commensalisme = new Commensalisme(rs.getInt("plant_id"), rs.getInt("commensalisme_ID"), rs.getString("strategie"), rs.getString("ontwikkelingssnelheid"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstcom.add(commensalisme);
        }
        return lijstcom;
    }

    public List<Commensalisme> getcombystrategie(String strategie) throws SQLException {
        STMTGETCOMBYSTRATEGIE = dbConnection.prepareStatement(GETCOMBYSTRATEGIE);
        STMTGETCOMBYSTRATEGIE.setString(1, strategie);
        ResultSet rs = STMTGETCOMBYSTRATEGIE.executeQuery();

        while (rs.next()) {
            Commensalisme commensalisme = new Commensalisme(rs.getInt("plant_id"), rs.getInt("commensalisme_ID"), rs.getString("strategie"), rs.getString("ontwikkelingssnelheid"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstcom.add(commensalisme);
        }
        return lijstcom;
    }

    public List<Commensalisme> getcombyontwikkelingssnelheid(String ontwikkelingssnelheid) throws SQLException {
        STMTGETCOMBYONTWIKKELINSSNELHEID = dbConnection.prepareStatement(GETCOMBYONTWIKKELINSSNELHEID);
        STMTGETCOMBYONTWIKKELINSSNELHEID.setString(1, ontwikkelingssnelheid);
        ResultSet rs = STMTGETCOMBYONTWIKKELINSSNELHEID.executeQuery();

        while (rs.next()) {
            Commensalisme commensalisme = new Commensalisme(rs.getInt("plant_id"), rs.getInt("commensalisme_ID"), rs.getString("strategie"), rs.getString("ontwikkelingssnelheid"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstcom.add(commensalisme);
        }
        return lijstcom;
    }

    // GETTERS VAN COMMENSALISME MULTI
    public List<Commensalisme> getcombyeigenschap(String eigenschap) throws SQLException {
        STMTGETCOMBYEIGENSCHAP = dbConnection.prepareStatement(GETCOMBYEIGENSCHAP);
        STMTGETCOMBYEIGENSCHAP.setString(1, eigenschap);
        ResultSet rs = STMTGETCOMBYEIGENSCHAP.executeQuery();

        while (rs.next()) {
            Commensalisme commensalisme = new Commensalisme(rs.getInt("plant_id"), rs.getInt("commensalisme_ID"), rs.getString("strategie"), rs.getString("ontwikkelingssnelheid"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstcom.add(commensalisme);
        }
        return lijstcom;
    }

    public List<Commensalisme> getcombywaarde(String waarde) throws SQLException {
        STMTGETCOMBYWAARDE = dbConnection.prepareStatement(GETCOMBYWAARDE);
        STMTGETCOMBYWAARDE.setString(1, waarde);
        ResultSet rs = STMTGETCOMBYWAARDE.executeQuery();

        while (rs.next()) {
            Commensalisme commensalisme = new Commensalisme(rs.getInt("plant_id"), rs.getInt("commensalisme_ID"), rs.getString("strategie"), rs.getString("ontwikkelingssnelheid"), rs.getString("eigenschap"), rs.getString("waarde"));
            lijstcom.add(commensalisme);
        }
        return lijstcom;
    }
}
