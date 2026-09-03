package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.Starship;
import com.example.service.IStarshipService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name= "listStarshipsServlet", value="/starships")
public class ListStarshipsServlet extends HttpServlet{


 private IStarshipService starshipService;

    
    public void init() {
        
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        starshipService = (IStarshipService) context.getBean("starshipService");

    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
List<Starship> starList = starshipService.list();

   resp.setContentType("text/html");

        PrintWriter out = resp. getWriter();

        out.println("<html><body>");

        
        out.println("<h1>List StarShips</h1>");
        out.println("<ul>");
for(Starship s: starList){

     out.println("<li>"+s.toString()+"</li>");
}


        out.println("</ul>");

         out.println("<ul>");

        out.println("<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li> ");
        
        out.println("</ul>");

        out.println("</body></html>");



    
    }



    
     
    
}
