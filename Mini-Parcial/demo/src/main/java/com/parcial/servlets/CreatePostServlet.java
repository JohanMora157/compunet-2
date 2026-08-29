package com.parcial.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.parcial.model.*;

import com.parcial.service.IAuthorService;
import com.parcial.service.IPostService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "createPostServlet", value = "/createPost")
public class CreatePostServlet extends HttpServlet {

    private IPostService postService;

    public void init() {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());

        postService = (IPostService) context.getBean("postService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        out.print("<h1>CREAR POST</h1>");
        out.print("<form method='post' action='" + request.getContextPath() + "/createPost'>");

        out.print("Titulo: <input type='text' name='title' required> </input>");
        out.print("Contenido: <input type='text' name='content' required> </input>");
        out.print("Id autor: <input type='number' name='id_author' required> </input>");

        out.print("<button type='submit'>GUARDAR</button>");
        out.print("</form>");

        out.print("</body></html>");

    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String title = request.getParameter("title");
        String content = request.getParameter("content");
        int id = Integer.parseInt(request.getParameter("id_author"));

        Post post = new Post(0, title, content);
        postService.savePost(post, id);

        response.sendRedirect(request.getContextPath() + "/createPost");

    }

}
