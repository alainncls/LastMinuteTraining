package fr.epf.lastminutetraining.controller;

import javax.servlet.http.HttpSession;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.epf.lastminutetraining.domain.Vendor;
import fr.epf.lastminutetraining.service.VendorDBService;

@Controller
public class MyAccountController {

	@Autowired
	private VendorDBService vservice;

	@RequestMapping(method = RequestMethod.GET, value = "/myaccount")
	protected ModelAndView show(HttpSession session) {
		ObjectId id = new ObjectId(session.getAttribute("id").toString());
		return new ModelAndView("myaccount", "currentUser",
				vservice.findVendor(id));
	}

	@RequestMapping(method = RequestMethod.POST, value = "/myaccount")
	protected ModelAndView updateVendor(HttpSession session,
			@ModelAttribute("vendor") Vendor vendor){

		ObjectId id = new ObjectId(session.getAttribute("id").toString());
		vendor.setId(id);
		vservice.update(vendor);
		return new ModelAndView("myaccount", "currentUser", vendor);
	}
}
