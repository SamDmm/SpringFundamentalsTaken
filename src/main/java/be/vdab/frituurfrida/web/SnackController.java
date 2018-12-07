package be.vdab.frituurfrida.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import be.vdab.frituurfrida.entities.Snack;
import be.vdab.frituurfrida.services.DefaultSnackService;

@Controller
@RequestMapping("snacks")
public class SnackController {
	private static final char[] ALFABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	private final DefaultSnackService snackService;
	
	SnackController(DefaultSnackService snackService) {
		this.snackService = snackService;
	}
	
	private static final String ALFABET_VIEW = "alfabet";
	@GetMapping("alfabet")
	ModelAndView alfabet() {
		return new ModelAndView(ALFABET_VIEW, "alfabet", ALFABET);
	}
	@GetMapping(params = "beginletter")
	ModelAndView findByBeginletter(char beginletter) {
		return new ModelAndView(ALFABET_VIEW, "alfabet", ALFABET).addObject("snacks", snackService.findByBeginNaam(String.valueOf(beginletter)));
	}
	private static final String BEGIN_NAAM_VIEW = "beginnaam";
	@GetMapping("beginnaam")
	ModelAndView beginNaam() {
		return new ModelAndView(BEGIN_NAAM_VIEW).addObject(new BeginNaamForm());
	}
	@GetMapping(params = "beginnaam")
	ModelAndView beginNaam(@Valid BeginNaamForm beginNaamForm, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView(BEGIN_NAAM_VIEW);
		if (bindingResult.hasErrors()) {
			return modelAndView;
		}
		List<Snack> snacks = snackService.findByBeginNaam(beginNaamForm.getBeginnaam());
		if (snacks.isEmpty()) {
			bindingResult.reject("geenSnacks");
		} else {
			modelAndView.addObject("snacks", snacks);
		}
		return modelAndView;
	}
}
