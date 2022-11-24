package agh.ics.oop;
import java.util.TreeSet;


public class MapBoundary implements IPositionChangeObserver{
    private final TreeSet<Vector2d> x_positions = new TreeSet<>((position1, position2) -> {
        if(position1.x>position2.x){return 1;}
        else if(position1.x < position2.x) {return -1;}
        return position1.y-position2.y;
    });
    private final TreeSet<Vector2d> y_positions = new TreeSet<>((position1, position2) -> {
        if(position1.y>position2.y){return 1;}
        else if(position1.y < position2.y) {return -1;}
        return position1.x-position2.x;
    });
    public void addPosition(Vector2d position) {
        x_positions.add(position);
        y_positions.add(position);
    }

    public void removePosition(Vector2d position) {
        x_positions.remove(position);
        y_positions.remove(position);
    }
    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        addPosition(newPosition);
        removePosition(oldPosition);
    }
    public Vector2d getUpperRight(){
        return new Vector2d(x_positions.last().x,y_positions.last().y);
    }
    public Vector2d getLowerLeft(){
        return new Vector2d(x_positions.first().x,y_positions.first().y);
    }
}
