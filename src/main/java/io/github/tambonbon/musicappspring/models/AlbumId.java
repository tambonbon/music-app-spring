package io.github.tambonbon.musicappspring.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;
//@Embeddable
public class AlbumId implements Serializable {

//    private Long albumId;

    private String artist;

    private String name;

//    public AlbumId(Long albumId, String artist, String name) {
//        this.albumId = albumId;
//        this.artist = artist;
//        this.name = name;
//    }

    public AlbumId(String artist, String name) {
        this.artist = artist;
        this.name = name;
    }

    public AlbumId() {    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AlbumId albumId = (AlbumId) o;
        return Objects.equals(artist, albumId.artist) && Objects.equals(name, albumId.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(artist, name);
    }
}
