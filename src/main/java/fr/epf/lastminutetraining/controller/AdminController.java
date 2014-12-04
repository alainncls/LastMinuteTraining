package fr.epf.lastminutetraining.controller;

import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.service.TrainingDBService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/admin")
public class AdminController {

	@Autowired
	private TrainingDBService service;

	@RequestMapping(method = RequestMethod.GET, value = "/")
	protected ModelAndView admin() {
		return new ModelAndView("/admin");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/trainings")
	protected ModelAndView trainings() {
		return new ModelAndView("/trainingsAdmin", "trainings",
				service.findLastTraining());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/editTraining/{code}")
	protected ModelAndView edit(@PathVariable("code") String code) {
		return new ModelAndView("/editTraining", "training",
				service.findTraining(code));
	}
    @RequestMapping(method = RequestMethod.POST, value = "/editTraining/{code}")
    protected ModelAndView edit(@RequestParam(value = "training") Training training) {
            return new ModelAndView("/admin");
    }

	@RequestMapping(method = RequestMethod.GET, value = "/deleteTraining/{code}")
	protected ModelAndView delete(@PathVariable("code") ObjectId code) {
		service.remove(code);
        return new ModelAndView("redirect:/trainings", "trainings",
				service.findLastTraining());
	}
}
