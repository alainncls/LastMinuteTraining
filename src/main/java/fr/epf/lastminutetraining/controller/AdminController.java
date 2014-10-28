package fr.epf.lastminutetraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {

	@RequestMapping(method = RequestMethod.GET, value = "/admin")
	protected ModelAndView admin() {
		return new ModelAndView("admin");
	}

}
