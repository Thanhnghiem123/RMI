package entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Artist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@EqualsAndHashCode
public class Artist implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "artist_id")
    private String id;
    private String name;
    private LocalDate birthDate;
    private String url;

    @ManyToMany(mappedBy = "artists")
    private Set<Album> albums;
}
