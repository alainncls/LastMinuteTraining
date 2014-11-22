package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
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
	
	@RequestMapping(method = RequestMethod.GET, value = { "/mytrainings"})
	protected ModelAndView home() {
		//A modifier par l'id du vendeur
		ObjectId id = new ObjectId("54668afc44ae11795d109a61");
		//ObjectId id = new ObjectId(session.getAttribute("id").toString());
		return new ModelAndView("myTrainings", "trainings", service.findAllTrainings(id));
	}
	@RequestMapping(method = RequestMethod.GET, value = { "/mytrainings/edit/{code}" })
	protected ModelAndView home(@PathVariable("code") String code) {
		ObjectId id = new ObjectId("54668afc44ae11795d109a61");
		//ObjectId id = new ObjectId(session.getAttribute("id").toString());
		return new ModelAndView("editTraining", "training", service.findTraining(code));
	}
	@RequestMapping(method = RequestMethod.POST, value = "mytrainings/add")
	protected ModelAndView createTraining(HttpSession session, @ModelAttribute("training")Training training){
		
		//sauvegarde de la formation
		service.save(training);
		
		//Envoi d'un mail de confirmation de cr�ation de formation
		ApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		ObjectId idVendor = new ObjectId(session.getAttribute("id").toString());
   	 	Vendor vendor = vservice.findVendor(idVendor);
		
    	Mail mm = (Mail) context.getBean("Mail");
        mm.sendMail("lastminutetraining.epf@gmail.com",
     		   vendor.getMail(),
     		   "Confirmation de cr�ation de formation", 
     		   "Cher vendeur,\n\n"
     		   + "Vous venez de cr�er une nouvelle formation nomm�e "+training.getName()+"."
     		   + " Merci de votre contribution � notre catalogue.\n\nCordialement,\n\n"
     		   + "L'�quipe Last Minute Training");
        
        return new ModelAndView("addTraining");
	}
	@RequestMapping(method = RequestMethod.GET, value = "mytrainings/add")
	protected ModelAndView addTraining(HttpSession session){
		if(session.getAttribute("validated").toString().equals("true")){
			return new ModelAndView("addTraining");
		}
		else{
			ObjectId id = new ObjectId("54668afc44ae11795d109a61");
			//ObjectId id = new ObjectId(session.getAttribute("id").toString());
			return new ModelAndView("myTrainings", "trainings", service.findAllTrainings(id));
		}
		
	}

}
