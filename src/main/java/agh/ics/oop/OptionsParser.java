package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

public class OptionsParser {
    public static MoveDirection[] parse(String[] args){
        List<MoveDirection> directions = new ArrayList<>();
        for (String arg: args){
            switch (arg){
                case "f", "forward" -> directions.add(MoveDirection.FORWARD);
                case "b", "backward" -> directions.add(MoveDirection.BACKWARD);
                case "r", "right" -> directions.add(MoveDirection.RIGHT);
                case "l", "left" -> directions.add(MoveDirection.LEFT);
            }
        }
        MoveDirection[] array = new MoveDirection[directions.size()];
        directions.toArray(array);
        return array;
    }
}
