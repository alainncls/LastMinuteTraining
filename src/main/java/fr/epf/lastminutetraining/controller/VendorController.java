package fr.epf.lastminutetraining.controller;

import fr.epf.lastminutetraining.domain.Vendor;
import fr.epf.lastminutetraining.service.VendorDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Baptiste on 28/10/2014.
 */
@Controller
public class VendorController {

    @Autowired
    private VendorDBService service;

    @RequestMapping(method = RequestMethod.GET, value = "/addVendor")
    protected ModelAndView addTraining(){ return new ModelAndView("addVendor"); }

    @RequestMapping(method = RequestMethod.GET, value = "/listVendors")
    protected ModelAndView listTrainings(){ return new ModelAndView("listVendors", "vendors", service.findAllVendors()); }

    @RequestMapping(method = RequestMethod.POST, value = "/addVendor")
    protected void createTraining(@ModelAttribute("vendor")Vendor vendor){
        service.save(vendor);
    }
}
