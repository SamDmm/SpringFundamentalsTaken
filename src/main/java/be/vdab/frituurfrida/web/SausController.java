package be.vdab.frituurfrida.web;

<<<<<<< HEAD
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.services.SausService;

@Controller
@RequestMapping("sauzen")
class SausController {
	private static final String SAUZEN_VIEW = "sauzen";
	private final SausService sausService;
	SausController(SausService sausService) {
		this.sausService = sausService;
	}
	@GetMapping
	ModelAndView sauzen() {
		return new ModelAndView(SAUZEN_VIEW, "sauzen", sausService.findAll());
=======
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.entities.Saus;

@Controller
@RequestMapping("sauzen")
class SausController {
	private List<Saus> sauzen = Arrays.asList(
			new Saus(1L, "cocktail", Arrays.asList("olie", "eieren", "azijn", "ketchup")),
			new Saus(2L, "mayonaise", Arrays.asList("olie", "eieren", "azijn", "citroen")),
			new Saus(3L, "mosterd", Arrays.asList("mosterdzaad", "azijn")),
			new Saus(4L, "tartare", Arrays.asList("olie", "eieren", "azijn", "kruiden")),
			new Saus(5L, "vinaigrette", Arrays.asList("olie", "azijn", "kruiden"))
			);
	private static final String SAUZEN_VIEW = "sauzen";
	@GetMapping
	ModelAndView sauzen() {
		return new ModelAndView(SAUZEN_VIEW, "sauzen", sauzen);
>>>>>>> refs/remotes/origin/master
	}
}
