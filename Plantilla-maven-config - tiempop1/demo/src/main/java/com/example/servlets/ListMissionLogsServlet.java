package com.example.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.example.model.MissionLog;
import com.example.service.IMissionLogService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name= "listMissionLogsServlet", value="/missionlogs")
public class ListMissionLogsServlet extends HttpServlet{


 private IMissionLogService missionLogService;

    
    public void init() {
        
        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        missionLogService = (IMissionLogService) context.getBean("missionLogService");

    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    
List<MissionLog> missionLogs = missionLogService.list();

   resp.setContentType("text/html");

        PrintWriter out = resp. getWriter();

        out.println("<html><body>");

        
        out.println("<h1>List MissionLogs</h1>");
        out.println("<ul>");
for(MissionLog m: missionLogs){

     out.println("<li>"+m.toString()+"</li>");
}


        out.println("</ul>");

         out.println("<ul>");

        out.println("<li>Home <a href='http://localhost:8080/demo/home'><button type='button'>Ir</button></a></li> ");
        
        out.println("</ul>");

        out.println("</body></html>");



    
    }



    
     
    
}
