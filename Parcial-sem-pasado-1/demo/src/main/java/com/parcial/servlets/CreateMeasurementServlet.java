package com.parcial.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.parcial.model.Measurement;
import com.parcial.service.IMeasurementService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name= "reateMeasurementServlet", value = "/createMeasurement")
public class CreateMeasurementServlet extends HttpServlet{


  private IMeasurementService measurementService;

    public void init(){

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        measurementService = (IMeasurementService) context.getBean("measurementService");

    }

    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException{

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        
        out.println("<h1>Crear Medicion</h1>");
       
        out.println("<form method='post' action='"+request.getContextPath()+"/createMeasurement'>");

        out.println("Timestamp: <input type='text' name='timestamp'> </input>");
        out.println("Value: <input type='text' name='value'> </input>");
        out.println("Device id: <input type='text' name='device_id'> </input>");

        out.println("<button type='submit'>GUARDAR</button>");

        out.println("</form>");

        out.println("</body></html>");


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException{

        long timestamp =Long.parseLong(request.getParameter("timestamp"));
        double value = Double.parseDouble(request.getParameter("value"));
        int deviceId = Integer.parseInt(request.getParameter("device_id"));

        Measurement measurement = new Measurement(0,timestamp,value,deviceId);

        measurementService.saveMeasurement(measurement);

        response.sendRedirect(request.getContextPath() + "/createMeasurement");





    }




    
}
