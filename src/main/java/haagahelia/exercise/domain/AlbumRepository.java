/* The repository for album to enable getting all at once */
package haagahelia.exercise.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {

    List<Album> findByArtistName(String artistName);
    
}
