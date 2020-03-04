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
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public TextField txtInvoerPlant;
    public TextArea txtUitvoerPlant;
    public Button btnZoeken;
    private Connection dbConnection;
    public DaoPlant daoplant;

    public List<Plant> plantje = new ArrayList<>();


    public void initialize() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
        daoplant = new DaoPlant(dbConnection);

        plantje = daoplant.getallplant();




    }

    public void clicked_Zoeken(MouseEvent mouseEvent) throws SQLException {
        Plantbynaam(txtInvoerPlant.getText());
    }


    public void Plantbynaam(String Naam) throws SQLException {
        plantje.clear();
        plantje = daoplant.getplantbynaam(Naam);
        System.out.println(plantje.size());
        for (int i = 0; i < plantje.size(); i++) {
            System.out.println(plantje.get(i).getFgsv());

        }
    }

}
