package fr.epf.lastminutetraining.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.lastminutetraining.dao.FormationDAO;
import fr.epf.lastminutetraining.domain.Formation;
import fr.epf.lastminutetraining.service.FormationDBService;

@SuppressWarnings("serial")
@WebServlet("/addFormation")
public class AddFormationController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Get the dispatcher JSP
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/addFormation.jsp");

		// Forward the request
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Get data from form
		String name = (String) req.getParameter("name");
		int price = Integer.parseInt(req.getParameter("price"));
		int priceLMT = Integer.parseInt(req.getParameter("priceLMT"));
		String startDate = (String) req.getParameter("startDate");
		String endDate = (String) req.getParameter("endDate");
		Long difficulty = Long.parseLong(req.getParameter("difficulty"));
		String description = (String) req.getParameter("description");
		String prerequis = (String)req.getParameter("prerequis");
		
		Formation formation = Formation.builder().name(name).price(price).priceLMT(priceLMT).startDate(startDate).endDate(endDate).difficulty(difficulty).description(description).prerequis(prerequis).build();

		FormationDBService service = FormationDBService.getInstance();
		
		//Persist the formation
		service.create(formation);
		
		resp.sendRedirect("addFormation");
	}
}