//Auteur Dario Kaczmarowski
package Dao;

import Model.Extra;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoExtra
{
    //Variabelen
    private final Connection dbConnection;
    List<Extra> lijstExtra = new ArrayList<Extra>();
    private static final String GETALLEXTRA =
            "SELECT * FROM extra ";

    private static final String GETEXTRABYNECTARWAARDE =
            "SELECT * FROM extra WHERE nectarwaarde = ?";

    private static final String GETEXTRABYPOLLENWAARDE =
            "SELECT * FROM extra WHERE pollenwaarde = ?";

    private static final String GETEXTRABYBIJVRIENDELIJK =
            "SELECT * FROM extra WHERE bijvriendelijk = ?";

    private static final String GETEXTRABYEETBAARKRUIDGEBRUIK =
            "SELECT * FROM extra WHERE eetbaar_kruidgebruik = ?";

    private static final String GETEXTRABYGEUREND =
            "SELECT * FROM extra WHERE geurend = ?";

    private static final String GETEXTRABYVORSTGEVOELIG =
            "SELECT * FROM extra WHERE vorstgevoelig = ?";

    private PreparedStatement STMTGETEXTRABYNECTARWAARDE;
    private PreparedStatement STMTGETEXTRABYPOLLENWAARDE;
    private PreparedStatement STMTGETEXTRABYBIJVRIENDELIJK;
    private PreparedStatement STMTGETEXTRABYEETBAARKRUIDGEBRUIK;
    private PreparedStatement STMTGETEXTRABYGEUREND;
    private PreparedStatement STMTGETEXTRABYVORSTGEVOELIG;

    // Constructor
    public DaoExtra(Connection dbConnection) throws SQLException
    {
        this.dbConnection = dbConnection;
    }

    // get functions
    public List<Extra> GetAllExtraIni() throws SQLException
    {
        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLEXTRA);

        while (rs.next())
        {
            Extra extra = new Extra(rs.getInt("plant_ID"), rs.getInt("extraID"), rs.getString("nectarwaarde"), rs.getString("pollenwaarde"), rs.getString("bijvriendelijk"), rs.getString("eetbaarKruidgebruik"), rs.getString("geurend"), rs.getString("vorstgevoelig"));
            lijstExtra.add(extra);
        }
        return lijstExtra;
    }

    public List<Extra> GetExtraByPollenwaarde(String pollenwaarde) throws SQLException
    {
        STMTGETEXTRABYPOLLENWAARDE = dbConnection.prepareStatement(GETEXTRABYPOLLENWAARDE);
        STMTGETEXTRABYPOLLENWAARDE.setString(1, pollenwaarde);

        ResultSet rs = STMTGETEXTRABYPOLLENWAARDE.executeQuery();

        while (rs.next())
        {
            Extra extra = new Extra(rs.getInt("plant_ID"), rs.getInt("extraID"), rs.getString("nectarwaarde"), rs.getString("pollenwaarde"), rs.getString("bijvriendelijk"), rs.getString("eetbaarKruidgebruik"), rs.getString("geurend"), rs.getString("vorstgevoelig"));
            lijstExtra.add(extra);

        }
        return lijstExtra;
    }

    public List<Extra> GetExtraByNectarwaarde(String nectarwaarde) throws SQLException
    {
        STMTGETEXTRABYNECTARWAARDE = dbConnection.prepareStatement(GETEXTRABYNECTARWAARDE);
        STMTGETEXTRABYNECTARWAARDE.setString(1, nectarwaarde);

        ResultSet rs = STMTGETEXTRABYNECTARWAARDE.executeQuery();

        while (rs.next())
        {
            Extra extra = new Extra(rs.getInt("plant_ID"), rs.getInt("extraID"), rs.getString("nectarwaarde"), rs.getString("pollenwaarde"), rs.getString("bijvriendelijk"), rs.getString("eetbaarKruidgebruik"), rs.getString("geurend"), rs.getString("vorstgevoelig"));
            lijstExtra.add(extra);
        }
        return lijstExtra;
    }

    public List<Extra> GetExtraByBijvriendelijk(String bijvriendelijk) throws SQLException
    {
        STMTGETEXTRABYBIJVRIENDELIJK = dbConnection.prepareStatement(GETEXTRABYBIJVRIENDELIJK);
        STMTGETEXTRABYBIJVRIENDELIJK.setString(1, bijvriendelijk);

        ResultSet rs = STMTGETEXTRABYBIJVRIENDELIJK.executeQuery();

        while (rs.next())
        {
            Extra extra = new Extra(rs.getInt("plant_ID"), rs.getInt("extraID"), rs.getString("nectarwaarde"), rs.getString("pollenwaarde"), rs.getString("bijvriendelijk"), rs.getString("eetbaarKruidgebruik"), rs.getString("geurend"), rs.getString("vorstgevoelig"));
            lijstExtra.add(extra);
        }
        return lijstExtra;
    }

    public List<Extra> GetExtraByEetbaarKruidgebruik(String eetgebruikKuidgebruik) throws SQLException
    {
        STMTGETEXTRABYEETBAARKRUIDGEBRUIK = dbConnection.prepareStatement(GETEXTRABYEETBAARKRUIDGEBRUIK);
        STMTGETEXTRABYEETBAARKRUIDGEBRUIK.setString(1, eetgebruikKuidgebruik);

        ResultSet rs = STMTGETEXTRABYEETBAARKRUIDGEBRUIK.executeQuery();

        while (rs.next())
        {
            Extra extra = new Extra(rs.getInt("plant_ID"), rs.getInt("extraID"), rs.getString("nectarwaarde"), rs.getString("pollenwaarde"), rs.getString("bijvriendelijk"), rs.getString("eetbaarKruidgebruik"), rs.getString("geurend"), rs.getString("vorstgevoelig"));
            lijstExtra.add(extra);
        }
        return lijstExtra;
    }

    public List<Extra> GetExtraByGeurend(String geurend) throws SQLException
    {
        STMTGETEXTRABYGEUREND = dbConnection.prepareStatement(GETEXTRABYGEUREND);
        STMTGETEXTRABYGEUREND.setString(1, geurend);

        ResultSet rs = STMTGETEXTRABYPOLLENWAARDE.executeQuery();

        while (rs.next())
        {
            Extra extra = new Extra(rs.getInt("plant_ID"), rs.getInt("extraID"), rs.getString("nectarwaarde"), rs.getString("pollenwaarde"), rs.getString("bijvriendelijk"), rs.getString("eetbaarKruidgebruik"), rs.getString("geurend"), rs.getString("vorstgevoelig"));
            lijstExtra.add(extra);
        }
        return lijstExtra;
    }

    public List<Extra> GetExtraByVorstgevoelig(String vorstgevoelig) throws SQLException
    {
        STMTGETEXTRABYVORSTGEVOELIG = dbConnection.prepareStatement(GETEXTRABYVORSTGEVOELIG);
        STMTGETEXTRABYVORSTGEVOELIG.setString(1, vorstgevoelig);

        ResultSet rs = STMTGETEXTRABYVORSTGEVOELIG.executeQuery();

        while (rs.next())
        {
            Extra extra = new Extra(rs.getInt("plant_ID"), rs.getInt("extraID"), rs.getString("nectarwaarde"), rs.getString("pollenwaarde"), rs.getString("bijvriendelijk"), rs.getString("eetbaarKruidgebruik"), rs.getString("geurend"), rs.getString("vorstgevoelig"));
            lijstExtra.add(extra);
        }
        return lijstExtra;
    }
}
