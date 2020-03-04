//Auteur: Ayoub Ibourt
package Model;

import Dao.DaoPlant;

public class Plant extends PlantID {
    //variabelen
    private String type;
    private String familie;
    private String geslacht;
    private String soort;
    private String variatie;
    private String plantdichtheid_min;
    private String plantdichtheid_max;


    //constructor
    public Plant(int plant_id, String type, String familie, String geslacht, String soort, String variatie, String plantdichtheid_min, String plantdichtheid_max) {
        super(plant_id);
        this.type = type;
        this.familie = familie;
        this.geslacht = geslacht;
        this.soort = soort;
        this.variatie = variatie;
        this.plantdichtheid_min = plantdichtheid_min;
        this.plantdichtheid_max = plantdichtheid_max;
    }

    //getters & setters
    public String getType() {
        return type;
    }

    public String getFamilie() {
        return familie;
    }

    public String getGeslacht() {
        return geslacht;
    }

    public String getSoort() {
        return soort;
    }

    public String getVariatie() {
        return variatie;
    }

    public String getPlantdichtheid_min() {
        return plantdichtheid_min;
    }

    public String getPlantdichtheid_max() {
        return plantdichtheid_max;
    }
}
