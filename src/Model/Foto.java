//Auteur: Ayoub Ibourt
package Model;

import java.awt.*;

public class Foto extends PlantID {
    private int plant_id;
    private int foto_id;
    private String eigenschap;
    private String url;
    private Image foto;

    //Constructor

    public Foto(int plant_id, int plant_id1, int foto_id, String eigenschap, String url, Image foto) {
        super(plant_id);
        this.plant_id = plant_id1;
        this.foto_id = foto_id;
        this.eigenschap = eigenschap;
        this.url = url;
        this.foto = foto;
    }

    public int getPlant_id() {
        return plant_id;
    }

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
