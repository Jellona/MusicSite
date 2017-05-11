/* This can be used to add feature where each genre has its own list, not yet implemented */
package haagahelia.exercise.domain;

public class Genre {
	private String genre;
	
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	@Override
	public String toString() {
		return "genre";
	}
}
