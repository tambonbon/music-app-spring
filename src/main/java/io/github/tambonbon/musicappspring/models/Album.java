package io.github.tambonbon.musicappspring.models;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "albums")
//@JsonIdentityInfo(
//        generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "albumId"
//)
@JsonIgnoreProperties({"hibernateLazyInitalizer", "handler"})
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    @Getter
    @Setter
    private Long albumId;

    @Column(name = "name" )
    @Getter
    @Setter
    private String name;

    @Column(name = "artist" )
    @Getter
    @Setter
    private String artist;

    @Column(name = "genre" )
    @Getter
    @Setter
    private String genre;

    public Album() {
    }

    // Add Songs entity to make a relationship
    @ManyToMany(targetEntity = Song.class, cascade = CascadeType.ALL)
    @JoinTable(
            name = "albums_songs",
            joinColumns = @JoinColumn(name = "album_id"), // FK
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    @Getter
    @Setter
    private List<Song> songs;

}
