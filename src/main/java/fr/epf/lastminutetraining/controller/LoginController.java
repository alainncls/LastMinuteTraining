package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Client;
import fr.epf.lastminutetraining.domain.Mail;
import fr.epf.lastminutetraining.domain.Transaction;
import fr.epf.lastminutetraining.domain.TransactionBuilder;
import fr.epf.lastminutetraining.domain.User;
import fr.epf.lastminutetraining.domain.Vendor;
import fr.epf.lastminutetraining.service.ClientDBService;
import fr.epf.lastminutetraining.service.TrainingDBService;
import fr.epf.lastminutetraining.service.VendorDBService;

@Controller
@SessionAttributes({ "cart" })
public class LoginController {

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
			HttpSession session, Model model) {
		User user = vservice.connect(login, password);
		if (user == null) {
			user = cservice.connect(login, password);
		}
		if (user != null) {
			session.setAttribute("status", user.getStatus());
			session.setAttribute("login", user.getLogin());
			session.setAttribute("id", user.getId());
			session.setAttribute("validated", user.getActivated());

			if (!model.containsAttribute("cart")) {
				Transaction tr = TransactionBuilder.transaction().client((Client) user).build();
				model.addAttribute("cart", tr);
			}
			return new ModelAndView(home, trainings,
					tservice.findLastTraining());
		} else {
			return new ModelAndView("login", "error", true);
		}

	}

	@RequestMapping(method = RequestMethod.POST, value = "/register")
	protected ModelAndView register(@RequestParam(value = "mail") String mail,
			@RequestParam(value = "login") String login,
			@RequestParam(value = "password") String password,
			@RequestParam(value = "status") String status) {
		// Cr�ation du compte
		User user;
		if (status.equals("vendor")) {
			user = new Vendor();
		} else {
			user = new Client();
		}
		user.setMail(mail);
		user.setLogin(login);
		user.setPassword(password);
		if (status.equals("vendor")) {
			user.setActivated(false);
			vservice.save((Vendor) user);
		} else {
			user.setActivated(true);
			cservice.save((Client) user);
		}

		String typeOfUser = "";
		if (status.equals("vendor")) {
			typeOfUser = "vendeur";
		} else {
			typeOfUser = "client";
		}
		// Envoi d'un mail de confirmation
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"context.xml");

		try {
			Mail mm = (Mail) context.getBean("Mail");
			mm.sendMail(
					"lastminutetraining.epf@gmail.com",
					mail,
					"Confirmation de cr�ation de compte Last Minute Training",
					"Cher "
							+ typeOfUser
							+ ",\n"
							+ "Vous venez de créer un compte sur notre site Last Minute Training. "
							+ "Pour compléter votre compte, veuillez utiliser votre interface \" mon compte \" disponible"
							+ " à l\'adresse suivante : http://lastminutetraining.epf.fr/myaccount\n\n"
							+ "Cordialement,\n\nL'équipe Last Minute Training");

			return new ModelAndView(home, trainings,
					tservice.findLastTraining());
		} finally {
			((AbstractApplicationContext) context).close();
		}
	}
}
