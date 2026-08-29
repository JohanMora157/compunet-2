package com.example.servlets;

import com.example.model.User;
import com.example.service.IUserService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private IUserService userService;

    @Override
    public void init() {

        WebApplicationContext context = WebApplicationContextUtils
                .getRequiredWebApplicationContext(
                        getServletContext());

        userService = context.getBean(
                "userServiceImpl",
                IUserService.class);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        List<User> users = userService.findAll();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "Usuarios" + "</h1>");
        for (User user : users) {
            out.println("<p>" + user.getName() + "<br>" + user.getEmail() + "<br>" + user.getPassword() + "</p>");
        }
        out.println("<h3>Registrar nuevo usuario!</h3>");
        out.println("<form method='post' action='" + request.getContextPath() + "/users'>");
        out.println("  Nombre: <input type='text' name='name' required /><br/>");
        out.println("  Email:  <input type='email' name='email' required /><br/><br/>");
        out.println("  password:  <input type='text' name='password' required /><br/><br/>");

        out.println("  <button type='submit'>Guardar</button>");
        out.println("</form>");
        out.println("</body></html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        User user = new User(0, name, email, password);
        User savedUser = userService.save(user);
        response.sendRedirect(request.getContextPath() + "/users");

    }

}