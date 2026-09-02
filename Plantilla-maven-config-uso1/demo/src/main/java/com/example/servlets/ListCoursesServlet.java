package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.Course;
import com.example.service.ICourseService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name= "listCoursesServlet", value = "/courses")
public class ListCoursesServlet extends HttpServlet{

    private ICourseService courseService;

    
    public void init() {
        
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        courseService = (ICourseService) context.getBean("courseService");

    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Course> courses = courseService.list();

        resp.setContentType("text/html");

        PrintWriter out = resp. getWriter();

        out.println("<html><body>");

        
        out.println("<h1>Lista Cursos</h1>");
        out.println("<ul>");
for(Course c: courses){

     out.println("<li>"+c.getName()+" - "+c.getMaxStudents()+" - "+c.getCode()+" - "+c.getId()+" - "+c.isActive()+"</li>");
}


        out.println("</ul>");

         out.println("<ul>");

        out.println("<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li> ");
        
        out.println("</ul>");

        out.println("</body></html>");
    }


    



}
