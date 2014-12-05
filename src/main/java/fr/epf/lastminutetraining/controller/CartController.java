package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Client;
import fr.epf.lastminutetraining.domain.Transaction;
import fr.epf.lastminutetraining.domain.TransactionBuilder;
import fr.epf.lastminutetraining.service.ClientDBService;
import fr.epf.lastminutetraining.service.TrainingDBService;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

	@Autowired
	TrainingDBService tdbs;
	@Autowired
	ClientDBService cdbs;
	Transaction cart;

	protected Transaction getCart(HttpSession session) {
		if (session.getAttribute("Cart") == null) {
			System.out.println("DEPUIS CARTCONTROLLER : " + new ObjectId(session.getAttribute("id").toString()));
			Client c = cdbs.findClient(new ObjectId(session.getAttribute("id")
					.toString()));
			Transaction t = TransactionBuilder.transaction().client(c).build();
			session.setAttribute("Cart", t);
			return t;
		} else {
			return (Transaction) session.getAttribute("Cart");
		}
	}

	@RequestMapping(method = RequestMethod.GET)
	protected ModelAndView cart(HttpSession session) {
		System.out.println("Total: "+getCart(session).getTotal());
		return new ModelAndView("panier", "panier", getCart(session));
	}
	
	@RequestMapping(value = "/add/{code}" , method = RequestMethod.GET)
	protected void addTraining(HttpSession session,
			@PathVariable("code") String code) {
		System.out.println("Cart/add/"+code);
		getCart(session).addTraining(tdbs.findTraining(code));
		//return cart(session);
	}
	
	@RequestMapping(value = "/increment/{code}" , method = RequestMethod.GET)
	protected ModelAndView incrementTraining(HttpSession session,
			@PathVariable("code") String code) {
		System.out.println("Cart/increment"+code);
		getCart(session).incrementTraining(tdbs.findTraining(code));
		return cart(session);
	}
	
	@RequestMapping(value = "/decrement/{code}" , method = RequestMethod.GET)
	protected ModelAndView decrementTraining(HttpSession session,
			@PathVariable("code") String code) {
		System.out.println("Cart/decrement"+code);
		getCart(session).decrementTraining(tdbs.findTraining(code));
		return cart(session);
	}

	@RequestMapping(value = "/remove/{code}", method = RequestMethod.GET)
	protected ModelAndView removeFromCart(HttpSession session,
			@PathVariable("code") String code) {
		System.out.println("Cart/remove"+code);
		getCart(session).removeTraining(tdbs.findTraining(code));
		return cart(session);
	}

	@RequestMapping(value = "/empty", method = RequestMethod.GET)
	protected ModelAndView emptyCart(HttpSession session) {
		getCart(session).empty();
		return cart(session);
	}

}
