import agh.ics.oop.Animal;
import agh.ics.oop.MoveDirection;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AnimalTest {
    Animal animal1 = new Animal();

    @Test
    public void OrientationAndPositionTest() {
        animal1.move(MoveDirection.FORWARD);
        assertEquals("położenie zwierzęcia:\n pozycja: (2,3)\n orientacja: Północ", animal1.toString());
        animal1.move(MoveDirection.RIGHT);
        assertEquals("położenie zwierzęcia:\n pozycja: (2,3)\n orientacja: Wschód", animal1.toString());
        animal1.move(MoveDirection.BACKWARD);
        assertEquals("położenie zwierzęcia:\n pozycja: (1,3)\n orientacja: Wschód", animal1.toString());
        animal1.move(MoveDirection.LEFT);
        assertEquals("położenie zwierzęcia:\n pozycja: (1,3)\n orientacja: Północ", animal1.toString());
    }
    Animal animal2=new Animal();
    @Test
    public void InMapTest(){
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.FORWARD);
        animal2.move(MoveDirection.FORWARD);
        assertEquals("położenie zwierzęcia:\n pozycja: (2,4)\n orientacja: Północ", animal2.toString());
    }
    public boolean searchForValue(String input) {
        switch (input) {
            case "f", "forward", "b", "backward", "r", "right", "l", "left" -> {
                return true;
            }
        }
        return false;
    }

    @Test
    public void correctInputTest() {
        String[] correctDirections = {"f", "forward", "r", "l", "backward"};
        String[] wrongDirections = {"a", "back", "prawo", "lewo", "przód"};
        for (String s : correctDirections) {
            assertTrue(searchForValue(s));
        }
        for (String s : wrongDirections) {
            assertFalse(searchForValue(s));
        }
    }
}
