package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Client;
import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.domain.Vendor;
import fr.epf.lastminutetraining.service.ClientDBService;
import fr.epf.lastminutetraining.service.TrainingDBService;
import fr.epf.lastminutetraining.service.VendorDBService;

@Controller
public class myTrainingsController {
	@Autowired
	private TrainingDBService service;
	
	@RequestMapping(method = RequestMethod.GET, value = { "/mytrainings", "/" })
	protected ModelAndView home() {
		ObjectId id = new ObjectId("54668afc44ae11795d109a61");
		return new ModelAndView("myTrainings", "trainings", service.findAllTrainings(id));
	}
	@RequestMapping(method = RequestMethod.GET, value = { "/mytrainings/edit/{code}", "/" })
	protected ModelAndView home(@PathVariable("code") String code) {
		ObjectId id = new ObjectId("54668afc44ae11795d109a61");
		return new ModelAndView("training", "training", service.findTraining(code));
	}
	@RequestMapping(method = RequestMethod.POST, value = "mytrainings/add")
	protected void createTraining(@ModelAttribute("training")Training training){
	}
	@RequestMapping(method = RequestMethod.GET, value = "mytrainings/add")
	protected ModelAndView addTraining(){
		return new ModelAndView("addTraining");
	}

}
