package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.MechanicVisit;
import com.example.service.IMechanicVisitService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="createMechanicVisitsServlet", value="/mechanicvisits/create")
public class CreateMechanicVisitsServlet extends HttpServlet {

    private IMechanicVisitService mechanicVisitService;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        mechanicVisitService = (IMechanicVisitService) context.getBean("mechanicVisitService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.print("<h1>CREATE MECHANIC VISIT</h1>");

        out.println("<form method='post' action='"+req.getContextPath()+"/mechanicvisits/create'>");
        out.println("Description: <input type='text' name='Description'> </input>");
        out.println("LogCode: <input type='text' name='LogCode'> </input>");
        out.println("Sector: <input type='text' name='Sector'> </input>");
        out.println("StarDate: <input type='text' name='StarDate'> </input>");
        out.println("VehicleId: <input type='text' name='VehicleId'> </input>");
        out.println("ThreatLevel: <input type='text' name='ThreatLevel'> </input>");
        out.println("Title: <input type='text' name='Title'> </input>");                
       
        out.println("<button type='submit'>GUARDAR</button>");
        out.println("</form>");

        out.println("<ul>");
        out.println("<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li> ");
        out.println("</ul>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String Description = req.getParameter("Description");
        String LogCode = req.getParameter("LogCode");
        String Sector = req.getParameter("Sector");
        String StarDate = req.getParameter("StarDate");
        String Title = req.getParameter("Title");
        int VehicleId = Integer.parseInt(req.getParameter("VehicleId"));
        int ThreatLevel = Integer.parseInt(req.getParameter("ThreatLevel"));

        MechanicVisit mechanicVisit = new MechanicVisit(Description, LogCode, Sector, StarDate, VehicleId, ThreatLevel, Title, 0);

        try {
            mechanicVisitService.save(mechanicVisit);
            resp.sendRedirect(req.getContextPath() + "/mechanicvisits/create");
        } catch (IllegalArgumentException e) {
            resp.setContentType("text/html;charset=UTF-8");
            resp.getWriter().println(
                "<script>" +
                "alert('" + e.getMessage() + "');" +
                "window.location.href='" +
                req.getContextPath() +
                "/mechanicvisits/create';" +
                "</script>"
            );
        }
    }
}
