package geometry.model;

import lombok.*;

@Getter
@Setter
//@ToString(callSuper = true)
@NoArgsConstructor
public class Point extends Form {
    private double x;
    private double y;

	public Point(String name, double x, double y) {
		super(name);
		this.x = x;
		this.y = y;
	}

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
    @Override
	public void translate(double deltaX, double deltaY) {
		this.x += deltaX;
        this.y += deltaY;
	}

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Point{");
        sb.append("name=").append(getName());
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }
}
