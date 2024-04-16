package entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "Genre")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@EqualsAndHashCode
public class Genre implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "genre_id")
    private String id;
    private String name;
    private String description;

    @OneToMany(mappedBy = "genre")
    private Set<Album> albums;



}
