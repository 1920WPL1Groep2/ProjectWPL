//Auteur: Ayoub Ibourt
package Model;

import java.awt.*;

public class Foto extends PlantID {
    //variabelen
    private int plant_id;
    private int foto_id;
    private String eigenschap;
    private String url;
    private Image foto;

    //Constructor

    public Foto(int plant_id, int plant_id1, int foto_id, String eigenschap, String url, Image foto) {
        super(plant_id);
        this.foto_id = foto_id;
        this.eigenschap = eigenschap;
        this.url = url;
        this.foto = foto;
    }

    //getters & setters
    public int getFoto_id() {
        return foto_id;
    }

    public String getEigenschap() {
        return eigenschap;
    }

    public String getUrl() {
        return url;
    }

    public Image getFoto() {
        return foto;
    }
}
