//Auteur: Dario Kaczmarowski
package Model;

public class Beheer extends PlantID
{
    //Variabelen
    private int plantID;
    private String beheerdraad;
    private String opmerking;
    private String maand;
    private int frequentieJaar;

    //Aanmaken constructor
    public Beheer(int plantID, int beheerID, String beheerdraad, String opmerking, String maand, int frequentieJaar)
    {
        super(plantID);
        this.beheerdraad = beheerdraad;
        this.opmerking = opmerking;
        this.maand = maand;
        this.frequentieJaar = frequentieJaar;
    }

    //Functies

    //Getters
    public String GetBeheerdraad() {return beheerdraad;}
    public String GetOpmerking() {return opmerking;}
    public String GetMaand() {return maand;}
    public int GetFrequentieJaar() {return frequentieJaar;}

}
