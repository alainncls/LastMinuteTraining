package fr.epf.lastminutetraining.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.service.TrainingDBService;

@Controller
public class DashboardController {

	@Autowired
	private TrainingDBService service;

	@RequestMapping(method = RequestMethod.GET, value = { "/home", "/" })
	protected ModelAndView home() {
		return new ModelAndView("home", "trainings", service.findLastTraining());
	}

	// pour un champs de recherche 'inputName'
	@RequestMapping(method = RequestMethod.POST, value = { "/home", "/" })
	protected ModelAndView searchHome(
			@RequestParam(value = "inputName", required = false) String search) {
		if (search == "" || search == null) {

			return home();
		} else {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("trainings", service.searchTraining(search));
			params.put("inputName", search);
			return new ModelAndView("home", params);
		}
	}
}
