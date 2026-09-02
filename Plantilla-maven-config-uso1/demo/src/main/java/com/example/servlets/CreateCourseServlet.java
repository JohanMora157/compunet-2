package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.Course;
import com.example.service.ICourseService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name= "createCourseServlet", value = "/courses/create")
public class CreateCourseServlet extends HttpServlet{

    private ICourseService courseService;

    
    public void init() {
        
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        courseService = (ICourseService) context.getBean("courseService");

    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        resp.setContentType("text/html");

        PrintWriter out = resp. getWriter();

        out.println("<html><body>");

        out.println("<form method='post' action='"+req.getContextPath()+"/courses/create'>");
        out.println("name: <input type='text' name='name'> </input>");
        out.println("max students: <input type='text' name='maxStudents'> </input>");
        out.println("code: <input type='text' name='code'> </input>");
        out.println("activo?: <input type='checkbox' name='activo' value='true'> </input>");
                
       
  out.println("<button type='submit'>GUARDAR</button>");

        out.println("</form>");

        out.println("<ul>");

        out.println("<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li> ");
        
        out.println("</ul>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
        String name = req.getParameter("name");
        int maxStudents = Integer.parseInt(req.getParameter("maxStudents"));
        String code = req.getParameter("code");
        boolean active = Boolean.parseBoolean(req.getParameter("activo"));


        Course course = new Course(active, code, maxStudents, maxStudents, name);

        courseService.save(course);

        resp.sendRedirect(req.getContextPath()+"/courses/create");


    }



    


    



}
