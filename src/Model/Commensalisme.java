//Auteur: Ayoub Ibourt
package Model;

public class Commensalisme extends PlantID{
    //variabelen
    private int plant_id;
    private int commensialisme_id;
    private String strategie;
    private String ontwikkelingssnelheid;
    // variabelen commensialisme multi
    private String eigenschap;
    private String waarde;

    //constructor
    public Commensalisme(int PlantID,int commensialisme_id, String strategie, String ontwikkelingssnelheid, String eigenschap, String waarde) {
        super(PlantID);
        this.commensialisme_id = commensialisme_id;
        this.strategie = strategie;
        this.ontwikkelingssnelheid = ontwikkelingssnelheid;
        this.eigenschap = eigenschap;
        this.waarde = waarde;
    }

    // getters & setters

    public int getCommensialisme_id() {
        return commensialisme_id;
    }

    public String getStrategie() {
        return strategie;
    }

    public String getOntwikkelingssnelheid() {
        return ontwikkelingssnelheid;
    }

    //getters & setters commensialisme multi

    public String getEigenschap() {
        return eigenschap;
    }

    public String getWaarde() {
        return waarde;
    }
}
