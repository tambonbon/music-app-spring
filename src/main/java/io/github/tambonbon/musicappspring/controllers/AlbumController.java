package io.github.tambonbon.musicappspring.controllers;

import io.github.tambonbon.musicappspring.models.Album;
import io.github.tambonbon.musicappspring.repositories.AlbumRepository;
import io.github.tambonbon.musicappspring.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {
//    private final String CONTEXT = "/albums";
    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumService albumService;

    public AlbumController(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    // Actions down here

    @PostMapping
//    @ResponseBody
    public void createAlbum(@RequestBody Album album) {
        albumService.addAlbum(album);

    }

    @GetMapping
    public List<Album> getAlbums() {
        return albumRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAlbum(@PathVariable Long id){
         albumRepository.deleteById(id);
    }
}
