package be.vdab.frituurfrida.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.entities.GastenboekEntry;
import be.vdab.frituurfrida.services.GastenboekService;

@Controller
@RequestMapping("gastenboek")
class GastenboekController {
	private final GastenboekService service;
	private static final String GASTENBOEK_VIEW = "gastenboek";
	
	GastenboekController(GastenboekService service) {
		this.service = service;
	}
	@GetMapping
	ModelAndView toonGastenboek() {
		List<GastenboekEntry> gastenboekList = service.findAll();
		return new ModelAndView(GASTENBOEK_VIEW, "gastenboekList", gastenboekList);
	}
	@GetMapping("toevoegen")
	ModelAndView toevoegen() {
		List<GastenboekEntry> gastenboekList = service.findAll();
		return new ModelAndView(GASTENBOEK_VIEW, "gastenboekList", gastenboekList).addObject(new GastenboekEntry());
	}
}
