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

import fr.epf.lastminutetraining.service.VendeurDBService;

@Controller
@RequestMapping("/listVendeurs")
public class ListVendeursController {

	@Autowired
	private VendeurDBService service;

	@RequestMapping(method = RequestMethod.GET)
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Get the dispatcher JSP
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/listVendeurs.jsp");

		req.setAttribute("vendeurs", service.findAllVendeurs());

		// Forward the request
		dispatcher.forward(req, resp);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		
		// resp.sendRedirect("formation");
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/listVendeurs.jsp");

		// Forward the request
		dispatcher.forward(req, resp);
	}
}
