package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.Vehicle;
import com.example.service.IVehicleService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="createVehiclesServlet", value="/vehicles/create")
public class CreateVehiclesServlet extends HttpServlet {

    private IVehicleService vehicleService;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        vehicleService = (IVehicleService) context.getBean("vehicleService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.print("<h1>CREATE VEHICLE</h1>");

        out.println("<form method='post' action='"+req.getContextPath()+"/vehicles/create'>");
        out.println("Captain: <input type='text' name='Captain'> </input>");
        out.println("ClassType: <input type='text' name='ClassType'> </input>");
        out.println("CommissionDate: <input type='text' name='CommissionDate'> </input>");
        out.println("RegistryCode: <input type='text' name='RegistryCode'> </input>");
        out.println("Status: <input type='text' name='Status'> </input>");
        out.println("name: <input type='text' name='name'> </input>");
       
        out.println("<button type='submit'>GUARDAR</button>");
        out.println("</form>");

        out.println("<ul>");
        out.println("<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li> ");
        out.println("</ul>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Captain = req.getParameter("Captain");
        String ClassType = req.getParameter("ClassType");
        String CommissionDate = req.getParameter("CommissionDate");
        String RegistryCode = req.getParameter("RegistryCode");
        String Status = req.getParameter("Status");
        String name = req.getParameter("name");

        Vehicle vehicle = new Vehicle(Captain, ClassType, CommissionDate, RegistryCode, Status, 0, name);

        try {
            vehicleService.save(vehicle);
            resp.sendRedirect(req.getContextPath() + "/vehicles/create");
        } catch (IllegalArgumentException e) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println(
                "<script>" +
                "alert('" + e.getMessage() + "');" +
                "window.location.href='" +
                req.getContextPath() +
                "/vehicles/create';" +
                "</script>"
            );
        }
    }
}
