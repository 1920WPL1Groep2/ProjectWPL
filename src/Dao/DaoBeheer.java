//Auteur: Ayoub Ibourt
package Dao;

import Model.Beheer;

import java.lang.ref.PhantomReference;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DaoBeheer {
   private final Connection dbConnection;
   List<Beheer> lijstbeheer = new ArrayList<Beheer>();
   private static final String GETALLBEHEER=
           "SELECT * FROM beheer";
   private static final String GETBEHEERBYBEHEERDAAD=
           "SELECT * FROM beheer WHERE beheerdaad = ?";
   private static final String GETBEHEERBYOPMERKING=
           "SELECT *FROM beheer WHERE opmerking = ?";
   private static final String GETBEHEERBYFREQUENTIEJAAR=
           "SELECT * FROM beheer WHERE frequentie_jaar =?";

   private PreparedStatement STMTGETBEHEERBYBEHEERDAAD;
   private PreparedStatement STMTGETBEHEERBYOPMERKING;
   private PreparedStatement STMTGETBEHEERBYFREQUENTIEJAAR;

   public DaoBeheer(Connection dbConnection) throws SQLException{
       this.dbConnection=dbConnection;
   }

    public List<Beheer> getallbeheer() throws SQLException {
        Statement stmt = dbConnection.createStatement();
        ResultSet rs = stmt.executeQuery(GETALLBEHEER);
        while (rs.next()){
            Beheer beheer = new Beheer(rs.getInt("plant_id"),rs.getInt("beheer_id"),rs.getString("beheerdaad"),rs.getString("opmerking"),rs.getString("maand"),rs.getInt("frequentie_jaar"));
            lijstbeheer.add(beheer);
        }
        return lijstbeheer;
    }
}
