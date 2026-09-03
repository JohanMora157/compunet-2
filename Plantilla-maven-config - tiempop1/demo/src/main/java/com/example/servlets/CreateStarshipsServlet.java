package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.Starship;
import com.example.service.IStarshipService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="createStarshipsServlet",value="/starships/create")
public class CreateStarshipsServlet extends HttpServlet {


    
 private IStarshipService starshipService;

    
    public void init() {
        
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        starshipService = (IStarshipService) context.getBean("starshipService");

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp. getWriter();

        out.println("<html><body>");

        out.print("<h1>CREATE STARSHIP</h1>");


        out.println("<form method='post' action='"+req.getContextPath()+"/starships/create'>");
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

        out.println("</body></html>");    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String Captain = req.getParameter("Captain");
    String ClassType = req.getParameter("ClassType");
    String CommissionDate = req.getParameter("CommissionDate");
    String RegistryCode = req.getParameter("RegistryCode");
    String Status = req.getParameter("St    atus");
    String name = req.getParameter("name");


    //String Captain, String ClassType, String CommissionDate, String RegistryCode, String Status, int id, String name

    Starship starship = new Starship(Captain,ClassType,CommissionDate,RegistryCode,Status,0,name);

    starshipService.save(starship);


        resp.sendRedirect(req.getContextPath()+"/starships/create");
    }


    
}
