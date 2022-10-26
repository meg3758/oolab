package agh.ics.oop;

public class Animal {
    private MapDirection orientation = MapDirection.NORTH;
    private Vector2d position = new Vector2d(2,2);
    public String toString(){
        return "położenie zwierzęcia:\n pozycja: " + position + "\n orientacja: " + orientation;
    }
    public boolean isAt(Vector2d position){
        return this.position == position;
    }
    public void move(MoveDirection direction){
        switch (direction){
            case RIGHT -> orientation=orientation.next();
            case LEFT -> orientation=orientation.previous();
            case FORWARD -> {
                switch (orientation){
                    case NORTH -> {
                        if (position.y<4){
                            position=position.add(MapDirection.NORTH.toUnitVector());
                        }
                    }
                    case EAST -> {
                        if (position.x<4){
                            position=position.add(MapDirection.EAST.toUnitVector());
                        }
                    }
                    case SOUTH -> {
                        if (position.y>-4){
                            position=position.add(MapDirection.SOUTH.toUnitVector());
                        }
                    }
                    case WEST -> {
                        if (position.x>-4){
                            position=position.add(MapDirection.WEST.toUnitVector());
                        }
                    }
                }
            }
            case BACKWARD -> {
                switch (orientation){
                    case NORTH -> {
                        if (position.y>-4){
                            position=position.substract(MapDirection.NORTH.toUnitVector());
                        }
                    }
                    case EAST -> {
                        if (position.x>-4){
                            position=position.substract(MapDirection.EAST.toUnitVector());
                        }
                    }
                    case SOUTH -> {
                        if (position.y<4){
                            position=position.substract(MapDirection.SOUTH.toUnitVector());
                        }
                    }
                    case WEST -> {
                        if (position.x<4){
                            position=position.substract(MapDirection.WEST.toUnitVector());
                        }
                    }
                }
            }
            }
    }

}
