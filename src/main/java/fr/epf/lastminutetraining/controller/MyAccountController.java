package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Client;
import fr.epf.lastminutetraining.domain.Vendor;
import fr.epf.lastminutetraining.service.ClientDBService;
import fr.epf.lastminutetraining.service.VendorDBService;

@Controller
public class MyAccountController {

	@Autowired
	private VendorDBService vservice;
	@Autowired
	private ClientDBService cservice;

	@RequestMapping(method = RequestMethod.GET, value = "/myaccount")
	protected ModelAndView show(HttpSession session) {
		ObjectId id = new ObjectId(session.getAttribute("id").toString());System.out.println(id);
		
		if (session.getAttribute("status").toString().equals("vendeur")){
			return new ModelAndView("myaccount", "currentUser",
				vservice.findVendor(id));
		}
		else if (session.getAttribute("status").toString().equals("client")){
			return new ModelAndView("myaccount", "currentUser",
				cservice.findClient(id));
		}
		else{
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/myaccount")
	protected ModelAndView updateAccount(HttpSession session,
			@ModelAttribute("vendor") Vendor vendor,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("address") String address,
			@RequestParam("town") String town,
			@RequestParam("cp") String cp,
			@RequestParam("mail") String mail,
			@RequestParam("phone") String phone,
			@RequestParam("bank") String bank,
			@RequestParam("cardNumber") String cardNumber,
			@RequestParam("expirationDate") String expirationDate){

		ObjectId id = new ObjectId(session.getAttribute("id").toString());
		
		if (session.getAttribute("status").toString().equals("vendeur")){
			vendor.setId(id);
			vservice.update(vendor);
			return new ModelAndView("myaccount", "currentUser", vendor);
		}
		else if (session.getAttribute("status").toString().equals("client")){
			Client client = cservice.findClient(id);
			client.setFirstName(firstName);
			client.setLastName(lastName);
			client.setAddress(address);
			client.setAddress(address);
			client.setTown(town);
			client.setCp(cp);
			client.setMail(mail);
			client.setPhone(phone);
			client.setBank(bank);
			client.setCardNumber(cardNumber);
			client.setExpirationDate(expirationDate);
			client.setId(id);
			cservice.update(client);
			return new ModelAndView("myaccount", "currentUser", client);
		}
		else{
			return null;
		}
	}
}
