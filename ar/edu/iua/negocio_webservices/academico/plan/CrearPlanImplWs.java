package ar.edu.iua.negocio_webservices.academico.plan;

import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.Excepciones.modeloEx.VerificadorEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;
import ar.edu.iua.persistencia.BaseDeDatos;
import ar.edu.iua.util.VerificarIntegridad;

public class CrearPlanImplWs implements CrearPlanWs{
    public boolean crear(PlanWs plan) throws CrearPlanEx {
        
        try {
            VerificarIntegridad.verificarIntegridadPlanWs(plan);
        } catch (VerificadorEx e1) {
            throw new CrearPlanEx(e1.getMessage());
        }

        try {
            BaseDeDatos.addPlanWs(plan);
        } catch (CloneNotSupportedException e) {
            throw new CrearPlanEx(e.getMessage());
        }
        return true;
    }
}
