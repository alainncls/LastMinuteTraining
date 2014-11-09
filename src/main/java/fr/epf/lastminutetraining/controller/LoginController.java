package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Client;
import fr.epf.lastminutetraining.domain.Mail;
import fr.epf.lastminutetraining.domain.User;
import fr.epf.lastminutetraining.domain.Vendor;
import fr.epf.lastminutetraining.service.ClientDBService;
import fr.epf.lastminutetraining.service.TrainingDBService;
import fr.epf.lastminutetraining.service.UserDBService;
import fr.epf.lastminutetraining.service.VendorDBService;

@Controller
public class LoginController {

	@Autowired
	private UserDBService uservice;
	@Autowired
	private VendorDBService vservice;
	@Autowired
	private ClientDBService cservice;
	@Autowired
	private TrainingDBService tservice;

	private static final String trainings = "trainings";
	private static final String home = "home";

	// methode pour log out
	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	protected ModelAndView logout(HttpSession session) {
		session.invalidate();
		return new ModelAndView(home, trainings, tservice.findLastTraining());
	}

	// Methode pour login de compte
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	protected ModelAndView login(@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password,
			HttpSession session) {
		System.out.println(password);
		User user = uservice.connect(login, password);
		if (user != null) {
			session.setAttribute("status", user.getStatus());
			session.setAttribute("login", user.getLogin());
			session.setAttribute("id", user.getId());
			return new ModelAndView(home, trainings,
					tservice.findLastTraining());
		} else {
			return new ModelAndView("login", "error", true);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/register", params = "status=vendor")
	protected ModelAndView registerVendor(
			@RequestParam(value = "mail") String mail,
			@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password) {
		//Création du compte
		Vendor vendor = new Vendor();
		vendor.setMail(mail);
		vendor.setLogin(login);
		vendor.setPassword(password);
		vservice.save(vendor);
		
		//Envoi d'un mail de confirmation
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
   	 
    	Mail mm = (Mail) context.getBean("Mail");
        mm.sendMail("lastminutetraining.epf@gmail.com",
     		   mail,
     		   "Confirmation de création de compte Last Minute Training", 
     		   "Cher vendeur,\n"
     		   + "Vous venez de créer un compte sur notre site Last Minute Training. Pour compléter votre compte, vuillez suivre le line suivant :...");
        
		return new ModelAndView(home, trainings, tservice.findLastTraining());
	}

	@RequestMapping(method = RequestMethod.POST, value = "/register", params = "status=client")
	protected ModelAndView registerClient(
			@RequestParam(value = "mail") String mail,
			@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password) {
		//Création d'un client
		Client client = new Client();
		client.setMail(mail);
		client.setLogin(login);
		client.setPassword(password);
		cservice.save(client);
		
		//Envoi d'un mail de confirmation
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
   	 
    	Mail mm = (Mail) context.getBean("Mail");
        mm.sendMail("lastminutetraining.epf@gmail.com",
     		   mail,
     		   "Confirmation de création de compte Last Minute Training", 
     		   "Cher client,\n"
     		   + "Vous venez de créer un compte sur notre site Last Minute Training. Pour compléter votre compte, vuillez suivre le line suivant :...");
		        
		return new ModelAndView(home, trainings, tservice.findLastTraining());
	}

}
