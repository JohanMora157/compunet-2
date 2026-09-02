package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.Enrollment;
import com.example.service.IEnrollmentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name= "listEnrollmentsServlet", value = "/enrollments")
public class ListEnrollmentsServlet extends HttpServlet{

    private IEnrollmentService enrollmentService;

    
    public void init() {
        
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        enrollmentService = (IEnrollmentService) context.getBean("enrollmentService");

    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        List<Enrollment> enrollments = enrollmentService.list();

        resp.setContentType("text/html");

        PrintWriter out = resp. getWriter();

        out.println("<html><body>");

        
        out.println("<h1>Lista Enrollments</h1>");
        out.println("<ul>");
for(Enrollment e: enrollments){

     out.println("<li>"+e.getStudentCode()+" - "+e.getStudentName()+" - "+e.getId()+"</li>");
}


        out.println("</ul>");

         out.println("<ul>");

        out.println("<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li> ");
        
        out.println("</ul>");

        out.println("</body></html>");
    }


    



}
