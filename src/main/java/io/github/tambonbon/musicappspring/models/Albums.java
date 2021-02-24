package io.github.tambonbon.musicappspring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity(name = "albums")
@JsonIgnoreProperties({"hibernateLazyInitalizer", "handler"})
public class Albums {
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

    public Albums() {
    }

    // Add Songs entity to make a relationship
    @ManyToMany
    @JoinTable(
            name = "albums_songs",
            joinColumns = @JoinColumn(name = "album_id"), // FK
            inverseJoinColumns = @JoinColumn(name = "song_id")
    )
    private List<Songs> songs;
}
