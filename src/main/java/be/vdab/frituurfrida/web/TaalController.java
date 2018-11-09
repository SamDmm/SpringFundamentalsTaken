package be.vdab.frituurfrida.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("voorkeurtaal")
class TaalController {
	private static final String VIEW = "voorkeurtaal";
	@GetMapping
	ModelAndView voorkeurtaal(@RequestHeader("accept-language") String acceptLanguage) {
		return new ModelAndView(VIEW, "voorkeurtaal", acceptLanguage.substring(0, 2).equalsIgnoreCase("nl"));
	}
}
