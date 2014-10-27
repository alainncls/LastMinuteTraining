package fr.epf.lastminutetraining.controller;

import fr.epf.lastminutetraining.service.VendorDBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/listVendors")
public class ListVendorsController {

    @Autowired
    private VendorDBService service;

    @RequestMapping(method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get the dispatcher JSP
        RequestDispatcher dispatcher = req
                .getRequestDispatcher("/WEB-INF/listVendors.jsp");
        //Put all the vendors from database into "vendors"
        req.setAttribute("vendors", service.findAllVendors());

        // Forward the request
        dispatcher.forward(req, resp);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {


        // resp.sendRedirect("formation");
        RequestDispatcher dispatcher = req
                .getRequestDispatcher("/WEB-INF/listVendors.jsp");

        // Forward the request
        dispatcher.forward(req, resp);
    }
}
