package ar.edu.iua;

import ar.edu.iua.Excepciones.ObjetoEx;
//import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;1
//import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
//import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
//import ar.edu.iua.Excepciones.web_services_ex.serverEx;
import ar.edu.iua.util.Ejecutador;

public class Main {

    public static void main(String[] args) {
        System.out.println("Comienzo de main\n\n");

        Ejecutador ejecutador = new Ejecutador();
        
        try {
            ejecutador.ejecutar();
        } catch (ObjetoEx | CloneNotSupportedException e ) {
            e.printStackTrace();
        } 
        System.out.println("\n\nFin de main");
    }

}