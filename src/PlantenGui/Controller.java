package PlantenGui;

import Dao.DaoPlant;
import Dao.Database;

import Model.Plant;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.SQLException;

public class Controller {
    public Button btnVooruit;
    public Button btnAchteruit;
    public TextField txtInvoerPlant;
    public TextArea txtUitvoerPlant;
    private Connection dbConnection;
    DaoPlant daoplant;
    public  void initialize() throws SQLException {

        // Connection con = Database.getInstance().getConnection();
        dbConnection = Database.getInstance().getConnection();
        System.out.println(dbConnection);
     daoplant= new DaoPlant(dbConnection);
        System.out.println(daoplant.getallplant());
    }
    public void clicked_Vooruit(MouseEvent mouseEvent) throws SQLException {


    }

    public void clicked_Achteruit(MouseEvent mouseEvent) {
    }
}
