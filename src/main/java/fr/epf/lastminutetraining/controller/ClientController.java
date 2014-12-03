package fr.epf.lastminutetraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.service.ClientDBService;

/**
 * Created by Baptiste on 28/10/2014.
 */
@Controller
public class ClientController {

	@Autowired
	private ClientDBService service;

	@RequestMapping(method = RequestMethod.GET, value = "/admin/users")
	protected ModelAndView listTrainings(){
		return new ModelAndView("listClients", "clients", service.findAllClients());
	}
}
