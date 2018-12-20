package be.vdab.frituurfrida.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.entities.GastenboekEntry;
import be.vdab.frituurfrida.services.GastenboekService;

@Controller
@RequestMapping("gastenboek")
public class GastenboekController {
	private final GastenboekService service;
	
	GastenboekController(GastenboekService service) {
		this.service = service;
	}
	private static final String GASTENBOEK_VIEW = "gastenboek";
	@GetMapping
	ModelAndView toonGastenboek() {
		return new ModelAndView(GASTENBOEK_VIEW, "gastenboekList", service.findAll());
	}
	@GetMapping("toevoegen")
	ModelAndView toevoegen() {
		return new ModelAndView(GASTENBOEK_VIEW, "gastenboekList", service.findAll()).addObject(new GastenboekEntry());
	}
	private static final String REDIRECT_NA_TOEVOEGEN = "redirect:/gastenboek";
	@PostMapping()
	ModelAndView toevoegen(@Valid GastenboekEntry gastenboekEntry, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ModelAndView(GASTENBOEK_VIEW, "gastenboek", service.findAll());
		}
		service.create(gastenboekEntry);
		return new ModelAndView(REDIRECT_NA_TOEVOEGEN);
	}
	private static final String REDIRECT_NA_DELETE = "redirect:/gastenboek";
	@PostMapping("verwijderen")
	ModelAndView verwijderen(long[] verwijderid) {
		
		if (verwijderid != null) {
			for (long id : verwijderid) {
				service.delete(id);
			}
		}
		return new ModelAndView(REDIRECT_NA_DELETE);
	}
}
