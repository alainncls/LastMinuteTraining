package fr.epf.lastminutetraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.service.TrainingDBService;

@Controller
public class PdfController {
	@Autowired
	private TrainingDBService tdbs;

	@RequestMapping(value = "/generate/facture.pdf", method = RequestMethod.GET)
	protected ModelAndView generatePdf() {
		Training training = tdbs.findTraining("5469d513f2e9d2cd3e1b9e9a");
		return new ModelAndView("pdfView", "training", training);
	}
}