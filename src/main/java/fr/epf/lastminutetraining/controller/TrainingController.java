package fr.epf.lastminutetraining.controller;

import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.service.TrainingDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by Baptiste on 28/10/2014.
 */

@Controller
public class TrainingController {

    @Autowired
    private TrainingDBService service;

    @RequestMapping(method = RequestMethod.GET, value = "/addTraining")
    protected ModelAndView addTraining(){ return new ModelAndView("addTraining"); }

    @RequestMapping(method = RequestMethod.GET, value = "/listTrainings")
    protected ModelAndView listTrainings(){ return new ModelAndView("listTrainings", "trainings", service.findAllTrainings()); }

    @RequestMapping(method = RequestMethod.POST, value = "/addTraining")
    protected void createTraining(@ModelAttribute("training")Training training){
        service.save(training);
    }
}
