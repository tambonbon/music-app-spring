package io.github.tambonbon.musicappspring.repositories;

import io.github.tambonbon.musicappspring.models.Album;
import io.github.tambonbon.musicappspring.models.AlbumId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, AlbumId> {
//    @Autowired
//    private AlbumRepository albumRepository;

//    @PersistenceContext
//    EntityManager entityManager;

//    List<Album> findAlbumByAlbumId_Name(String name);
    @Query(value =
            "SELECT * " +
                    "FROM albums a " +
                    "WHERE a.name = :name AND a.artist = :artist",
            nativeQuery = true
    )
    Album findAlbum(@Param("name") String name,@Param("artist") String artist);
//    List<Album> findBySongsContaining(String name);
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