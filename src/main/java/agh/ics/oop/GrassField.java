package agh.ics.oop;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;

public class GrassField extends AbstractWorldMap{
    private final int clumpsOfGrass;
    private final Vector2d lowerLeftCorner;
    private Vector2d upperRightCorner;
    public GrassField(int number){
        this.clumpsOfGrass=number;
        this.lowerLeftCorner = new Vector2d(0,0);
        this.upperRightCorner = new Vector2d(Integer.MAX_VALUE,Integer.MAX_VALUE);
        Random random = new Random();
        int grassCount=0;
        while (grassCount<this.clumpsOfGrass){
            Vector2d position = new Vector2d(random.nextInt((int) Math.sqrt(number*10)),random.nextInt((int) Math.sqrt(number*10)));
            if (!isOccupied(position)){
                Grass g = new Grass(position);
                grassPoints.add(g);
                grassCount++;
            }
        }

    }

    @Override
    public Vector2d upperRightCorner() {
        return upperRightCorner;
    }

    @Override
    public Vector2d lowerLeftCorner() {
        return lowerLeftCorner;
    }

    public Grass getGrassAt(int index) {
        return grassPoints.get(index);
    }
    public Vector2d getUpperRightCorner(){
        int x_corner = 0;
        int y_corner = 0;
        for(Animal a : Animals){
            x_corner = Math.max(x_corner,a.getPosition().x);
            y_corner = Math.max(y_corner,a.getPosition().y);
        }
        for(Grass g : grassPoints) {
            x_corner = Math.max(x_corner,g.getPosition().x);
            y_corner = Math.max(y_corner,g.getPosition().y);
        }
        this.upperRightCorner = new Vector2d(x_corner,y_corner);
        return upperRightCorner;
    }
    @Override
    public boolean isOccupied(Vector2d position) {
        for (Animal animal : Animals) {
            if (animal.getPosition().equals(position)) {
                return true;
            }
        }
        for (Grass grass : grassPoints) {
            if (grass.getPosition().equals(position)) {
                return true;
            }
        }
        return false;
    }
    @Override
    public String toString() {
        MapVisualizer map = new MapVisualizer(this);
        return map.draw(lowerLeftCorner(), getUpperRightCorner());
    }

}
