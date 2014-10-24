package fr.epf.lastminutetraining.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import fr.epf.lastminutetraining.domain.Formation;
import fr.epf.lastminutetraining.service.FormationDBService;

@RequestMapping("/addFormation")
@Controller
public class AddFormationController {
	@Autowired
	private FormationDBService service;
	
	@RequestMapping(method = RequestMethod.GET)
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Get the dispatcher JSP
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/addFormation.jsp");

		// Forward the request
		dispatcher.forward(req, resp);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Get data from form
		String name = (String) req.getParameter("name");
		String price = (String) req.getParameter("price");
		String priceLMT = "";//(int) (price - price*(0.2));//Integer.parseInt(req.getParameter("priceLMT"));
		String startDate = (String) req.getParameter("dates.date");
		String endDate = "";//(String) req.getParameter("endDate");
		String difficulty = (String) req.getParameter("level");
		String description = (String)req.getParameter("description");//(String) req.getParameter("description").replaceAll("\\u([0-9a-f]{3,4})","");
		String prerequis = "";//(String) req.getParameter("prerequis");

		Formation formation = Formation.builder().name(name).price(price)
				.priceLMT(priceLMT).startDate(startDate).endDate(endDate)
				.difficulty(difficulty).description(description)
				.prerequis(prerequis).build();

		// Persist the formation
		service.save(formation);

		resp.sendRedirect("addFormation");
	}
}