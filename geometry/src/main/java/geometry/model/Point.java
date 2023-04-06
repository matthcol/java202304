package geometry.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Point {
    private double x;
    private double y;

    /**
     * distance from this point to other point
     * @param other
     * @return distance between this and other
     */
    public double distance(Point other) {
        return Math.hypot(
        		this.x - other.x, 
        		this.y - other.y
        );
    }

    /**
     * translate this point with relative offsets
     * @param deltaX x coordinate offset
     * @param deltaY y coordinate offset
     */
	public void translate(double deltaX, double deltaY) {
		this.x += deltaX;
        this.y += deltaY;
	}

    
}
