//Auteur: Ayoub Ibourt
package Model;

public class Abiotische_Factoren {
    //variabelen
    private int plant_id;
    private int abiotische_id;
    private String bezonning;
    private String grondsoort;
    private String vochtbehoefte;
    private String voedingsbehoefte;
    private String reactie_antagonistische_omg;
    //variabelen abiotische factoren multi
    private String eigenschap;
    private String waarde;

    //constructor

    public Abiotische_Factoren(int abiotische_id, String bezonning, String grondsoort, String vochtbehoefte, String voedingsbehoefte, String reactie_antagonistische_omg, String eigenschap, String waarde) {
        this.abiotische_id = abiotische_id;
        this.bezonning = bezonning;
        this.grondsoort = grondsoort;
        this.vochtbehoefte = vochtbehoefte;
        this.voedingsbehoefte = voedingsbehoefte;
        this.reactie_antagonistische_omg = reactie_antagonistische_omg;
        this.eigenschap = eigenschap;
        this.waarde = waarde;
    }

    //getters & setters

    public int getAbiotische_id() {
        return abiotische_id;
    }

    public String getBezonning() {
        return bezonning;
    }

    public String getGrondsoort() {
        return grondsoort;
    }

    public String getVochtbehoefte() {
        return vochtbehoefte;
    }

    public String getVoedingsbehoefte() {
        return voedingsbehoefte;
    }

    public String getReactie_antagonistische_omg() {
        return reactie_antagonistische_omg;
    }

    //getters & setters abiotische factoren multi

    public String getEigenschap() {
        return eigenschap;
    }

    public String getWaarde() {
        return waarde;
    }
}
