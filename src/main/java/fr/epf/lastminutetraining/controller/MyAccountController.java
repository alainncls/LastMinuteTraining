package fr.epf.lastminutetraining.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MyAccountController {

    @RequestMapping(method = RequestMethod.GET, value = "/myaccount")
    protected ModelAndView home(){ return new ModelAndView("myaccount"); }

}
