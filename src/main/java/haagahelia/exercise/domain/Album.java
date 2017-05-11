/* Album class for website, contains all strings etc */
package haagahelia.exercise.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.FetchType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import java.util.List;

@Entity
public class Album {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String artistName;
	private String albumName;
	private String yearReleased;
	private String rating;
	
	@ManyToOne
    @JsonIgnore
    @JoinColumn(name = "albumid")
    private Album album;
	
	
	
	public Album() {}

	public Album(String artistName, String albumName, String yearReleased, String rating) {
		super();
		this.artistName = artistName;
		this.albumName = albumName;
		this.yearReleased = yearReleased;
		this.rating = rating;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getArtistName() {
		return artistName;
	}
	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}
	public String getAlbumName() {
		return albumName;
	}
	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}
	public String getYearReleased() {
		return yearReleased;
	}
	public void setYearReleased(String yearReleased) {
		this.yearReleased = yearReleased;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "artistName + albumName + yearReleased + rating";
	}
}