package io.github.tambonbon.musicappspring.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "songs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@IdClass(SongId.class)
public class Song {

//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "song_id")
//    @Getter
//    @Setter
//    private Long songId;

    @Id
    @Column(name = "title")
    @Getter
    @Setter
    private String title;

    @Id
    @Column(name = "duration")
    @Getter
    @Setter
    private String duration;
    public Song() {
    }


    @ManyToMany(mappedBy = "songs",  cascade = CascadeType.ALL)
    @JsonIgnore
    @Getter
    @Setter
    private List<Album> albums;

}
