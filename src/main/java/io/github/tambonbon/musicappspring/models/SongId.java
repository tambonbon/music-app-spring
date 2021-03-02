package io.github.tambonbon.musicappspring.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class SongId implements Serializable {

//    private Long songId;


    private String title;

    private String duration;

//    public SongId(Long songId, String title, String duration) {
//        this.songId = songId;
//        this.title = title;
//        this.duration = duration;
//    }

    public SongId(String name, String duration) {
        this.title = name;
        this.duration = duration;
    }

    public SongId() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongId songId = (SongId) o;
        return Objects.equals(title, songId.title) && Objects.equals(duration, songId.duration);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration);
    }
}
