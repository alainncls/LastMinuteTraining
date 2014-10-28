package fr.epf.lastminutetraining.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	// methode pour log out
	@RequestMapping(method = RequestMethod.GET, value = "/logout")
	protected void logout(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		session.invalidate();
		resp.sendRedirect("home");
	}

	// Methode pour login de compte
	@RequestMapping(method = RequestMethod.POST, value = "/login")
	protected void login(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Get data from form
		HttpSession session = req.getSession();
		session.setAttribute("login", req.getParameter("login"));
		session.setAttribute("password", req.getParameter("password"));
		session.setAttribute("status", "vendor");
		
		resp.sendRedirect("home");

	}

	// Methode pour creation de compte
	@RequestMapping(method = RequestMethod.POST, value = "/register")
	protected void register(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Get data from form
		// emailNew
		// loginNew
		// passwordNew
		// passwordSecondNew
		HttpSession session = req.getSession();
		session.setAttribute("login", req.getParameter("login"));
		session.setAttribute("login", req.getParameter("password"));

		resp.sendRedirect("home");

	}

}
