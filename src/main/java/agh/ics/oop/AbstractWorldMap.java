package agh.ics.oop;

import java.util.ArrayList;
import java.util.*;

public abstract class AbstractWorldMap implements IWorldMap,IPositionChangeObserver {
    protected  Map<Vector2d, Animal> Animals = new HashMap<>();
    public abstract Vector2d upperRightCorner();
    public abstract Vector2d lowerLeftCorner();
    public Animal getAnimalAt(Vector2d position) {
        return Animals.get(position);
    }
    @Override
    public boolean place(Animal a) {
        if (canMoveTo(a.getPosition())){
            Animals.put(a.getPosition(),a);
            a.addObserver(this);
            return true;
        }
        return false;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        if (objectAt(position) == null) {
            return false;
        }
        return true;
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        Animal a = Animals.get(oldPosition);
        Animals.remove(oldPosition);
        Animals.put(newPosition,a);
    }

    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(lowerLeftCorner(), upperRightCorner());
    }
}
