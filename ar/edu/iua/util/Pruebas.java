package ar.edu.iua.util;

import java.util.List;

import ar.edu.iua.Excepciones.modeloEx.BuscarPlanEx;
import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.Excepciones.web_services_ex.serverEx;
import ar.edu.iua.interfazusuario.BuscarEImprimirPlanes;
import ar.edu.iua.interfazusuario.BuscarEImprimirPlanesImpl;

import ar.edu.iua.modelo.academico.plan.Plan;

//import ar.edu.iua.negocio.academico.plan.BuscarPlan;
//import ar.edu.iua.negocio.academico.plan.BuscarPlanImpl;

import ar.edu.iua.negocio.academico.plan.CrearPlanes;
import ar.edu.iua.negocio.academico.plan.CrearPlanesImpl;

import ar.edu.iua.negocio.academico.plan.ModificarPlan;
import ar.edu.iua.negocio.academico.plan.ModificarPlanImpl;

import java.util.Scanner;
import ar.edu.iua.persistencia.BaseDeDatos;
import ar.edu.iua.webServices.server;

public class Pruebas {

    public void probar() throws CrearPlanEx, BuscarPlanEx, ModificarPlanEx, serverEx {

        List<Plan> planes = GenerarEjemplosDePlanes.generar(5, false);

        System.out.println("\n\nSe crearon " + planes.size() + " planes.");

        Scanner teclado = new Scanner(System.in);

        CrearPlanes crearPlanes = new CrearPlanesImpl();

        boolean ok = crearPlanes.crear(planes);

        System.out.println("\n\nSe crearon " + BaseDeDatos.planes.size() + " planes.");

        ModificarPlan modificarPlan = new ModificarPlanImpl();


        boolean okk = modificarPlan.modificar(BaseDeDatos.planes.get(0));
        System.out.println("Se modifico el plan " + planes.get(0) + " ? = " + (okk ? "SI" : "NO"));

        okk = modificarPlan.modificar(planes.get(1));
        System.out.println("Se modifico el plan " + planes.get(1) + " ? = " + (okk ? "SI" : "NO"));

        okk = modificarPlan.modificar(planes.get(2));
        System.out.println("Se modifico el plan " + planes.get(1) + " ? = " + (okk ? "SI" : "NO"));

        BuscarEImprimirPlanes buscarEImprimirPlanes = new BuscarEImprimirPlanesImpl();

        buscarEImprimirPlanes.buscar(" Informática ' ");

        server.startServer();

        teclado.close();



    }

}
