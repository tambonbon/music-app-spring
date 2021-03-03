package io.github.tambonbon.musicappspring.controllers;

import io.github.tambonbon.musicappspring.models.Album;
import io.github.tambonbon.musicappspring.repositories.AlbumRepository;
import io.github.tambonbon.musicappspring.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
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

    @PostMapping(consumes = "application/json")
    public ResponseEntity<?> createAlbum(@RequestBody Album album) {
        return new ResponseEntity<>(albumService.addAlbum(album), HttpStatus.CREATED);
    }

    @GetMapping
//    public List<Album> getAlbums() {
//        return albumRepository.findAll();
//    }
    public ResponseEntity<Collection<Album>> getAlbums(){
        return albumService.getAlbums();
    }

    @GetMapping(value = "/{name}/{artist}")
    public ResponseEntity<Object> getAlbum(@PathVariable String name, @PathVariable String artist){
        return albumService.getAlbum(name, artist);
    }
//    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
//    public void deleteAlbum(@PathVariable Long id){
//         albumRepository.deleteById(id);
//    }
}
