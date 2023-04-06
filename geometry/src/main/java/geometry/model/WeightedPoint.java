package geometry.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WeightedPoint extends  Point {
    private double weight;

    public WeightedPoint(String name, double x, double y, double weight) {
        super(name, x, y);
        this.weight = weight;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("WeightedPoint{");
        sb.append("name=").append(getName());
        sb.append(", x=").append(getX());
        sb.append(", y=").append(getY());
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}
