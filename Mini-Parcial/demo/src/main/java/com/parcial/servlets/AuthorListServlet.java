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

@WebServlet(name = "authorListServlet", value = "/authors")
public class AuthorListServlet extends HttpServlet {

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
        out.println("<ul>");

        for (Author author : authors) {

            out.print("<li>" + author.getId() + "-" + author.getName() + "</li>");

        }
        out.println("</ul>");

        out.print("</body></html>");

    }

}
