package fr.epf.lastminutetraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Order;

@Controller
public class PdfController {

	@RequestMapping(value = "/generate/pdf.htm", method = RequestMethod.GET)
	protected ModelAndView generatePdf(){

		Order order = new Order();

		return new ModelAndView("pdfView", "command", order);
	}
}