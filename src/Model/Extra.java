package Model;

public class Extra extends PlantID
{
    //Variabelen
    private int extraID;
    private String nectarwaarde;
    private String pollenwaarde;
    private String bijvriendelijk;
    private String eetbaarKruidgebruik;
    private String geurend;
    private String vorstgevoelig;

    //Aanmaken constructor
    public Extra(int plantID, int extraID, String nectarwaarde, String pollenwaarde, String bijvriendelijk, String eetbaarKruidgebruik, String geurend, String vorstgevoelig)
    {
        super(plantID);
        this.nectarwaarde =  nectarwaarde;
        this.pollenwaarde = pollenwaarde;
        this.bijvriendelijk = bijvriendelijk;
        this.eetbaarKruidgebruik = eetbaarKruidgebruik;
        this.geurend = geurend;
        this.vorstgevoelig = vorstgevoelig;
    }

    //Functies
    //Getters
    public int GetExtraID(){return extraID;}
    public String GetNectarwaarde(){return nectarwaarde;}
    public String GetPollenwaarde(){return pollenwaarde;}
    public String GetBijvriendelijk(){return bijvriendelijk;}
    public String GetEetbaarKruidgebruik(){return eetbaarKruidgebruik;}
    public String GetGeurend(){return geurend;}
    public String GetVorstgevoelig(){return vorstgevoelig;}
}
