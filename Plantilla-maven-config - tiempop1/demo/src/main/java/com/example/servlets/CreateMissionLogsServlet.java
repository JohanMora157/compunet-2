package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.MissionLog;
import com.example.service.IMissionLogService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet(name="createMissionLogsServlet",value="/missionlogs/create")
public class CreateMissionLogsServlet extends HttpServlet {


  private IMissionLogService missionLogService;

    
    public void init() {
        
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        missionLogService = (IMissionLogService) context.getBean("missionLogService");

    }
    

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp. getWriter();

        out.println("<html><body>");

        out.print("<h1>CREATE MISSIONLOGS</h1>");

        //String Description, String LogCode, String Sector, String StarDate, int StarshipId, int ThreatLevel, String Title, int id

        out.println("<form method='post' action='"+req.getContextPath()+"/missionlogs/create'>");
        out.println("Description: <input type='text' name='Description'> </input>");
        out.println("LogCode: <input type='text' name='LogCode'> </input>");
        out.println("Sector: <input type='text' name='Sector'> </input>");
        out.println("StarDate: <input type='text' name='StarDate'> </input>");
        out.println("StarshipId: <input type='text' name='StarshipId'> </input>");
        out.println("ThreatLevel: <input type='text' name='ThreatLevel'> </input>");
        out.println("Title: <input type='text' name='Title'> </input>");                
       
  out.println("<button type='submit'>GUARDAR</button>");

        out.println("</form>");

        out.println("<ul>");

        out.println("<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li> ");
        
        out.println("</ul>");

        out.println("</body></html>");    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String Description = req.getParameter("Description");
    String LogCode = req.getParameter("LogCode");
    String Sector = req.getParameter("Sector");
    String StarDate = req.getParameter("StarDate");
    String Title = req.getParameter("Title");
    int StarshipId = Integer.parseInt(req.getParameter("StarshipId"));
    int ThreatLevel = Integer.parseInt(req.getParameter("ThreatLevel"));


//String Description, String LogCode, String Sector, String StarDate, int StarshipId, int ThreatLevel, String Title, int id
    MissionLog missionLog = new MissionLog(Description,LogCode,Sector,StarDate,StarshipId,ThreatLevel,Title,0);



     try {

    missionLogService.save(missionLog);

        resp.sendRedirect(
            req.getContextPath() + "/missionlogs/create"
        );

    } catch (IllegalArgumentException e) {

         resp.setContentType("text/html;charset=UTF-8");

    resp.getWriter().println(
        "<script>" +
        "alert('" + e.getMessage() + "');" +
        "window.location.href='" +
        req.getContextPath() +
        "/missionlogs/create';" +
        "</script>"
    );
    }
    }


    
}
