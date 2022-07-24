package ar.edu.iua.util;

import ar.edu.iua.modelo_webservices.academico.AnioPlanImplWs;
import ar.edu.iua.modelo_webservices.academico.MateriaImplWs;
import ar.edu.iua.modelo_webservices.academico.PlanImplWs;
import ar.edu.iua.modelo_webservices.academico.PlanWs;

import java.util.ArrayList;
import java.util.List;


import ar.edu.iua.persistencia.*;

public class Transformador {
    
    public static void transformarPlan () throws CloneNotSupportedException{
    
        List<PlanWs> nuevos = new ArrayList<PlanWs>();
        
        for(int i=0; i < BaseDeDatos.getList().size(); i++){ //Recorre los planes
            PlanWs nuevo = new PlanImplWs();
            List<AnioPlanImplWs> a_nuevos = new ArrayList<>();
            nuevo.setAnio(BaseDeDatos.getPlan(i).getAnio());
            if(BaseDeDatos.getPlan(i).isEstadoActivo()){
                nuevo.setEstadoActivo();
            }
            else if(BaseDeDatos.getPlan(i).isEstadoBorrador()){
                nuevo.setEstadoBorrador();
            }
            else if(BaseDeDatos.getPlan(i).isEstadoNoActivo()){
                nuevo.setEstadoNoActivo();
            }
            else{
                nuevo.setEstadoNulo();
            }
            for(int j=0; j<BaseDeDatos.getPlan(i).getAnios().size(); j++){ //Recorre los anios del plan i
                AnioPlanImplWs a_nuevo = new AnioPlanImplWs(0, "");
                List<MateriaImplWs> m_nuevas = new ArrayList<>();
                a_nuevo.setNombre(BaseDeDatos.getPlan(i).getAnios().get(j).getNombre());
                a_nuevo.setNumero(BaseDeDatos.getPlan(i).getAnios().get(j).getNumero());
                for(int k=0; k<BaseDeDatos.getPlan(i).getAnios().get(j).getMaterias().size();k++){
                    MateriaImplWs m_nueva = new MateriaImplWs(0, "", 0.0);
                    m_nueva.setCodigo(BaseDeDatos.getPlan(i).getAnios().get(j).getMaterias().get(k).getCodigo());
                    m_nueva.setNombre(BaseDeDatos.getPlan(i).getAnios().get(j).getMaterias().get(k).getNombre());
                    m_nueva.setCargaHoraria(BaseDeDatos.getPlan(i).getAnios().get(j).getMaterias().get(k).getCargaHoraria());
                    m_nuevas.add(m_nueva);
                }
                a_nuevo.setMaterias(m_nuevas);
                a_nuevos.add(a_nuevo);
            }
            nuevo.setAnios(a_nuevos);
            nuevos.add(nuevo);
        }
        
        for(PlanWs plan:nuevos){
            BaseDeDatos.addPlanWs(plan);
        }
        System.out.println("Se guardaron " + BaseDeDatos.planesSizeWs() + " planes web services en la BD");
    }

   
}
