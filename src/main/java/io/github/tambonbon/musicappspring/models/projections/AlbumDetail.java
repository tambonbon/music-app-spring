package io.github.tambonbon.musicappspring.models.projections;

import io.github.tambonbon.musicappspring.models.Album;
import io.github.tambonbon.musicappspring.models.Song;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "albumDetail", types = {Album.class})
public interface AlbumDetail {
    String getName();
    String getArtist();
    String getGenre();
    List<Song> getSongs();
}
