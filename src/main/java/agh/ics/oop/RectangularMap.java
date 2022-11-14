package agh.ics.oop;

import java.util.ArrayList;

public class RectangularMap extends AbstractWorldMap{
    private final int width;
    private final int height;
    private final Vector2d lowerLeftCorner;
    private final Vector2d upperRightCorner;

    public RectangularMap(int width, int height){
        this.width=width;
        this.height=height;
        this.lowerLeftCorner=new Vector2d(0,0);
        this.upperRightCorner=new Vector2d(width-1,height-1);
        this.Animals=new ArrayList<>();
    }

    @Override
    public Vector2d upperRightCorner() {
        return upperRightCorner;
    }

    @Override
    public Vector2d lowerLeftCorner() {
        return lowerLeftCorner;
    }

}
