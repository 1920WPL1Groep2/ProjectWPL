//Auteur: Dario Kaczmarowski
package Model;

public class Beheer extends PlantID {
    //Variabelen
    private int beheerID;
    private String beheerdaad;
    private String opmerking;
    private String maand;
    private int frequentieJaar;

    //Aanmaken constructor
    public Beheer(int plantID, int beheerID, String beheerdaad, String opmerking, String maand, int frequentieJaar) {
        super(plantID);
        this.beheerID = beheerID;
        this.beheerdaad = beheerdaad;
        this.opmerking = opmerking;
        this.maand = maand;
        this.frequentieJaar = frequentieJaar;
    }

    //Functies
    //Getters
    public int GetBeheerID() {
        return beheerID;
    }

    public String GetBeheerdaad() {
        return beheerdaad;
    }

    public String GetOpmerking() {
        return opmerking;
    }

    public String GetMaand() {
        return maand;
    }

    public int GetFrequentieJaar() {
        return frequentieJaar;
    }

}
