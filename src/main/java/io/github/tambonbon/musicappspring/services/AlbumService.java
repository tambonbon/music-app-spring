package io.github.tambonbon.musicappspring.services;

import io.github.tambonbon.musicappspring.models.Album;
import io.github.tambonbon.musicappspring.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;

@Component
public interface AlbumService {
    public ResponseEntity<Collection<Album>> getAlbums();
    public ResponseEntity<Object> getAlbum(String artist, String name);
    public ResponseEntity<?> addAlbum(Album album) ;
    public void addAlbums(List<Album> albums) ;

    @Service("albumServiceImpl")
    class AlbumServiceImpl implements AlbumService {
        @Autowired
        private AlbumRepository albumRepository;

        @Transactional
        public ResponseEntity<Collection<Album>> getAlbums() {
            return new ResponseEntity<>(albumRepository.findAll(), HttpStatus.OK);
        }

        @Transactional
        public ResponseEntity<Object> getAlbum(String name, String artist){
            Album album = albumRepository.findAlbum(name, artist);
            if (album != null) {
                return new ResponseEntity<>(albumRepository.findAlbum(name, artist), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
            }
        }
        //TODO: throws error when adding duplicated album
        @Transactional
        public ResponseEntity<?> addAlbum(Album album) {
//            Album album = new Album();
//            if (albumRepository.findBy)
            return new ResponseEntity<>(albumRepository.saveAndFlush(album), HttpStatus.CREATED);
        }

        @Transactional
        public void addAlbums(List<Album> albums) {
            for (Album album : albums) {
                albumRepository.save(album);
            }
        }

//        public List<Album> saveAlbum(List<Album> albumList) {
//            int length = albumList.size();
//
//            // Create 2 Maps that store Albums and Songs
//            Map<String, Album> albumArray = new HashMap<>();
//            Map<String, Song> songArray = new HashMap<>();
//
//            for (int i = 0; i < length; i++) {
//                albumArray.put("album" + i, albumList.get(i));
//                songArray.put("song" + i, new Song());
//                albumArray.get("album" + i).getSongs().add(songArray.get("song" + i));
//            }
//            List<Album> albumResponse = (List<Album>) albumRepository.saveAll(albumList);
//            return albumResponse;
//        }
    }
}
