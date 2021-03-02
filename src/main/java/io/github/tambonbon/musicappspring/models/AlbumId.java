package io.github.tambonbon.musicappspring.models;

import java.io.Serializable;
import java.util.Objects;

public class AlbumId implements Serializable {
    private String artist;
    private String name;

    public AlbumId(String artist, String name) {
        this.artist = artist;
        this.name = name;
    }

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
