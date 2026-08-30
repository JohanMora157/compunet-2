package com.parcial.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.parcial.model.Measurement;
import com.parcial.service.IMeasurementService;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name= "listMeasurementsServlet", value = "/listMeasurements")
public class ListMeasurementsServlet extends HttpServlet{


    private IMeasurementService measurementService;

    public void init(){

        WebApplicationContext context = WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());

        measurementService = (IMeasurementService) context.getBean("measurementService");

    }


    public void doGet(HttpServletRequest request, HttpServletResponse response ) throws IOException{


        List<Measurement> measurements = measurementService.listAll();

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><body>");

        
        out.println("<h1>Mediciones</h1>");

        for(Measurement measurement : measurements){
        out.println("<li>" + measurement.getId() + " - " + measurement.getTimestamp() + " - " + measurement.getValue() + " - " + measurement.getDeviceId() + " - " + "</li>");
        }

        
        out.println("</ul>");

        out.println("</body></html>");

        


    }




    
}
