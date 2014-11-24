package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Client;
import fr.epf.lastminutetraining.domain.User;
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
		ObjectId id = new ObjectId(session.getAttribute("id").toString());

		if (session.getAttribute("status").toString().equals("vendor")) {
			return new ModelAndView("myaccount", "currentUser",
					vservice.findVendor(id));
		} else if (session.getAttribute("status").toString().equals("client")) {
			return new ModelAndView("myaccount", "currentUser",
					cservice.findClient(id));
		} else {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/myaccount")
	protected ModelAndView updateAccount(HttpSession session,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) String iban,
			@RequestParam(required = false) String firstName,
			@RequestParam(required = false) String lastName,
			@RequestParam(required = false) String address,
			@RequestParam(required = false) String town,
			@RequestParam(required = false) String cp,
			@RequestParam(required = false) String mail,
			@RequestParam(required = false) String phone,
			@RequestParam(required = false) String bank,
			@RequestParam(required = false) String cardNumber,
			@RequestParam(required = false) String expirationDate) {

		ObjectId id = new ObjectId(session.getAttribute("id").toString());

		if (session.getAttribute("status").toString().equals("vendor")) {
			Vendor vendor = vservice.findVendor(id);
			vendor.setId(id);
			vendor.setName(name);
			vendor.setAddress(address);
			vendor.setTown(town);
			vendor.setCp(cp);
			vendor.setMail(mail);
			vendor.setPhone(phone);
			vendor.setIban(iban);

			if ((vendor.getName() == "") || (vendor.getSub() == "")
					|| (vendor.getIban() == "") || (vendor.getAddress() == "")
					|| (vendor.getCp() == "") || (vendor.getTown() == "")
					|| (vendor.getMail() == "") || (vendor.getPhone() == "")) {

				vendor.setActivated(false);
				session.setAttribute("validated", "false");
			} else {
				vendor.setActivated(true);
				session.setAttribute("validated", "true");
			}

			vservice.update(vendor);
			return new ModelAndView("myaccount", "currentUser", vendor);
		} else if (session.getAttribute("status").toString().equals("client")) {
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
		} else {
			return null;
		}
	}

	@RequestMapping(method = RequestMethod.POST, value = "/myaccount/editPwd")
	protected ModelAndView editPwd(HttpSession session,
			@RequestParam(required = false) String oldPass,
			@RequestParam(required = false) String newPass,
			@RequestParam(required = false) String newPass2) {

		ObjectId id = new ObjectId(session.getAttribute("id").toString());

		if (session.getAttribute("status").toString().equals("vendor")) {
			Vendor vendor = vservice.findVendor(id);
			vendor.setId(id);

			String testPass = User.encrypt(oldPass);
			if (newPass.equals(newPass2)) {
				if (testPass.equals(vendor.getPassword())) {
					vendor.setPassword(newPass);
					vservice.update(vendor);
				}
			}

			return new ModelAndView("redirect:/myaccount", "currentUser",
					vendor);

		} else if (session.getAttribute("status").toString().equals("client")) {
			Client client = cservice.findClient(id);
			client.setId(id);

			String testPass = User.encrypt(oldPass);
			if (newPass.equals(newPass2)) {
				if (testPass.equals(client.getPassword())) {
					client.setPassword(newPass);
					cservice.update(client);
				}
			}
			return new ModelAndView("redirect:/myaccount", "currentUser",
					client);
		} else {
			return null;
		}

	}

	@RequestMapping(method = RequestMethod.GET, value = "/myaccount/editPwd")
	protected ModelAndView editPwd(HttpSession session) {

		ObjectId id = new ObjectId(session.getAttribute("id").toString());

		if (session.getAttribute("status").toString().equals("vendor")) {
			Vendor vendor = vservice.findVendor(id);
			vendor.setId(id);
			return new ModelAndView("redirect:/myaccount", "currentUser",
					vendor);
		} else if (session.getAttribute("status").toString().equals("client")) {
			Client client = cservice.findClient(id);
			client.setId(id);
			return new ModelAndView("redirect:/myaccount", "currentUser",
					client);
		} else {
			return null;
		}
	}
}
