package fr.epf.lastminutetraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.service.TrainingDBService;

@Controller
@RequestMapping( value="/trainings")
public class TrainingController {

	@Autowired
	private TrainingDBService service;



	@RequestMapping(method = RequestMethod.GET, value = "/add")
	protected ModelAndView addTraining(){
		return new ModelAndView("addTraining");
	}

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView listTrainings(){
		return new ModelAndView("listTrainings", "trainings", service.findAllTrainings());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/add")
	protected void createTraining(@ModelAttribute("training")Training training){
	}
	@RequestMapping(value="/{code}")
	@ResponseBody
	protected ModelAndView training(@PathVariable("code") String code){
		Training x = service.findTraining(code);
		if(x!=null){
			return new ModelAndView("training", "training", x);
		}
		else{
			return new ModelAndView("404");
		}
	}
}
