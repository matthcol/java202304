package geometry.utils;

import geometry.model.Point;
import geometry.model.WeightedPoint;

import java.util.Collection;

public class Compute {

    public static double filterWeightedPointSumWeight(
        Collection<Point> points
    ){
        return points.stream()
        		.filter(p -> p instanceof WeightedPoint)
        		.map(p -> (WeightedPoint) p)
        		.mapToDouble(WeightedPoint::getWeight)
        		.sum();
    }
}
