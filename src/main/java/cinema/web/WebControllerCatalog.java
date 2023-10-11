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

@Controller
@SessionAttributes("selectedFilm")
public class WebControllerCatalog {
	
	private JpaFilmRepository filmRepo;
	
	public WebControllerCatalog(JpaFilmRepository filmRepo) {
		this.filmRepo = filmRepo;
	}
	
	@ModelAttribute
	public void getFilmAttributes(Model model) {
		model.addAttribute("films", filmRepo.findAll());
		
		String currentUser = SecurityContextHolder.getContext().getAuthentication().getName();
		model.addAttribute("currentUser", currentUser);	
	}
	
	@RequestMapping(value="/catalog", method=RequestMethod.GET)
	public String catalogForm(Model model) {
		return "catalog";
	}
	
	@RequestMapping(value="/catalog", method=RequestMethod.POST)
	public String catalogSelect(@RequestParam("id") int id, Model model) {
		Film film = new Film();
		film = filmRepo.findById(id).get();
		
		model.addAttribute("selectedFilm", film);
		
		return "redirect:/film";
	}
}
