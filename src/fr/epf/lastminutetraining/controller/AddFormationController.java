package fr.epf.lastminutetraining.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		short difficulty = Short.parseShort(req.getParameter("difficulty"));
		
		FormationDAO formation = FormationDAO.builder().name(name).price(price).priceLMT(priceLMT).startDate(startDate).endDate(endDate).difficulty(difficulty).build();

		FormationDBService service = FOrmationDBService.getInstance();
		
		//Persist the computer
		service.create(formation);
		
		resp.sendRedirect("main");
	}
}