package fr.epf.lastminutetraining.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Mail;
import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.domain.Vendor;
import fr.epf.lastminutetraining.service.TrainingDBService;
import fr.epf.lastminutetraining.service.VendorDBService;

@Controller
public class MyTrainingsController {
	@Autowired
	private TrainingDBService service;
	@Autowired
	private VendorDBService vservice;

	@RequestMapping(method = RequestMethod.GET, value = { "/mytrainings" })
	protected ModelAndView home(HttpSession session) {
		// A modifier par l'id du vendeur
		//ObjectId id = new ObjectId("54668afc44ae11795d109a61");
		String id = session.getAttribute("id").toString();//System.out.println(id);
		if (session.getAttribute("status").equals("client")){
			return new ModelAndView("404");
		}

		return new ModelAndView("myTrainings", "trainings",
				service.findAllTrainings(id));
	}

	@RequestMapping(method = RequestMethod.GET, value = { "/mytrainings/edit/{code}" })
	protected ModelAndView home(@PathVariable("code") String code, HttpSession session) {
		if (session.getAttribute("status").equals("client")){
			return new ModelAndView("404");
		}
		return new ModelAndView("editTraining", "training",
				service.findTraining(code));
	}

	@RequestMapping(method = RequestMethod.POST, value = "mytrainings/add")
	protected ModelAndView createTraining(HttpSession session,
			@ModelAttribute("training") Training training, BindingResult errors) {

		// affichage des erreurs
		if (errors.hasErrors()) {
			// error handling code goes here.
			System.out.println(errors);
			return null;
		} else {
			String idVendor = session.getAttribute("id").toString();
			String id = session.getAttribute("id").toString();
			// Ajout de l'id du vendeur à la formation
			training.setVendorId(idVendor);
			// Ajout de la durée de la formation
			String start = training.getDate().get("startDate");System.out.println(start);
			String end = training.getDate().get("endDate");
			
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
			
			try {
				Date startDate = format.parse(start);System.out.println(start);
				Date endDate = format.parse(end);
				
				long diff = endDate.getTime() - startDate.getTime();
				String duration = String.valueOf(diff/(24 * 60 * 60 * 1000));//System.out.println(duration);
				training.setDuration(duration);
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// Sauvegarde de la formation
			service.save(training);

			// Envoi d'un mail de confirmation de crï¿½ation de formation
			ApplicationContext context = new ClassPathXmlApplicationContext(
					"context.xml");
			Vendor vendor = vservice.findVendor(id);
			try {
				Mail mm = (Mail) context.getBean("Mail");
				mm.sendMail(
						"lastminutetraining.epf@gmail.com",
						vendor.getMail(),
						"Confirmation de crï¿½ation de formation",
						"Cher vendeur,\n\n"
						+ "Vous venez de crï¿½er une nouvelle formation nommï¿½e "
						+ training.getName()
						+ "."
						+ " Merci de votre contribution ï¿½ notre catalogue.\n\nCordialement,\n\n"
						+ "L'ï¿½quipe Last Minute Training");

				return new ModelAndView("redirect:/mytrainings", "trainings",
						service.findAllTrainings(id));
			} finally {
				((AbstractApplicationContext) context).close();
			}
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "mytrainings/add")
	protected ModelAndView addTraining(HttpSession session) {
		if (session.getAttribute("validated").toString().equals("true")) {
			return new ModelAndView("addTraining");
		} else if (session.getAttribute("status").equals("client")){
			return new ModelAndView("404");
		} else {
			//ObjectId id = new ObjectId("54668afc44ae11795d109a61");
			String id = session.getAttribute("id").toString();//System.out.println(id);
			return new ModelAndView("myTrainings", "trainings",
					service.findAllTrainings(id));
		}
	}

}
