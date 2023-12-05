package cinema.web;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import cinema.data.JpaUserRepository;
import cinema.entity.Film;
import cinema.entity.User;

@Controller
@SessionAttributes("selectedFilm")
public class WebControllerFilm {
	
	private JpaUserRepository userRepo;
	
	public WebControllerFilm(JpaUserRepository userRepo) {
		this.userRepo = userRepo;
	}
	
	@RequestMapping(value="/film", method=RequestMethod.GET)
	public String filmForm(Model model) {
		return "film";
	}
	
	@RequestMapping(value="/addBookmark", method=RequestMethod.POST)
	public String bookmarkFilm(@RequestParam("id") int id, Model model, @ModelAttribute("selectedFilm") Film selectedFilm) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.addFilm(selectedFilm);
		userRepo.save(user);
		return "/film";
	}
	
	@RequestMapping(value="/removeBookmark", method=RequestMethod.POST)
	public String removeBookmarkFilm(@RequestParam("id") int id, Model model, @ModelAttribute("selectedFilm") Film selectedFilm) {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		user.removeFilm(selectedFilm);
		userRepo.save(user);
		return "/film";
	}
}
