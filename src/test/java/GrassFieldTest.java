import agh.ics.oop.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class GrassFieldTest {
    @Test
    public void correstMovement1Test() {
        int grass = 10;
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        GrassField grassField = new GrassField(grass);
        IEngine engine = new SimulationEngine(directions, grassField, positions);
        engine.run();
        assertTrue(grassField.canMoveTo(new Vector2d(2,2)));
        assertTrue(grassField.canMoveTo(new Vector2d(3,4)));
    }
    @Test
    public void correctMovement2Test() {
        int grass = 10;
        Vector2d[] positions = {new Vector2d(1,1),new Vector2d(2,3),new Vector2d(4,5)};
        GrassField grassField = new GrassField(grass);
        MoveDirection[] directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        SimulationEngine engine = new SimulationEngine(directions, grassField, positions);
        engine.run();
        assertTrue(grassField.canMoveTo(new Vector2d(1,1)));
        assertTrue(grassField.canMoveTo(new Vector2d(2,3)));
        assertTrue(grassField.canMoveTo(new Vector2d(4,5)));
    }
}
