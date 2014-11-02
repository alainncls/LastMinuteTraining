package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.User;
import fr.epf.lastminutetraining.domain.Vendor;
import fr.epf.lastminutetraining.service.TrainingDBService;
import fr.epf.lastminutetraining.service.UserDBService;
import fr.epf.lastminutetraining.service.VendorDBService;

@Controller
public class LoginController {

	@Autowired
	private UserDBService uservice;
	@Autowired
	private VendorDBService vservice;
//	@Autowired
//	private UserDBService uservice;
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
	protected ModelAndView login(
			@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password,
			HttpSession session) {
		System.out.println(password);
		User user = uservice.connect(login, password);
		if(user!=null){
		session.setAttribute("status", user.getStatus());
		return new ModelAndView("home", "trainings",
				tservice.findLastTraining());
		}else{
			return new ModelAndView("login", "error", true);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/register", params = "status=vendor")
	protected ModelAndView register(
			@RequestParam(value = "mail") String mail,
			@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password) {
		Vendor vendor = new Vendor();
		vendor.setMail(mail);
		vendor.setLogin(login);
		vendor.setPassword(password);
		vservice.save(vendor);
		System.out.println(vendor.getPassword());
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
