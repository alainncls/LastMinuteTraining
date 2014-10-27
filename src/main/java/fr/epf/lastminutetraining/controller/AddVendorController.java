package fr.epf.lastminutetraining.controller;

import fr.epf.lastminutetraining.domain.Vendor;
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

@RequestMapping("/addVendor")
@Controller
public class AddVendorController {
    @Autowired
    private VendorDBService service;

    @RequestMapping(method = RequestMethod.GET)
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // Get the dispatcher JSP
        RequestDispatcher dispatcher = req
                .getRequestDispatcher("/WEB-INF/addVendor.jsp");

        // Forward the request
        dispatcher.forward(req, resp);
    }

    @RequestMapping(method = RequestMethod.POST)
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Get data from form
        String name = (String) req.getParameter("name");
        String avatar = (String) req.getParameter("avatar");
        String mail = (String) req.getParameter("mail");
        String phone = (String) req.getParameter("phone");
        String margin = (String) req.getParameter("margin");
        String sub = (String) req.getParameter("sub");
        String address = (String) req.getParameter("address");
        String town = (String) req.getParameter("town");
        String cp = (String) req.getParameter("cp");
        String iban = (String) req.getParameter("iban");
        //Build vendor object
        Vendor vendor = Vendor.builder().name(name).avatar(avatar)
                .mail(mail).phone(phone).margin(margin).sub(sub)
                .address(address).town(town).cp(cp).iban(iban).build();

        // Persist the formation
        service.save(vendor);

        resp.sendRedirect("addVendor");
    }
}