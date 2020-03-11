package PlantenGui;

import Dao.DaoPlant;
import Dao.Database;
import Model.Plant;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    public ComboBox cmbFamilie_zoekscherm;
    public TextField txtInvoerPlant_zoekscherm;
    public ComboBox cmbType_zoekscherm;
    public ComboBox cmbGeslacht_zoekscherm;
    public ComboBox cmbSoort_zoekscherm;
    public Button btnZoeken;
    public ComboBox cmbVariant_zoekscherm;
    private Connection dbConnection;
    public DaoPlant daoplant;

    //auteur Leandro & Hermes
    //een lijst aanmaken om de comboboxen te vullen
    public List<Plant> plantje = new ArrayList<>();
    List<String> FamilieIni = new ArrayList<>();
    List<String> TypeIni = new ArrayList<>();
    List<String> Geslachtini = new ArrayList<>();
    List<String> Soortini = new ArrayList<>();
    List<String> Variantini = new ArrayList<>();

    public void initialize() throws SQLException {
        //auteur Leandro
        dbConnection = Database.getInstance().getConnection();
        daoplant = new DaoPlant(dbConnection);
        plantje = daoplant.getallplant();
        Zoekschermini();
    }

    public void clicked_Zoeken(MouseEvent mouseEvent) throws SQLException {
        Plantbynaam(txtInvoerPlant_zoekscherm.getText());

    }

    public void onaction(ActionEvent actionEvent) throws SQLException {
        //auteur Dario & Leandro
        if (cmbType_zoekscherm.getValue() == "") {
            familieini();
        } else {
            familieupdate((String) cmbType_zoekscherm.getValue());

        }
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
        //auteur Leandro & Hermes
        //Het zoekscherm connecteren met de database (alle comboboxen opvullen...)
        familieini();
        typeini();
        geslachtini();
        soortini();
        variantini();


    }

    //alles voor Anchorpane met basis zoekfuncties

    public void typeini() throws SQLException {
        //auteur: Hermes
        //combobox type opvullen

        //eerst lege waarde aanmaken indien er geen waarde geselecteerd moet worden
        cmbType_zoekscherm.getItems().add("");
        cmbType_zoekscherm.getSelectionModel().select("");

        //De lijst met types ophalen uit dao
        TypeIni = daoplant.Type();
        //de waarden in een loop steken zodat combobox automatisch opgevuld wordt.
        for (int i = 0; i < TypeIni.size(); i++) {
            cmbType_zoekscherm.getItems().add(TypeIni.get(i));
            //uitprinten in console ter controle (optioneel)
            System.out.println(TypeIni.get(i));
        }
    }
    public void familieini() throws SQLException {
        //auteur: Leandro
        //Hier wordt combobox van de Familie opgevuld
        //Ik maak een lege waarde indien niets geselecteerd is
        cmbFamilie_zoekscherm.getItems().add("");
        cmbFamilie_zoekscherm.getSelectionModel().select("");

        //Hier wordt de lijst opgehaald via de functie Familie
        FamilieIni = daoplant.Familie();
        //Hier steek ik in een loop zodat de lijst zich dynamisch opvult.
        for (int i = 0; i < FamilieIni.size(); i++) {
            cmbFamilie_zoekscherm.getItems().add(FamilieIni.get(i));
            System.out.println(FamilieIni.get(i));
        }
    }

    public void familieupdate(String type) throws SQLException {
        //auteur: Leandro & Dario
        //Hier wordt combobox van de Familie opgevuld
        //Ik maak een lege waarde indien niets geselecteerd is
        cmbFamilie_zoekscherm.getItems().clear();
        cmbFamilie_zoekscherm.getItems().add(null);
        cmbFamilie_zoekscherm.getSelectionModel().select(null);
        //Hier wordt de lijst opgehaald via de functie Familie

        FamilieIni.clear();
        FamilieIni = daoplant.Familiebytpye(type);
        //Hier steek ik in een loop zodat de lijst zich dynamisch opvult.
        for (int i = 0; i < FamilieIni.size(); i++) {
            cmbFamilie_zoekscherm.getItems().add(FamilieIni.get(i));
            System.out.println(FamilieIni.get(i));
        }
    }

    public void geslachtini() throws SQLException {
        //auteur: Hermes
        //combobox Geslacht opvullen

        //lege waarde aanmaken indien geen waarde geselecteerd moet worden
        cmbGeslacht_zoekscherm.getItems().add("");
        cmbGeslacht_zoekscherm.getSelectionModel().select("");

        //De lijst met Geslachten ophalen uit dao
        Geslachtini = daoplant.Geslacht();
        //de waarden in loop zetten zodat combobox automatisch opvult
        for (int i = 0; i < Geslachtini.size(); i++) {
            cmbGeslacht_zoekscherm.getItems().add(Geslachtini.get(i));
            //uitprinte in console ter controle (optioneel)
            System.out.println(Geslachtini.get(i));
        }
    }
    public void geslachtupdate(String familie) throws SQLException{
        //auteur: Leandro & Dario
        //Hier wordt combobox van de Familie opgevuld
        //Ik maak een lege waarde indien niets geselecteerd is
        cmbGeslacht_zoekscherm.getItems().clear();
        cmbGeslacht_zoekscherm.getItems().add(null);
        cmbGeslacht_zoekscherm.getSelectionModel().select(null);
        //Hier wordt de lijst opgehaald via de functie geslacht
        Geslachtini.clear();
        Geslachtini = daoplant.Geslachtbyfamilie(familie);
        //Hier steek ik in een loop zodat de lijst zich dynamisch opvult.
        for (int i = 0; i < Geslachtini.size(); i++) {
            cmbGeslacht_zoekscherm.getItems().add(Geslachtini.get(i));
            System.out.println(Geslachtini.get(i));
        }
    }
    public void Geslachtupdate(String familie) throws SQLException {
        //auteur: Leandro & Dario
        //Hier wordt combobox van de Familie opgevuld
        //Ik maak een lege waarde indien niets geselecteerd is
        cmbFamilie_zoekscherm.getItems().clear();
        cmbFamilie_zoekscherm.getItems().add(null);
        cmbFamilie_zoekscherm.getSelectionModel().select(null);
        //Hier wordt de lijst opgehaald via de functie Familie

        FamilieIni.clear();
        FamilieIni = daoplant.Familiebytpye(familie);
        //Hier steek ik in een loop zodat de lijst zich dynamisch opvult.
        for (int i = 0; i < FamilieIni.size(); i++) {
            cmbFamilie_zoekscherm.getItems().add(FamilieIni.get(i));
            System.out.println(FamilieIni.get(i));
        }
    }

    public void soortini() throws SQLException {
        //auteur: Hermes
        //combobox Soort vullen

        //Lege waarde aanmaken indien geen waarde nodig is
        cmbSoort_zoekscherm.getItems().add("");
        cmbSoort_zoekscherm.getSelectionModel().select("");

        //de lijst met soorten ophalen uit dao
        Soortini = daoplant.Soort();
        //de waarden in loop zetten zodat combobox zichzelf vult
        for (int i = 0; i < Soortini.size(); i++) {
            cmbSoort_zoekscherm.getItems().add(Soortini.get(i));
            //uitprinten in console ter controle (optioneel)
            System.out.println(Soortini.get(i));
        }
    }

    public void variantini() throws SQLException {
        //auteur: Hermes
        //combobox Variant vullen

        //lege waarde aanmaken indien geen waarde nodig is
        cmbVariant_zoekscherm.getItems().add("");
        cmbVariant_zoekscherm.getSelectionModel().select("");

        //De lijst met varianten ophalen uit dao
        Variantini = daoplant.Variant();
        //de waarden in loop zetten zodat combobox zichzelf vult
        for (int i = 0; i < Variantini.size(); i++) {
            cmbVariant_zoekscherm.getItems().add(Variantini.get(i));
            //uitprinten in console ter controle (optioneel)
            System.out.println(Variantini.get(i));
        }
    }


}




