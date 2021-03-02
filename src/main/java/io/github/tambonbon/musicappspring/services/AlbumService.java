package io.github.tambonbon.musicappspring.services;

import io.github.tambonbon.musicappspring.models.Album;
import io.github.tambonbon.musicappspring.models.Song;
import io.github.tambonbon.musicappspring.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public interface AlbumService {
    public List<Album> saveAlbum(List<Album> albumList);
    public List<Album> getAlbums();
    public void addAlbum(Album album) ;
    public void addAlbums(List<Album> albums) ;

    @Service("albumServiceImpl")
    class AlbumServiceImpl implements AlbumService {
        @Autowired
        private AlbumRepository albumRepository;

        @Transactional
        public List<Album> getAlbums() {
            List<Album> albums = new ArrayList<>();
            albumRepository.findAll().forEach(albums::add);
            return albums;
        }

        @Transactional
        public void addAlbum(Album album) {
            albumRepository.saveAndFlush(album);
        }

        @Transactional
        public void addAlbums(List<Album> albums) {
            for (Album album : albums) {
                albumRepository.save(album);
            }
        }

        public List<Album> saveAlbum(List<Album> albumList) {
            int length = albumList.size();

            // Create 2 Maps that store Albums and Songs
            Map<String, Album> albumArray = new HashMap<>();
            Map<String, Song> songArray = new HashMap<>();

            for (int i = 0; i < length; i++) {
                albumArray.put("album" + i, albumList.get(i));
                songArray.put("song" + i, new Song());
                albumArray.get("album" + i).getSongs().add(songArray.get("song" + i));
            }
            List<Album> albumResponse = (List<Album>) albumRepository.saveAll(albumList);
            return albumResponse;
        }
    }
}
