package PlantenGui;

import Dao.DaoPlant;
import Dao.Daozoekscherm;
import Dao.Database;
import Model.Plant;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    public ComboBox cmboType;
    private Connection dbConnection;
    public DaoPlant daoplant;
    public Daozoekscherm daozoekscherm;
//auteur Leandro
    public List<Plant> plantje = new ArrayList<>();
    List<String> FamilieInitiali = new ArrayList<>();

    public void initialize() throws SQLException {
        //auteur Leandro
Zoekschermini();

    }

    public void clicked_Zoeken(MouseEvent mouseEvent) throws SQLException {
        Plantbynaam(txtInvoerPlant.getText());
    }

    //Auteur Leandro
    public void Plantbynaam(String Naam) throws SQLException {
        //Hier ledig ik de lijst deze functie is nog steeds in testfase, nog verder uitwerken
        plantje.clear();
        plantje = daoplant.getplantbynaam(Naam);
        System.out.println(plantje.size());
        for (int i = 0; i < plantje.size(); i++) {
            System.out.println(plantje.get(i).getFgsv());

        }
    }

    public void RefreshGui() {

    }

    public void Zoekschermini() throws SQLException {
        dbConnection = Database.getInstance().getConnection();
        daozoekscherm = new Daozoekscherm(dbConnection);
        daoplant = new DaoPlant(dbConnection);
        plantje = daoplant.getallplant();
        familieini();


    }

    public void familieini() throws SQLException {
        //auteur: Leandro
        //Hier wordt combobox van de Familie opgevuld
        //Ik maak een lege waarde indien niets geselecteerd is
        cmboType.getItems().add("");
        cmboType.getSelectionModel().select("");

        //Hier wordt de lijst opgehaald via de functie Familie
        FamilieInitiali = daozoekscherm.Familie();
        //Hier steek ik in een loop zodat de lijst zich dynamisch opvult.
        for (int i = 0; i < FamilieInitiali.size(); i++) {
            cmboType.getItems().add(FamilieInitiali.get(i));
            System.out.println(FamilieInitiali.get(i));
        }
    }
}
