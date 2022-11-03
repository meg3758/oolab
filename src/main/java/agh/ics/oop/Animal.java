package agh.ics.oop;

public class Animal {

    private MapDirection orientation;
    private Vector2d position;
    private IWorldMap map;

    public Animal(IWorldMap map, Vector2d initialPosition){
        this.map=map;
        this.position=initialPosition;
        this.orientation = MapDirection.NORTH;
    }
    public Animal(){
        this(new RectangularMap(5,5),new Vector2d(2,2));
    }

    public MapDirection getOrientation(){
        return this.orientation;
    }
    public Vector2d getPosition(){
        return this.position;
    }
    public String toString(){
        return switch (orientation){
            case NORTH -> "^";
            case EAST -> ">";
            case SOUTH -> "v";
            case WEST -> "<";
        };
    }
    public boolean isAt(Vector2d position){
        return this.position.equals(position);
    }
    public void move(MoveDirection direction){
        Vector2d newPosition=position;
        switch (direction){
            case RIGHT -> orientation=orientation.next();
            case LEFT -> orientation=orientation.previous();
            case FORWARD -> newPosition=position.add(orientation.toUnitVector());
            case BACKWARD -> newPosition=position.substract(orientation.toUnitVector());
            }
            if (map.canMoveTo(newPosition)){
                this.position=newPosition;
            }
    }
}
