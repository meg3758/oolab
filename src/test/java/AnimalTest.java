}


    }


        assertTrue(engine.getAnimal(2).isAt(new Vector2d(4,5)));
        assertTrue(engine.getAnimal(1).isAt(new Vector2d(4,3)));
        assertTrue(engine.getAnimal(0).isAt(new Vector2d(1,5)));
        engine.run();
        SimulationEngine engine = new SimulationEngine(directions,map,positions);
        Vector2d[] positions = {new Vector2d(1,1),new Vector2d(2,3),new Vector2d(4,5)};
        IWorldMap map = new RectangularMap(5,6);
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
    public void movementTest(){
    @Test

    }
        assertEquals(new Vector2d(2,4),animal2.getPosition());
        animal2.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal2.getPosition());
        animal2.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,3),animal2.getPosition());
        animal2.move(MoveDirection.FORWARD);
    public void positionTest(){
    @Test
    Animal animal2 = new Animal();
    }
        assertEquals(MapDirection.SOUTH,animal1.getOrientation());
        animal1.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST,animal1.getOrientation());
        animal1.move(MoveDirection.RIGHT);
    public void orientationTest(){
    @Test
    Animal animal1 = new Animal();
public class AnimalTest {

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import agh.ics.oop.*;
