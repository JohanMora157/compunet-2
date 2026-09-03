package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name= "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");
        PrintWriter out = resp. getWriter();

        out.println("<html><body>");

        
        out.println("<h1>MENU</h1>");
        out.println("<ul>");

        out.println("<li>List Starships <a href='http://localhost:8080/demo/starships'><button type='button'>Ir</button></a></li> ");
        out.println("<li>List MissionLogs <a href='http://localhost:8080/demo/missionlogs'><button type='button'>Ir</button></a></li>");
                out.println("<li>Create Starships <a href='http://localhost:8080/demo/missionlogs/create'><button type='button'>Ir</button></a></li>");
        out.println("<li>Create MissionLogs <a href='http://localhost:8080/demo/starships/create'><button type='button'>Ir</button></a></li>");

        out.println("</ul>");

        out.println("</body></html>");

      
    }




    


    
    
}