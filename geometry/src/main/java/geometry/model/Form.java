package geometry.model;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public abstract class Form {
    private String name;

    public abstract void translate(double deltaX, double deltaY);
}
