package com.parcial.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.parcial.model.Author;
import com.parcial.model.Post;
import com.parcial.service.*;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "postListServlet", value = "/posts")
public class PostListServlet extends HttpServlet {

    private IPostService postService;

    public void init() {
        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());

        postService = (IPostService) context.getBean("postService");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<Post> posts = postService.listAll();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.print("<html><body>");
        out.println("<ul>");

        for (Post post : posts) {

            out.print("<li>" + post.getId() + " - " + post.getTitle() + " - " + post.getContent() + " - Author: "
                    + post.getAuthor().getName() + " - " + post.getAuthor().getId() + "</li>");

        }
        out.println("</ul>");

        out.print("</body></html>");

    }

}
