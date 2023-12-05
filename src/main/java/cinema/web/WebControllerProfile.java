package cinema.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cinema.data.JpaFilmRepository;
import cinema.entity.Film;
import cinema.entity.User;

@Controller
@SessionAttributes("selectedFilm")
public class WebControllerProfile {
	
	private JpaFilmRepository filmRepo;
	
	public WebControllerProfile(JpaFilmRepository filmRepo) {
		this.filmRepo = filmRepo;
	}
	
	@ModelAttribute
	public void getFilmAttributes(Model model) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("films", user.getFilms());
		
		String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("currentUser", currentUser);
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	public String catalogForm(Model model) {
		return "profile";
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.POST)
	public String catalogSelect(@RequestParam("id") int id, Model model) {
		Film film = new Film();
		film = filmRepo.findById(id).get();
		
		model.addAttribute("selectedFilm", film);
		
		return "redirect:/film";
	}
}
