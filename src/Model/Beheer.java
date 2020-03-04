// Gemaakt door: Dario Kaczmarowski
package Model;

public class Beheer extends Plant
{
    //Variabelen
    private int plantID;
    private String beheerdraad;
    private String opmerking;
    private String maand;
    private int frequentieJaar;

    //Aanmaken constructor
    public Beheer(int beheerID, int plantID, String beheerdraad, String opmerking, String maand, int frequentieJaar)
    {
        super(plantID);
        this.plantID = plantID;
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
