package cinema.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("selectedFilm")
public class WebControllerFilm {
	
	@RequestMapping(value="/film", method=RequestMethod.GET)
	public String filmForm(Model model) {
		return "film";
	}
}
