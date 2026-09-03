package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.Vehicle;
import com.example.service.IVehicleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="listVehiclesServlet", value="/vehicles")
public class ListVehiclesServlet extends HttpServlet {

    private IVehicleService vehicleService;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        vehicleService = (IVehicleService) context.getBean("vehicleService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Vehicle> vehicleList = vehicleService.list();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h1>List Vehicles</h1>");
        out.println("<ul>");
        for (Vehicle v : vehicleList) {
            out.println("<li>" + v.toString() + "</li>");
        }
        out.println("</ul>");

        out.println("<ul>");
        out.println("<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li> ");
        out.println("</ul>");

        out.println("</body></html>");
    }
}
