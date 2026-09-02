package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.Enrollment;
import com.example.service.ICourseService;
import com.example.service.IEnrollmentService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet(name= "createEnrollmentServlet", value = "/enrollments/create")
public class CreateEnrollmentServlet extends HttpServlet{

    private IEnrollmentService enrollmentService;

    private ICourseService courseService;
    
    public void init() {
        
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        enrollmentService = (IEnrollmentService) context.getBean("enrollmentService");
                courseService = (ICourseService) context.getBean("courseService");


    }
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        

        resp.setContentType("text/html");

        PrintWriter out = resp. getWriter();

        out.println("<html><body>");

        out.println("<form method='post' action='"+req.getContextPath()+"/enrollments/create'>");
        out.println("name: <input type='text' name='name'> </input>");
        out.println("code: <input type='text' name='code'> </input>");
                out.println("courseId: <input type='text' name='courseId'> </input>");

                
       
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
        String code = req.getParameter("code");
        int courseId =  Integer.parseInt(req.getParameter("courseId"));


        Enrollment enrollment = new Enrollment(0, code, name,courseId);
    
     
        try {

        enrollmentService.save(enrollment);

        resp.sendRedirect(
            req.getContextPath() + "/enrollments/create"
        );

    } catch (IllegalArgumentException e) {

         resp.setContentType("text/html;charset=UTF-8");

    resp.getWriter().println(
        "<script>" +
        "alert('" + e.getMessage() + "');" +
        "window.location.href='" +
        req.getContextPath() +
        "/enrollments/create';" +
        "</script>"
    );
    }

    }



    


    



}
