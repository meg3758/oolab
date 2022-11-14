package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractWorldMap implements IWorldMap {
    protected  List<Animal> Animals = new ArrayList<Animal>();
    protected List<Grass> grassPoints = new ArrayList<Grass>();
    public abstract Vector2d upperRightCorner();
    public abstract Vector2d lowerLeftCorner();
    @Override
    public boolean canMoveTo(Vector2d position) {
        boolean answer = position.follows(lowerLeftCorner()) && position.precedes(upperRightCorner()) && !isOccupied(position);
        if (answer == true && objectAt(position) instanceof Grass){
            grassPoints.remove(objectAt(position));}
        return answer;
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
        for (Animal animal : Animals) {
            if (animal.getPosition().equals(position)) {
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
        for(Grass g : grassPoints){
            if (g.getPosition().equals(position)){
                return g;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(lowerLeftCorner(), upperRightCorner());
    }
}
