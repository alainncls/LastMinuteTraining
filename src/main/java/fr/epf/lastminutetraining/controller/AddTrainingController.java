package fr.epf.lastminutetraining.controller;

import fr.epf.lastminutetraining.domain.Training;
import fr.epf.lastminutetraining.service.TrainingDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequestMapping("/addTraining")
@Controller
public class AddTrainingController {
    @Autowired
    private TrainingDBService service;

    @RequestMapping(method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get the dispatcher JSP
        RequestDispatcher dispatcher = req
                .getRequestDispatcher("/WEB-INF/addTraining.jsp");

        // Forward the request
        dispatcher.forward(req, resp);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Get data from form
        String name = (String) req.getParameter("name");
        String price = (String) req.getParameter("price");
        String priceLMT = (String) req.getParameter("priceLMT");
        String startDate = (String) req.getParameter("dates.date");
        String endDate = (String) req.getParameter("endDate");
        String difficulty = (String) req.getParameter("level");
        String description = (String) req.getParameter("description");
        String prerequis = (String) req.getParameter("prerequis");
        //Build the training object
        Training training = Training.builder().name(name).price(price)
                .priceLMT(priceLMT).startDate(startDate).endDate(endDate)
                .difficulty(difficulty).description(description)
                .prerequis(prerequis).build();

        // Persist the training
        service.save(training);

        resp.sendRedirect("addTraining");
    }
}