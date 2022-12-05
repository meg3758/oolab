package agh.ics.oop;

public class Grass implements IMapElement{
    private Vector2d position;
    public Grass(Vector2d vector ){
        this.position=vector;
    }
    @Override
    public Vector2d getPosition(){
        return this.position;
    }
    @Override
    public String getImagePath(){
        return "src/main/resources/grass.png";
    }
    @Override
    public String toString(){
        return "*";
    }
}
