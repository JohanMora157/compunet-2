package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.MechanicVisit;
import com.example.service.IMechanicVisitService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="listMechanicVisitsServlet", value="/mechanicvisits")
public class ListMechanicVisitsServlet extends HttpServlet {

    private IMechanicVisitService mechanicVisitService;

    @Override
    public void init() {
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
        mechanicVisitService = (IMechanicVisitService) context.getBean("mechanicVisitService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<MechanicVisit> visits = mechanicVisitService.list();

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        out.println("<html><body>");
        out.println("<h1>List Mechanic Visits</h1>");
        out.println("<ul>");
        for (MechanicVisit m : visits) {
            out.println("<li>" + m.toString() + "</li>");
        }
        out.println("</ul>");

        out.println("<ul>");
        out.println("<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li> ");
        out.println("</ul>");

        out.println("</body></html>");
    }
}
