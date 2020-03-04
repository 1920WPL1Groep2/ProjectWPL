package Model;

public abstract class PlantID
{
    int id;


    public PlantID(int plant_id)
    {
        this.id = plant_id;
    }

    public int GetId(){return id;}
}
