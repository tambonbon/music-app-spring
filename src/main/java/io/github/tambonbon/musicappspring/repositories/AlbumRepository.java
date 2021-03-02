package io.github.tambonbon.musicappspring.repositories;

import io.github.tambonbon.musicappspring.models.Album;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;
@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
//    @Autowired
//    private AlbumRepository albumRepository;

//    @PersistenceContext
//    EntityManager entityManager;

    List<Album> findByNameContaining(String name);
    Album findFirstByNameContaining(String name);
    List<Album> findBySongsContaining(String name);
//    public List<Album> list() {
//        return albumRepository.findAll();
//    }
//
//    public Album create(Album album) {
//        return albumRepository.saveAndFlush(album);
//    }
//
//    public Album update(Album album) {
//        album = entityManager.merge(album);
//        entityManager.flush();
//        return album;
//    }
}

//@Repository
//interface AlbumRepository extends JpaRepository<Album, Long> {
//}