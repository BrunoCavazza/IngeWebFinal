package ar.edu.iua.negocio_webservices.academico.plan;

//import ar.edu.iua.Excepciones.modeloEx.CrearPlanEx;
import ar.edu.iua.Excepciones.modeloEx.ModificarPlanEx;
import ar.edu.iua.Excepciones.modeloEx.VerificadorEx;
import ar.edu.iua.modelo_webservices.academico.PlanWs;
import ar.edu.iua.persistencia.BaseDeDatos;
import ar.edu.iua.util.VerificarIntegridad;

public class ModificarPlanImplWs implements ModificarPlanWs{
    public boolean modificar(PlanWs plan) throws  ModificarPlanEx {
        boolean b = false;   

        try {
            b = VerificarIntegridad.verificarIntegridadPlanWs(plan);
        } catch (VerificadorEx e1) {
            throw new ModificarPlanEx(e1.getMessage());
        }

            if(b){
                for(int i = 0; i < BaseDeDatos.planesSizeWs(); i++){
                try {
                    if(BaseDeDatos.getPlanWs(i).getAnio().equals(plan.getAnio())){
                        BaseDeDatos.setPlanWs(i, plan);
                    
                        return false;
                    }
                } catch (CloneNotSupportedException e) {
                    throw new ModificarPlanEx(e.getMessage());
                }
            }
        }

        return true;
    }
}
