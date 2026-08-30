package com.parcial.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name= "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet{


    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        
        out.println("<h1>MENU</h1>");
        out.println("<ul>");

        out.println("<li>Crear medicion <a href='http://localhost:8080/demo/createMeasurement'><button type='button'>Ir</button></a></li> ");
        out.println("<li>Listar mediciones <a href='http://localhost:8080/demo/listMeasurements'><button type='button'>Ir</button></a></li>");
        
        out.println("</ul>");

        out.println("</body></html>");

        


    }




    
}
