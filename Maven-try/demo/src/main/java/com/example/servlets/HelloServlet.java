package com.example.servlets;

import java.io.*;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.example.beans.MyFirstBean;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!aponza";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyFirstBean myFirstBean = (MyFirstBean) context.getBean("myFirstBean");

        String mensaje = myFirstBean.getMensaje();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("<h1>" + "desde el bean " + mensaje + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}