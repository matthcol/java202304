package movies.entity;

import lombok.*;
import movies.enums.PgType;

import javax.persistence.*;


// lombok annotations
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString(of = {"id", "title", "year"})
// JPA annotations
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int year;

    private Short duration;

    @Enumerated(EnumType.STRING)
    private PgType pg;
}
