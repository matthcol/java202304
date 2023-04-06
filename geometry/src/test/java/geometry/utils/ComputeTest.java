package geometry.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import geometry.model.Point;
import geometry.model.WeightedPoint;

class ComputeTest {

	@Test
	void testFilterWeightedPointSumWeight() {
		var points = List.of(
				new Point(),
				new WeightedPoint("B", 0.0, 0.0, 5.5),
				new Point(),
				new WeightedPoint("E", 0.0, 0.0, 1.25),
				new Point(),
				new WeightedPoint("G", 0.0, 0.0, 3.25),
				new Point()
				);
		var totalWeight = Compute.filterWeightedPointSumWeight(points);
		assertEquals(10.0, totalWeight, "total weight");
	}
	
	@Test
	void testFilterWeightedPointSumWeight_NoWeightedPoint() {
		var points = List.of(
				new Point(),
				new Point(),
				new Point()
		);
		var totalWeight = Compute.filterWeightedPointSumWeight(points);
		assertEquals(0.0, totalWeight, "total weight");
	}

}
