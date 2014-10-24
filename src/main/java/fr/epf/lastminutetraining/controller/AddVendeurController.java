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

import fr.epf.lastminutetraining.domain.Vendeur;
import fr.epf.lastminutetraining.service.VendeurDBService;

@RequestMapping("/addVendeur")
@Controller
public class AddVendeurController {
	@Autowired
	private VendeurDBService service;
	
	@RequestMapping(method = RequestMethod.GET)
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		// Get the dispatcher JSP
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/addVendeur.jsp");

		// Forward the request
		dispatcher.forward(req, resp);
	}

	@RequestMapping(method = RequestMethod.POST)
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// Get data from form
		String nom = (String) req.getParameter("nom");
		String avatar = (String) req.getParameter("avatar");
		String mail = (String) req.getParameter("mail");
		String telephone = (String) req.getParameter("tel");
		String marge = (String) req.getParameter("marge");
		String abonnement = (String) req.getParameter("abonnement");
		String adresse = (String)req.getParameter("adresse");
		String ville = (String) req.getParameter("ville");
		String code_postal = (String) req.getParameter("cp");
		String iban = (String) req.getParameter("iban");

		Vendeur vendeur = Vendeur.builder().nom(nom).avatar(avatar)
				.mail(mail).telephone(telephone).marge(marge).abonnement(abonnement)
				.adresse(adresse).ville(ville).codePostal(code_postal).iban(iban).build();

		// Persist the formation
		service.save(vendeur);

		resp.sendRedirect("addVendeur");
	}
}