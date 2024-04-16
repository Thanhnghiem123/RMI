package entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "Song")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Song implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "song_id")
    private String id;
    private String name;
    private String runtime;
    private String lyric;
    private String fileLink;

    @ManyToMany(mappedBy = "songs")
    private Set<Album> albums;

}
