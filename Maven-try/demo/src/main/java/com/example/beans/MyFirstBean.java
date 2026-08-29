package com.example.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("myFirstBean")
@Scope("singleton")
public class MyFirstBean {

    @Value("Hola desde Spring con Anotaciones! - Proyecto Fitness App") // not necessary if we use
                                                                        // applicationContext.xml
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}