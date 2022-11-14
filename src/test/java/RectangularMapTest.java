import agh.ics.oop.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class RectangularMapTest {
    Animal animal1 = new Animal();
    @Test
    public void orientationTest(){
        animal1.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.EAST,animal1.getOrientation());
        animal1.move(MoveDirection.RIGHT);
        assertEquals(MapDirection.SOUTH,animal1.getOrientation());
    }
    Animal animal2 = new Animal();
    @Test
    public void positionTest(){
        animal2.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,3),animal2.getPosition());
        animal2.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal2.getPosition());
        animal2.move(MoveDirection.FORWARD);
        assertEquals(new Vector2d(2,4),animal2.getPosition());
    }

    @Test
    public void movementTest(){
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        IWorldMap map = new RectangularMap(5,6);
        Vector2d[] positions = {new Vector2d(1,1),new Vector2d(2,3),new Vector2d(4,5)};
        SimulationEngine engine = new SimulationEngine(directions,map,positions);
        engine.run();
        assertTrue(engine.getAnimal(0).isAt(new Vector2d(1,5)));
        assertTrue(engine.getAnimal(1).isAt(new Vector2d(4,3)));
        assertTrue(engine.getAnimal(2).isAt(new Vector2d(4,5)));


    }


}
