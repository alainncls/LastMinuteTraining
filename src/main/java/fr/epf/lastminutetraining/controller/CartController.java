package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
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
public class CartController {

	@Autowired
	TrainingDBService tdbs;
	@Autowired
	ClientDBService cdbs;
	Transaction cart;

	protected Transaction getCart(HttpSession session) {
		if (null == session.getAttribute("Cart")) {
			System.out.println("DEPUIS CARTCONTROLLER : " + new ObjectId(session.getAttribute("id").toString()));
			Client c = cdbs.findClient(new ObjectId(session.getAttribute("id")
					.toString()));
			return TransactionBuilder.transaction().client(c).build();
		} else {
			return (Transaction) session.getAttribute("Cart");
		}
	}

	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	protected ModelAndView cart(HttpSession session) {
		return new ModelAndView("panier", "panier", getCart(session));
	}

	@RequestMapping(value = { "/cart/increment", "/cart/add" }, method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	protected @ResponseBody boolean incrementTraining(HttpSession session,
			@RequestParam("idTraining") String idTraining) {
		getCart(session).addTraining(tdbs.findTraining(idTraining));
		return true;
	}

	@RequestMapping(value = "/cart/decrement", method = RequestMethod.POST)
	protected boolean decrementTraining(HttpSession session,
			@RequestParam("idTraining") String idTraining) {
		getCart(session).removeTraining(tdbs.findTraining(idTraining));
		return true;
	}

	@RequestMapping(value = "/cart/remove", method = RequestMethod.POST)
	protected boolean removeFromCart(HttpSession session,
			@RequestParam("idTraining") String idTraining) {
		getCart(session).removeTraining(tdbs.findTraining(idTraining));
		return true;
	}

	@RequestMapping(value = "/cart/empty", method = RequestMethod.POST)
	protected boolean emptyCart(HttpSession session) {
		getCart(session).empty();
		return true;
	}

}
