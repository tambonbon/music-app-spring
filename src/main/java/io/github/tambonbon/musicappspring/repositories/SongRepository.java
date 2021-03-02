package io.github.tambonbon.musicappspring.repositories;

import io.github.tambonbon.musicappspring.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song, Long> {
    List<Song> findByNameContaining(String song);
    Song findFirstByNameContaining(String song);
}
