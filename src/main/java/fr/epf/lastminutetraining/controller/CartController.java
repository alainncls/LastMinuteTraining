package fr.epf.lastminutetraining.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Transaction;
import fr.epf.lastminutetraining.service.TrainingDBService;

@Controller	
@SessionAttributes({"cart"})
public class CartController {
	
	@Autowired
	TrainingDBService tdbs;
	
	@RequestMapping(value = { "/cart/increment", "/cart/add" }, method = RequestMethod.POST)
	protected ModelAndView incrementTraining(
			@ModelAttribute String idTraining,
			@ModelAttribute("cart") Transaction cart ){
		cart.addTraining(tdbs.findTraining(idTraining));
		
		//TODO add view name
		return new ModelAndView("");
	}
	
	@RequestMapping(value = "/cart/decrement", method = RequestMethod.POST)
	protected ModelAndView decrementTraining(
			@ModelAttribute String idTraining,
			@ModelAttribute("cart") Transaction cart ){
		cart.removeTraining(tdbs.findTraining(idTraining));
		
		//TODO add view name
		return new ModelAndView("");
	}
	
	@RequestMapping(value = "/cart/remove", method = RequestMethod.POST)
	protected ModelAndView removeFromCart(
			@ModelAttribute String idTraining,
			@ModelAttribute("cart") Transaction cart ){
		cart.removeTraining(tdbs.findTraining(idTraining));
		
		//TODO add view name
		return new ModelAndView("");
	}
	
	@RequestMapping(value = "/cart/empty", method = RequestMethod.POST)
	protected ModelAndView emptyCart(
			@ModelAttribute("cart") Transaction cart ){
		cart.empty();
		
		//TODO add view name
		return new ModelAndView("");
	}

}
