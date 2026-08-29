package com.parcial.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.parcial.model.Author;
import com.parcial.service.IAuthorService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "createAuthorServlet", value = "/createAuthor")
public class CreateAuthorServlet extends HttpServlet {

    private IAuthorService authorService;

    public void init() {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());

        authorService = (IAuthorService) context.getBean("authorService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Author> authors = authorService.listAll();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        out.print("<h1>CREAR AUTOR</h1>");
        out.print("<form method='post' action='" + request.getContextPath() + "/createAuthor'>");

        out.print("Nombre: <input type='text' name='name' required> </input>");
        out.print("<button type='submit'>GUARDAR</button>");
        out.print("</form>");

        out.print("</body></html>");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        Author author = new Author(0, name);

        Author prueba = authorService.saveAuthor(author);

        System.out.println(prueba.getId());

        response.sendRedirect(request.getContextPath() + "/createAuthor");

    }

}
