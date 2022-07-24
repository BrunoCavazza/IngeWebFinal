package ar.edu.iua.webServices;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

import ar.edu.iua.Excepciones.web_services_ex.*;
import ar.edu.iua.webServices.Controladores.plan.BorrarPlanHandler;
import ar.edu.iua.webServices.Controladores.plan.BorrarPlanesHandler;
import ar.edu.iua.webServices.Controladores.plan.BuscarPlanHandler;
import ar.edu.iua.webServices.Controladores.plan.BuscarPlanesHandler;
import ar.edu.iua.webServices.Controladores.plan.CrearPlanHandler;
import ar.edu.iua.webServices.Controladores.plan.CrearPlanesHandler;
import ar.edu.iua.webServices.Controladores.plan.ModificarPlanHandler;
import ar.edu.iua.webServices.Controladores.plan.ModificarPlanesHandler;



public class server {


    public static void startServer() throws serverEx{

        try{
            HttpServer server = HttpServer.create(new InetSocketAddress(8088), 0);
            
            //planaso
            server.createContext("/buscarPlan", new BuscarPlanHandler()); 
            server.createContext("/buscarPlanes", new BuscarPlanesHandler() ); 
            server.createContext("/borrarPlan", new BorrarPlanHandler());
            server.createContext("/borrarPlanes", new BorrarPlanesHandler());
            server.createContext("/crearPlan", new CrearPlanHandler());
            server.createContext("/crearPlanes", new CrearPlanesHandler());
            server.createContext("/modificarPlan", new ModificarPlanHandler());
            server.createContext("/modificarPlanes", new ModificarPlanesHandler());
           
            server.setExecutor(null);
            server.start();            
            
            System.out.print("Servidor escuchando en ");
            System.out.print(server.getAddress().getHostName().equals("0:0:0:0:0:0:0:0") ? "localhost" : server.getAddress().getHostString());            
            System.out.print(":");
            System.out.print(server.getAddress().getPort());
            System.out.println();


        }
        catch(IOException e){
            throw new serverEx("404: Not found");
        }

    }

}
