package io.github.tambonbon.musicappspring.controllers;

import io.github.tambonbon.musicappspring.models.Album;
import io.github.tambonbon.musicappspring.models.Song;
import io.github.tambonbon.musicappspring.repositories.SongRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SongController {
    private SongRepository songRepository;

    public SongController(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @PostMapping("/song/create")
    public Song creatSong(@RequestBody Song song) {
        return songRepository.saveAndFlush(song);
    }

    @GetMapping("/song/all")
    public List<Song> getSongs() {
        return songRepository.findAll();
    }
}
