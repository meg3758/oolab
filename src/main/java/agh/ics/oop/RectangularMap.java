package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap implements IWorldMap{
    private final int width;
    private final int height;
    private final Vector2d lowerLeftCorner;
    private final Vector2d upperRightCorner;
    private final ArrayList<Animal> Animals;
    private final MapVisualizer mapVisualizer;

    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
        this.lowerLeftCorner=new Vector2d(0,0);
        this.upperRightCorner=new Vector2d(width-1,height-1);
        this.Animals=new ArrayList<>();
        this.mapVisualizer= new MapVisualizer(this);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(lowerLeftCorner) && position.precedes(upperRightCorner) && !isOccupied(position);
    }

    @Override
    public boolean place(Animal animal) {
        if (!isOccupied(animal.getPosition())){
            Animals.add(animal);
            return true;
        }
        return false;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal a : Animals){
            if (a.getPosition().equals(position)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal a : Animals){
            if (a.getPosition().equals(position)){
                return a;
            }
        }
        return false;
    }
    public String toString(){
        return mapVisualizer.draw(lowerLeftCorner,upperRightCorner);
    }

}
