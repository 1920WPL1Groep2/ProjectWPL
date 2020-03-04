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
import java.util.List;

public class Controller {
    public Button btnVooruit;
    public Button btnAchteruit;
    public TextField txtInvoerPlant;
    public TextArea txtUitvoerPlant;
    public Button btnZoeken;
    private Connection dbConnection;
    public DaoPlant daoplant;
    

    public void initialize() throws SQLException {

        // Connection con = Database.getInstance().getConnection();
        dbConnection = Database.getInstance().getConnection();
        System.out.println(dbConnection);
        daoplant = new DaoPlant(dbConnection);


    }

    public void clicked_Zoeken(MouseEvent mouseEvent) throws SQLException {
        List<Plant> plantje = daoplant.getallplant();

    }
}
