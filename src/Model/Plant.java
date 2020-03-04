//Auteur: Ayoub Ibourt
package Model;

import Dao.DaoPlant;

public class Plant {
    //variabelen
    private int plant_id;
    private String type;
    private String familie;
    private String geslacht;
    private String soort;
    private String variatie;
    private String plantdichtheid_min;
    private String plantdichtheid_max;
    private DaoPlant Plant;

    //constructor
    public Plant(DaoPlant plant) {
        Plant = plant;
    }

    //getters & setters
    public int getPlant_id() {
        return plant_id;
    }

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
