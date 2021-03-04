package io.github.tambonbon.musicappspring.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "song_plays")
public class SongPlay {
    @EmbeddedId
    private SongPlayId songPlayId;

    public SongPlay() {
    }

    public SongPlay(SongPlayId songPlayId) {
        this.songPlayId = songPlayId;
    }
}

@Embeddable
class SongPlayId implements Serializable {
    @Column(name = "song")
    @Getter
    @Setter
    private String song;

    @Column(name = "artist")
    @Getter
    @Setter
    private String artist;

    @Column(name = "user")
    @Getter
    @Setter
    private String user;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SongPlayId that = (SongPlayId) o;
        return Objects.equals(song, that.song) && Objects.equals(artist, that.artist) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(song, artist, user);
    }
}
