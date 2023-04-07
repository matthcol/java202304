package model;

import lombok.*;

// @Data // i.e @Getter @Setter @ToString @EqualsAndHashCode
@Getter
@Setter
@ToString(exclude = "duration")
@EqualsAndHashCode(exclude = "duration")
@NoArgsConstructor
@AllArgsConstructor
public class MovieL {
    private String title;
    private int year;
    private short duration;
    private PgType pg;
}
