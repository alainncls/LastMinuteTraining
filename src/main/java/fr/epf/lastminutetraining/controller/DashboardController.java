package fr.epf.lastminutetraining.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.service.TrainingDBService;

@Controller
public class DashboardController {

	@Autowired
	private TrainingDBService service;

	@RequestMapping(method = RequestMethod.GET, value = { "/home", "/" })
	protected ModelAndView home() {
		return new ModelAndView("home", "trainings", service.findLastTraining());
	}

	// Pour un champ de recherche 'inputName'
	@RequestMapping(method = RequestMethod.POST, value = { "/home", "/" })
	protected ModelAndView searchHome(
			@RequestParam(value="name")String search) {System.out.println("salu");
		List<Training> trainings = service.searchTraining(search);
		System.out.println(search);
		if (trainings.isEmpty()) {
			return home();
		} else {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("trainings", service.searchTraining(search));
			//params.put("training", training);
			return new ModelAndView("home", params);
		}
	}
}
