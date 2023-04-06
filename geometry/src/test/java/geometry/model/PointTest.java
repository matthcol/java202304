package geometry.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    void testConstructorDefault(){
        var point = new Point();
        assertNull(point.getName(), "default name");
        assertEquals(0.0, point.getX(), "default x");
        assertEquals(0.0, point.getY(), "default y");
    }

    @Test
    void testConstructorAllArgs(){
        double x = 3.5;
        double y = 4.25;
        String name = "A";
        var point = new Point(name, x, y);
        assertEquals(name, point.getName(), "name");
        assertEquals(x, point.getX(), "x");
        assertEquals(y, point.getY(), "y");
    }

    @Test
    void testDistance(){
        var point1 = new Point("A",2.5, 4.25);
        var point2 = new Point("B",5.5, 0.25);
        double d = point1.distance(point2);
        assertEquals(5.0, d, "distance");
    }

    @Test
    void testTranslate(){
        var point = new Point("A",2.5, 4.25);
        point.translate(3.25, -2.25);
        assertEquals(5.75, point.getX(), "x coordinate");
        assertEquals(2.0, point.getY(), "y coordinate");
    }

}