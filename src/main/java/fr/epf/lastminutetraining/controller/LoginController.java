package fr.epf.lastminutetraining.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Vendor;
import fr.epf.lastminutetraining.service.TrainingDBService;
import fr.epf.lastminutetraining.service.VendorDBService;

@Controller
public class LoginController {

	@Autowired
	private VendorDBService vservice;
	// @Autowired
	// private ClientDBService cservice;
	@Autowired
	private TrainingDBService tservice;

	// methode pour log out
	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	protected ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView("home", "trainings",
				tservice.findLastTraining());
	}

	// Methode pour login de compte
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	protected ModelAndView login(@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password,
			HttpSession session) {
		// Add verif in bdd
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		session.setAttribute("status", "vendor");
		return new ModelAndView("home", "trainings",
				tservice.findLastTraining());

	}

	@RequestMapping(method = RequestMethod.POST, value = "/register", params = "status=vendor")
	protected ModelAndView register(@ModelAttribute("vendor") Vendor vendor) {
		vservice.save(vendor);
		return new ModelAndView("home", "trainings",
				tservice.findLastTraining());
	}

	// @RequestMapping(method = RequestMethod.POST, value = "/register", params
	// = "status=client")
	// protected ModelAndView register(@ModelAttribute("client")Client client){
	// cservice.save(client);
	// return new ModelAndView("home", "trainings",tservice.findLastTraining());
	// }

}
