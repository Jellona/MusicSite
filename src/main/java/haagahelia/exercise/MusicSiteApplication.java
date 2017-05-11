/* The main part of the application */
package haagahelia.exercise;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import haagahelia.exercise.domain.Album;
import haagahelia.exercise.domain.AlbumRepository;

@SpringBootApplication
public class MusicSiteApplication {
	private static final Logger log = LoggerFactory.getLogger(MusicSiteApplication.class);

	
	public static void main(String[] args) {
		SpringApplication.run(MusicSiteApplication.class, args);
	}
	
	/* Adding some test data to database so user right away sees some albums */
	@Bean
	public CommandLineRunner albumDemo(AlbumRepository repository) {
		return (args) -> {
			log.info("examples of albums");
			repository.save(new Album("Muse", "Absolution", "2003", "8"));
			repository.save(new Album("Black Keys", "Rubber Factory", "2004", "9"));	
			
			log.info("show all albums");
			for (Album album : repository.findAll()) {
				log.info(album.toString());
			}

		};
	}
	
	
}
