package agh.ics.oop;
import java.util.*;

public class GrassField extends AbstractWorldMap{
    private final int clumpsOfGrass;
    protected Map<Vector2d, Grass> grassPoints = new HashMap<>();
    private final Vector2d lowerLeftCorner;
    private Vector2d upperRightCorner;

    public GrassField(int number){
        this.clumpsOfGrass=number;
        this.lowerLeftCorner = new Vector2d(0,0);
        this.upperRightCorner = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        this.mapBoundary = new MapBoundary();
        Random random = new Random();
        while (grassPoints.size()<this.clumpsOfGrass){
            Vector2d position = new Vector2d(random.nextInt((int) Math.sqrt(number*10)),random.nextInt((int) Math.sqrt(number*10)));
            if (getGrassAt(position)==null){
                Grass g = new Grass(position);
                this.grassPoints.put(position,g);
                mapBoundary.addPosition(position);
            }
        }

    }
    public Grass getGrassAt(Vector2d position) {
        return grassPoints.get(position);
    }

    @Override
    public Vector2d upperRightCorner() {
        return mapBoundary.getUpperRight();
    }

    @Override
    public Vector2d lowerLeftCorner() {
        return mapBoundary.getLowerLeft();
    }
    @Override
    public boolean canMoveTo(Vector2d position) {
        return !isOccupied(position) || objectAt(position) instanceof Grass;
    }
    @Override
    public Object objectAt(Vector2d position) {
        Animal a = getAnimalAt(position);
        if (a != null){
            return a;
        }
        Grass g = getGrassAt(position);
        if (g != null){
            return g;
        }
        return null;
    }
    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(lowerLeftCorner(), upperRightCorner());
    }

}
