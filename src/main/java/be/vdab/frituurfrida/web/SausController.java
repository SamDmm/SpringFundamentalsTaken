package be.vdab.frituurfrida.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.entities.Saus;
import be.vdab.frituurfrida.services.SausService;

@Controller
@RequestMapping("sauzen")
class SausController {
	private static final String SAUZEN_VIEW = "sauzen";
	private final SausService sausService;
	private final SausRadenSpel sausRadenSpel;
	SausController(SausService sausService, SausRadenSpel sausRadenSpel) {
		this.sausService = sausService;
		this.sausRadenSpel = sausRadenSpel;
	}
	@GetMapping
	ModelAndView sauzen() {
		return new ModelAndView(SAUZEN_VIEW, "sauzen", sausService.findAll());
	}
	private String randomSaus() {
		List<Saus> sauzen = sausService.findAll();
		int randomKeuzeGetal = (int) (Math.random() * sauzen.size());
		return sauzen.get(randomKeuzeGetal).getNaam();
	}
	
	private static final String RADEN_VIEW = "sausraden";
	@GetMapping("raden")
	ModelAndView sausRaden() {
		sausRadenSpel.reset(randomSaus());
		return new ModelAndView(RADEN_VIEW, "spel", sausRadenSpel).addObject(new SausRadenForm());
	}
	private static final String REDIRECT_NA_NIEUW_SPEL = "redirect:/sauzen/raden";
	@PostMapping("raden/nieuwspel")
	String radenNieuwSpel() {
		sausRadenSpel.reset(randomSaus());
		return REDIRECT_NA_NIEUW_SPEL;
	}
	private static final String REDIRECT_NA_LETTER_RADEN = "redirect:/sauzen/raden/volgendegok";
	@PostMapping(value = "raden", params = "letter")
	ModelAndView sausRaden(@Valid SausRadenForm form, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(RADEN_VIEW, "spel", sausRadenSpel);
		}
		sausRadenSpel.doeGok(form.getLetter());
		return new ModelAndView(REDIRECT_NA_LETTER_RADEN);
	}
	@GetMapping("raden/volgendegok")
	ModelAndView volgendeGok() {
		return new ModelAndView(RADEN_VIEW, "spel", sausRadenSpel).addObject(new SausRadenForm());
	}
}
