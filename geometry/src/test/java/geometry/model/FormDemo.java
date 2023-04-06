package geometry.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FormDemo {

//    @Test
//    void demoFormNotInstantiable() {
//        var f = new Form();
//    }

    @Test
    void demoLsp() {
        Point point = new Point("A", 3.5, 4.25);
        System.out.println(point);

        Form f = point;
        System.out.println(f);
        System.out.println(f.getName());
//        System.out.println(f.getX()); // property hidden
        f.translate(1, -1);
        System.out.println(point);
        System.out.println(f);

        Object o = point;
        System.out.println(o);
    }

}