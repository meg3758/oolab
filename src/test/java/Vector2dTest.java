import agh.ics.oop.Vector2d;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class Vector2dTest {
    Vector2d v1 = new Vector2d(2,13);
    Vector2d v2 = new Vector2d(-4,-5);
    Vector2d v3 = new Vector2d(5,5);
    Vector2d v4 = new Vector2d(0,-11);
    Vector2d v5 = new Vector2d(2,13);
    Vector2d v6 = new Vector2d(-4,-5);
    Vector2d v7 = new Vector2d(5,5);
    Vector2d v8 = new Vector2d(0,11);
    @Test
    public void equalsTest(){
        assertEquals(v1,v5);
        assertEquals(v2,v6);
        assertEquals(v3,v7);
        assertEquals(v4,v8);
    }
    @Test
    public void toStringTest (){
        assertEquals("(2,13)",v1.toString());
        assertEquals("(-4,-5)",v2.toString());
        assertEquals("(5,5)",v3.toString());
        assertEquals("(0,-11)",v4.toString());

    }
    @Test
    public void precedesTest (){
        assertTrue(v2.precedes(v1));
        assertTrue(v2.precedes(v3));
        assertFalse(v1.precedes(v2));
    }
    @Test
    public void followTest (){
        assertFalse(v2.follows(v1));
        assertFalse(v2.follows(v3));
        assertTrue(v1.follows(v2));
    }
    @Test
    public void UpperRightTest (){
        assertEquals(new Vector2d(2, 13), v1.upperRight(v2));
        assertEquals(new Vector2d(5, 5), v3.upperRight(v4));
        assertEquals(new Vector2d(2, 13), v1.upperRight(v4));
    }
    @Test
    public void LowerLeftTest (){
        assertEquals(new Vector2d(-4, -5), v1.lowerLeft(v2));
        assertEquals(new Vector2d(0, -11), v3.lowerLeft(v4));
        assertEquals(new Vector2d(0,-11), v1.lowerLeft(v4));
    }
    @Test
    public void addTest (){
        assertEquals(new Vector2d(7, 18), v1.add(v3));
        assertEquals(new Vector2d(-4, -16), v2.add(v4));
        assertEquals(new Vector2d(1, 0), v2.add(v3));
    }
    @Test
    public void substractTest (){
        assertEquals(new Vector2d(-3, 8), v1.substract(v3));
        assertEquals(new Vector2d(-4, 6), v2.substract(v4));
        assertEquals(new Vector2d(-9, -10), v2.substract(v3));
    }
    @Test
    public void oppositeTest (){
        assertEquals(new Vector2d(-2,-13), v1.opposite());
        assertEquals(new Vector2d(4,5), v2.opposite());
        assertEquals(new Vector2d(-5,-5), v3.opposite());
    }
}
