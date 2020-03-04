//Auteur: Ayoub Ibourt
package Model;

public class fenotype extends PlantID {
    //variabelen
    private int plant_id;
    private int fenotype_id;
    private String bladvorm;
    private String levensvorm;
    private String habitus;
    private String bloeiwijze;
    private String bladgrootte;
    private String ratio_bloei_blad;
    private String spruitfenologie;

    // constructor
    public fenotype(int plant_id, int plant_id1, int fenotype_id, String bladvorm, String levensvorm, String habitus, String bloeiwijze, String bladgrootte, String ratio_bloei_blad, String spruitfenologie) {
        super(plant_id);
        this.fenotype_id = fenotype_id;
        this.bladvorm = bladvorm;
        this.levensvorm = levensvorm;
        this.habitus = habitus;
        this.bloeiwijze = bloeiwijze;
        this.bladgrootte = bladgrootte;
        this.ratio_bloei_blad = ratio_bloei_blad;
        this.spruitfenologie = spruitfenologie;
    }

    //getters & setters

    public int getFenotype_id() {
        return fenotype_id;
    }

    public String getBladvorm() {
        return bladvorm;
    }

    public String getLevensvorm() {
        return levensvorm;
    }

    public String getHabitus() {
        return habitus;
    }

    public String getBloeiwijze() {
        return bloeiwijze;
    }

    public String getBladgrootte() {
        return bladgrootte;
    }

    public String getRatio_bloei_blad() {
        return ratio_bloei_blad;
    }

    public String getSpruitfenologie() {
        return spruitfenologie;
    }


    //variabelen fenotype multi
    private String eigenschap;
    private String jan;
    private String feb;
    private String maa;
    private String apr;
    private String mei;
    private String jun;
    private String jul;
    private String aug;
    private String sep;
    private String okt;
    private String nov;
    private String dec;

    // Constructor fenotype multi


    public fenotype(int plant_id, String eigenschap, String jan, String feb, String maa, String apr, String mei, String jun, String jul, String aug, String sep, String okt, String nov, String dec) {
        super(plant_id);
        this.eigenschap = eigenschap;
        this.jan = jan;
        this.feb = feb;
        this.maa = maa;
        this.apr = apr;
        this.mei = mei;
        this.jun = jun;
        this.jul = jul;
        this.aug = aug;
        this.sep = sep;
        this.okt = okt;
        this.nov = nov;
        this.dec = dec;
    }

    //getters & setters fenotype multi

    public String getEigenschap() {
        return eigenschap;
    }

    public String getJan() {
        return jan;
    }

    public String getFeb() {
        return feb;
    }

    public String getMaa() {
        return maa;
    }

    public String getApr() {
        return apr;
    }

    public String getMei() {
        return mei;
    }

    public String getJun() {
        return jun;
    }

    public String getJul() {
        return jul;
    }

    public String getAug() {
        return aug;
    }

    public String getSep() {
        return sep;
    }

    public String getOkt() {
        return okt;
    }

    public String getNov() {
        return nov;
    }

    public String getDec() {
        return dec;
    }
}
