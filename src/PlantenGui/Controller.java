package PlantenGui;

import Dao.DaoFenotype;
import Dao.DaoPlant;
import Dao.Database;
import Model.Plant;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import javax.swing.*;
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
    public ComboBox cmbBladkleurKleur_zoekscherm;
    public ComboBox cmbBladkleurMaand1_zoekscherm;
    public ComboBox cmbBladkleurMaand2_zoekscherm;
    public ComboBox cmbBloeikleurKleur_zoekscherm;
    public ComboBox cmbBloeikleurMaand2_zoekscherm;
    public TextField txtBladhoogteMin_zoekscherm;
    public TextField txtBladhoogteMax_zoekscherm;
    public TextField txtBloeihoogteMin_zoekscherm;
    public TextField txtBloeihoogteMax_zoekscherm;
    public ComboBox cmbBloeikleurMaand1_zoekscherm;
    public ComboBox cmbMaxBladgrootte_zoekscherm;
    public ComboBox cmbBladvorm_zoekscherm;
    public ComboBox cmbSpruitfenologie_zoekscherm;
    private Connection dbConnection;
    public DaoPlant daoplant;
    public Daozoekscherm daozoekscherm;
    public DaoFenotype daoFenotype;
    //auteur Leandro & Hermes
    //een lijst aanmaken om de comboboxen in basiszoekscherm te vullen
    public List<Plant> plantje = new ArrayList<>();
    List<String> FamilieIni = new ArrayList<>();
    List<String> TypeIni = new ArrayList<>();
    List<String> Geslachtini = new ArrayList<>();
    List<String> Soortini = new ArrayList<>();
    List<String> Variantini = new ArrayList<>();

    //en liist aanmaken om de comboboxen in fenotype te vullen


    public void initialize() throws SQLException {
        //auteur Leandro
        Zoekschermini();

    }

    public void clicked_Zoeken(MouseEvent mouseEvent) throws SQLException {
        Plantbynaam(txtInvoerPlant_zoekscherm.getText());
        Bladhoogte_Bloeihoogte();

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
    //alles voor Anchorpane met basis zoekfuncties

    public void Zoekschermini() throws SQLException {
        //auteur Leandro & Hermes
        //Het zoekscherm connecteren met de database (alle comboboxen opvullen...)
        familieini();
        typeini();
        geslachtini();
        soortini();
        variantini();
        Fenotypeini();
    }


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

    public void typeini() throws SQLException {
        //combobox type opvullen

    public void familieupdate(String type) throws SQLException {
        //auteur: Leandro & Dario
        //Hier wordt combobox van de Familie opgevuld
        //Ik maak een lege waarde indien niets geselecteerd is
        cmbFamilie_zoekscherm.getItems().clear();
        cmbFamilie_zoekscherm.getItems().add(null);
        cmbFamilie_zoekscherm.getSelectionModel().select(null);
        //Hier wordt de lijst opgehaald via de functie Familie

        //De lijst met types ophalen uit dao
        TypeIni = daozoekscherm.Type();
        //de waarden in een loop steken zodat combobox automatisch opgevuld wordt.
        for (int i = 0; i < TypeIni.size(); i++) {
            cmbType_zoekscherm.getItems().add(TypeIni.get(i));
            //uitprinten in console ter controle (optioneel)
            System.out.println(TypeIni.get(i));
        }
    }

    public void geslachtini() throws SQLException {
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

    //Alles voor Titledpane Fenotype

    //voor elke combobox een list maken waar de gegevens inkomen
    List<String> Kleurini = new ArrayList<>();
    List<String> Maandini = new ArrayList<>();
    List<String> MaxBladgrootteini = new ArrayList<>();
    List<String> Bladvormini = new ArrayList<>();
    List<String> Spruitfenologieini = new ArrayList<>();

    public void Fenotypeini() throws SQLException {
        //zoekscherm fenotype connecteren met database
        dbConnection = Database.getInstance().getConnection();
        daoFenotype = new DaoFenotype(dbConnection);
        Bladhoogte_Bloeihoogte();
        kleurini();
        maandini();
        maxbladgrootteini();
        bladvormini();
        spruitfenologieini();

    }

    public void Bladhoogte_Bloeihoogte() {
        //functie voor het ophalen van de ingevulde gegevens in bladhoogte en bloeihoogte

        //eerst de variabelen defineren naar null omdat het niet verplicht is ze (allemaal) in te vullen voor een zoekopdracht
        Double BladhoohgteMin = null;
        Double BladhoogteMax = null;
        Double BloeihoogteMin = null;
        Double BloeihoogteMax = null;

        //de eerste if controleert of een waarde is ingevuld, zoniet blijft de waarde op null
        if (!txtBladhoogteMin_zoekscherm.getText().isEmpty()) {
            //de tweede if controleert of de ingevulde waarde van het type double is (hierbij wordt functie isDouble() gebruikt
            if ((isDouble(txtBladhoogteMin_zoekscherm.getText()))) {
                //de waarde van de variabelen wordt verandert naar de ingevulde waarde
                BladhoohgteMin = Double.parseDouble(txtBladhoogteMin_zoekscherm.getText());
                //uitprinten in console ter controle
                System.out.println("Min bladhoogte is: " + BladhoohgteMin);
                //als de waarde geen double is wordt er een melding getoond die meegeeft dat de ingevulde waarde een cijfer (double) moet zijn
            } else {
                JOptionPane.showMessageDialog(null, "Je moet een cijfer invullen in Min Bladhoogte");
            }
        }

        if (!txtBladhoogteMax_zoekscherm.getText().isEmpty()) {
            if (isDouble(txtBladhoogteMax_zoekscherm.getText())) {
                BladhoogteMax = Double.parseDouble(txtBladhoogteMax_zoekscherm.getText());
                System.out.println("Max Bladhoogte is: " + BladhoogteMax);
            } else {
                JOptionPane.showMessageDialog(null, "Je moet een cijfer invullen in Max Bladhoogte");
            }

        }
        if (!txtBloeihoogteMin_zoekscherm.getText().isEmpty()) {
            if (isDouble(txtBloeihoogteMin_zoekscherm.getText())) {
                BloeihoogteMin = Double.parseDouble(txtBloeihoogteMin_zoekscherm.getText());
                System.out.println("Min Bloeihoogte is: " + BloeihoogteMin);
            } else {
                JOptionPane.showMessageDialog(null, "Je moet een cijfer invullen in Min Bloeihoogte");
            }

        }
        if (!txtBloeihoogteMax_zoekscherm.getText().isEmpty()) {
            if (isDouble(txtBloeihoogteMax_zoekscherm.getText())) {
                BloeihoogteMax = Double.parseDouble(txtBloeihoogteMax_zoekscherm.getText());
                System.out.println("Max Bloeihoogte is: " + BloeihoogteMax);
            } else {
                JOptionPane.showMessageDialog(null, "Je moet een cijfer invullen in Max Bloeihoogte");
            }
        }
    }

    private boolean isDouble(String sGetal) {
        //sGetal omzetten naar een double, als dit lukt => true dus sGetal is double
        //indien dit niet lukt => false dus sGetal is geen double
        try {
            Double.parseDouble(sGetal);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    public void kleurini() throws SQLException {
        //combobox van kleuren opvullen
        //alle comboboxen van kleur in 1 functie vullen om herhaling te voorkomen
        cmbBladkleurKleur_zoekscherm.getItems().add("");
        cmbBladkleurKleur_zoekscherm.getSelectionModel().select("");

        cmbBloeikleurKleur_zoekscherm.getItems().add("");
        cmbBloeikleurKleur_zoekscherm.getSelectionModel().select("");

        //lijst ophalen uit daoFenotype
        Kleurini = daoFenotype.Kleuren();
        //een loop aanmaken om de comboboxen automatisch te laten vullen
        for (int i = 0; i < Kleurini.size(); i++) {
            cmbBladkleurKleur_zoekscherm.getItems().add(Kleurini.get(i));
            cmbBloeikleurKleur_zoekscherm.getItems().add(Kleurini.get(i));
            //uitprinten in console ter controle (optioneel)
            System.out.println(Kleurini.get(i));
        }
    }
    public void maandini() throws SQLException{
        //functie die de comboboxen van maand opvult

        //in elke combobox een lege waarde stoppen indien geen waarde nodig is
        cmbBladkleurMaand1_zoekscherm.getItems().add("");
        cmbBladkleurMaand1_zoekscherm.getSelectionModel().select("");

        cmbBladkleurMaand2_zoekscherm.getItems().add("");
        cmbBladkleurMaand2_zoekscherm.getSelectionModel().select("");

        cmbBloeikleurMaand1_zoekscherm.getItems().add("");
        cmbBloeikleurMaand1_zoekscherm.getSelectionModel().select("");

        cmbBloeikleurMaand2_zoekscherm.getItems().add("");
        cmbBloeikleurMaand2_zoekscherm.getSelectionModel().select("");

        //De lijst met maanden opvullen, dit wordt hard gecodeerd omdat de maandan normaalgezien niet veranderen
        Maandini.add("Januari"); Maandini.add("Februari");Maandini.add("Maart");Maandini.add("April"); Maandini.add("Mei");Maandini.add("Juni");
        Maandini.add("Juli"); Maandini.add("Augustus");Maandini.add("September");Maandini.add("Oktober"); Maandini.add("November");Maandini.add("December");

        //Een loop maken om de comboboxen automatisch te laten vullen
        for (int i = 0; i < Maandini.size(); i++){
            cmbBladkleurMaand1_zoekscherm.getItems().add(Maandini.get(i));
            cmbBladkleurMaand2_zoekscherm.getItems().add(Maandini.get(i));
            cmbBloeikleurMaand1_zoekscherm.getItems().add(Maandini.get(i));
            cmbBloeikleurMaand2_zoekscherm.getItems().add(Maandini.get(i));
        }
    }
    public void maxbladgrootteini() throws SQLException{
        //combobox van max bladgrootte opvullen

        //lege waarden toevoegen aan combobox
        cmbMaxBladgrootte_zoekscherm.getItems().add("");
        cmbMaxBladgrootte_zoekscherm.getSelectionModel().select("");

        //de lijst opvullen met de waarden via dao
        MaxBladgrootteini = daoFenotype.Grootte();
        //combobox via een loop laten opvullen
        for (int i = 0; i < MaxBladgrootteini.size(); i++){
            cmbMaxBladgrootte_zoekscherm.getItems().add(MaxBladgrootteini.get(i));
        }
    }
    public void bladvormini() throws SQLException{
        //functie die combobox voor bladvorm opvult

        //lege waarde in combobox steken
        cmbBladvorm_zoekscherm.getItems().add("");
        cmbBladvorm_zoekscherm.getSelectionModel().select("");

        //lijst met bladvorm vullen via dao
        Bladvormini = daoFenotype.bladvorm();

        //via loop combobox vullen met waarden
        for (int i = 0; i < Bladvormini.size(); i++){
            cmbBladvorm_zoekscherm.getItems().add(Bladvormini.get(i));
        }
    }
    public void spruitfenologieini() throws SQLException{
        //functie om combobox spruitfenologie op te vullen

        //lege waarde toevoegen aan combobox
        cmbSpruitfenologie_zoekscherm.getItems().add("");
        cmbSpruitfenologie_zoekscherm.getSelectionModel().select("");

        //lijst spruitfenologie opvullen met waarden via dao
        Spruitfenologieini = daoFenotype.Spruitfeno();

        //via loop de combobox opvullen
        for (int i = 0; i < Spruitfenologieini.size(); i++){
            cmbSpruitfenologie_zoekscherm.getItems().add(Spruitfenologieini.get(i));
        }
    }

}


