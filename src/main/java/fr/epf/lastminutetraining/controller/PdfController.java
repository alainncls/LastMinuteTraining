package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Client;
import fr.epf.lastminutetraining.domain.Order;
import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.service.ClientDBService;
import fr.epf.lastminutetraining.service.TrainingDBService;

@Controller
public class PdfController {
	@Autowired
	private TrainingDBService tdbs;
	@Autowired
	private ClientDBService cservice;

	@RequestMapping(value = "/generate/facture.pdf", method = RequestMethod.GET)
	protected ModelAndView generatePdf() {
		Training training = tdbs.findOneTraining();
		return new ModelAndView("pdfView", "training", training);
	}
	
	@RequestMapping(value = "/generate/factureClient.pdf", method = RequestMethod.GET)
	protected ModelAndView generatePdf(HttpSession session, Order order) {
		String idClient = session.getAttribute("id").toString();
		Client client = cservice.findClient(idClient);
		
		ModelAndView mav = new ModelAndView("pdfView");
		mav.addObject("client", client);
		mav.addObject("order", order);
		
		return mav;
	}
}