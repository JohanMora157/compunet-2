package com.parcial.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<html><body>");

        out.print("<h1>OPCIONES</h1>");

        out.println("<ul>");
        out.println(
                "<li>1. Listado de Autores <a href='http://localhost:8080/demo/authors'><button type='button'>Ir</button></a></li>");
        out.println(
                "<li>2. Crear Autor <a href='http://localhost:8080/demo/createAuthor'><button type='button'>Ir</button></a></li>");
        out.println(
                "<li>3. Listado de Posts <a href='http://localhost:8080/demo/posts'><button type='button'>Ir</button></a></li>");
        out.println(
                "<li>4. Crear post <a href='http://localhost:8080/demo/createPost'><button type='button'>Ir</button></a></li>");

        out.println("</ul>");

        out.print("</body></html>");

    }

}
