/* The main controller of site */
package haagahelia.exercise.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


import haagahelia.exercise.domain.Album;
import haagahelia.exercise.domain.AlbumRepository;
import java.util.List;



@Controller
public class MusicController {
	@Autowired
	private AlbumRepository repository; 
	
	
	/* */
	// RESTful to get one album by id
	@RequestMapping(value="/album/{id}", method = RequestMethod.GET)
    public @ResponseBody Album findStudentRest(@PathVariable("id") Long albumId) {	
    	return repository.findOne(albumId);
    }
	
	// RESTful service to get all albums
    @RequestMapping(value="/albums", method = RequestMethod.GET)
    public @ResponseBody List<Album> albumListRest() {	
        return (List<Album>) repository.findAll();
    } 
    
	/* */
	
	
	/* First user has to log in */
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	} 
	
	
	@RequestMapping(value="/albumlist")
    public String studentList(Model model) {	
        model.addAttribute("albums", repository.findAll());
        return "genres/classical";
    }
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Album album){
        repository.save(album);
        return "redirect:albumlist";
    }
	
	/* Controller for adding albums to genres */
	@RequestMapping(value = "/add")
    public String addAlbum(Model model){
    	model.addAttribute("album", new Album());
        return "addAlbum";
    }
	
	/* Controller for where user starts to use site */
    @RequestMapping(value="/start", method=RequestMethod.GET)
    public String greeting() {
        return "frontPage";
    }
	
    /* Controller for submitting an artist */
    /*
	@RequestMapping(value="/hello", method=RequestMethod.GET)
    public String greetingForm(Model model) {
        model.addAttribute("message", new Album());
        return "hello";
    }
    */
    
	/* Result controller from submitting an artist */
    @RequestMapping(value="/hello", method=RequestMethod.POST)
    public String greetingSubmit(@Valid Album msg, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
        	return "genre";
        }
        
    	model.addAttribute("message", msg);
        return "resultAlbums";
    }
	
    /* Controller for moving to view genres */
    @RequestMapping(value="/genre", method=RequestMethod.GET)
    public String movingToGenre() {
        return "genre";
    }
    
    /* For navigating to different genres */
    @RequestMapping(value="/classical")
	public String classicalGenre(Model model) {
		model.addAttribute("albums", repository.findAll());
		return "genres/classical";
	}

    @RequestMapping(value="/metal")
	public String metalGenre(Model model) {
		model.addAttribute("albums", repository.findAll());
		return "genres/metal";
	}
    
    @RequestMapping(value="/pop")
	public String popGenre(Model model) {
		model.addAttribute("albums", repository.findAll());
		return "genres/pop";
	}
    
    @RequestMapping(value="/rap")
	public String rapGenre(Model model) {
		model.addAttribute("albums", repository.findAll());
		return "genres/rap";
	}
    
    @RequestMapping(value="/rock")
	public String rockGenre(Model model) {
		model.addAttribute("albums", repository.findAll());
		return "genres/rock";
	}
	
	
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteAlbum(@PathVariable("id") Long albumId, Model model) {
    	repository.delete(albumId);
        return "redirect:/albumlist";
    } 
	
    /* Rest Guide controller */
    @RequestMapping(value="/rest", method=RequestMethod.GET)
    public String movingToRestGuide() {
        return "restGuide";
    }
	
	
    
}
