package io.github.tambonbon.musicappspring.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity(name = "songs")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Songs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "song_id")
    @Getter
    @Setter
    private Long songId;

    @Column(name = "name")
    @Getter
    @Setter
    private String name;

    @Column(name = "duration")
    @Getter
    @Setter
    private String duration;
}
