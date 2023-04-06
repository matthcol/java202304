package geometry.model;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FormDemo {

//    @Test
//    void demoFormNotInstantiable() {
//        var f = new Form();
//    }

    @Test
    void demoLspPointFormObject() {
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

    @Test
    void demoPointWeightedPoint(){
        Point point = new Point("A", 3.5, 4.0);
        WeightedPoint wpoint = new WeightedPoint("B", 7.5, 7.0, 100.0);
        System.out.println(point);
        System.out.println(wpoint);

        // LSP: arg expected of type Point
        // wpoint of type WeightedPoint is also a Point
        double d1 = point.distance(wpoint);
        System.out.println("Distance p-wp: " + d1);

        // by inheritance a WeightedPoint has method distance
        double d2 = wpoint.distance(point);
        System.out.println("Distance wp-p: " + d2);

        List<Point> points = List.of(
                point,
                wpoint,
                new Point("D", 1.2, 3.4),
                new WeightedPoint("E", 6.7, 7.8, 50.2)
        );
        System.out.println(points);
        for (var p: points) {
            System.out.println("\t- " + p);
            System.out.println("\t\tname: " + p.getName());
            System.out.println("\t\tx: " + p.getX());
            System.out.println("\t\ty: " + p.getY());
        }

        Point p = wpoint;
        Form f = wpoint;
        Object o = wpoint;
        // what is the real class of an object ?
        // how has it been constructed ?
        System.out.println("Real class of p: " + p.getClass());
        System.out.println("Real class of f: " + f.getClass());
        System.out.println("Real class of o: " + o.getClass());

        // types compatibility ?
        // always true
        System.out.println(wpoint instanceof WeightedPoint); // true
        System.out.println(wpoint instanceof Point); // true
        System.out.println(wpoint instanceof Form); // true
        System.out.println(wpoint instanceof Object); // true
        // perhaps
        System.out.println(p instanceof WeightedPoint); // true
        System.out.println(point instanceof WeightedPoint); // false
        System.out.println(f instanceof Point); // true
        System.out.println(f instanceof WeightedPoint); // true

        WeightedPoint wp1 = (WeightedPoint) p;
        WeightedPoint wp2 = (WeightedPoint) f;
        // WeightedPoint wp3 = (WeightedPoint) point; // java.lang.ClassCastException

        // extraire les weighted points de la liste de point pour calculer le poids total
    }

}