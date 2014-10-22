package fr.epf.lastminutetraining.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.epf.lastminutetraining.service.FormationDBService;

@SuppressWarnings("serial")
@WebServlet("/home")
public class DashboardController extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		FormationDBService service = FormationDBService.getInstance();

		// Get the dispatcher JSP
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/home.jsp");
		
		req.setAttribute("formations", service.findLastFormation());

		// Forward the request
		dispatcher.forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String name = req.getParameter("inputName");
		if(name==""||name==null){
			resp.sendRedirect("home");
			return;
		}

		FormationDBService service = FormationDBService.getInstance();
		
		//resp.sendRedirect("formation");
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/home.jsp");
		
		req.setAttribute("formations", service.findFormation(name));
		req.setAttribute("debug", req.getParameterMap().toString());

		// Forward the request
		dispatcher.forward(req, resp);
	}
}
