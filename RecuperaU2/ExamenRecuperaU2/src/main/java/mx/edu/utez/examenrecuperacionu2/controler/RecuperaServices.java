package mx.edu.utez.examenrecuperacionu2.controler;

import mx.edu.utez.examenrecuperacionu2.model.alumno.BeanAlumno;
import mx.edu.utez.examenrecuperacionu2.model.alumno.DaoAlumno;
import mx.edu.utez.examenrecuperacionu2.model.calificacion.BeanCalificacion;
import mx.edu.utez.examenrecuperacionu2.model.calificacion.DaoCalificacion;
import mx.edu.utez.examenrecuperacionu2.model.docente.BeanDocente;
import mx.edu.utez.examenrecuperacionu2.model.docente.DaoDocente;
import mx.edu.utez.examenrecuperacionu2.model.grupo.BeanGrupo;
import mx.edu.utez.examenrecuperacionu2.model.grupo.DaoGrupo;
import mx.edu.utez.examenrecuperacionu2.utils.Response;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Path("/api/recupera")
public class RecuperaServices {
    Map<String,Object> response = new HashMap<>();

    @GET @Path("/docentes") @Produces(value = {"application/json"})
    public List <BeanDocente>getAllDocentes(){
        return new DaoDocente().findAllDocentes();
    }

    @GET @Path("/docentes/{dni}") @Produces(MediaType.APPLICATION_JSON)
    public BeanDocente getDocenteByDni(@PathParam("dni") String dni){
        System.out.println(dni);
        return new DaoDocente().findDocenteByDni(dni);
    }

    @GET @Path("/alumnos") @Produces(value = {"application/json"})
    public List<BeanAlumno> getAllAlumnos(){
        return new DaoAlumno().findAllAlumnos();
    }

    @GET @Path("/alumnos/{dni}") @Produces(MediaType.APPLICATION_JSON)
    public BeanAlumno getAlumnoByDni(@PathParam("dni") String dni){
        System.out.println(dni);
        return new DaoAlumno().findAlumnoByDni(dni);
    }

    @GET @Path("/grupos") @Produces(value = {"application/json"})
    public List <BeanGrupo> getAllGrupos(){
        return new DaoGrupo().findAllGrupos();
    }

    @GET @Path("/grupos/{id}") @Produces(MediaType.APPLICATION_JSON)
    public BeanGrupo getGrupoById(@PathParam("id") Long id){
        return new DaoGrupo().findGrupoById(id);
    }

    @POST @Path("/docentes") @Consumes(value = {"application/json"}) @Produces(value = {"application/json"})
    public Map<String,Object> saveDocente(BeanDocente docente){
        System.out.println(docente.getName());
        Response<BeanDocente> result = new DaoDocente().saveDocente(docente);
        response.put("result",result);
        return response;
    }

    @POST @Path("/alumnos") @Consumes(value = {"application/json"}) @Produces (value = {"application/json"})
    public Map<String,Object> saveAlumno (BeanAlumno alumno){
        Response<BeanAlumno> result = new DaoAlumno().saveAlumno(alumno);
        response.put("result",result);
        return response;
    }

    @POST @Path("/grupo") @Consumes (value = {"application/json"}) @Produces(value = {"application/json"})
    public Map<String,Object> saveGrupo (BeanGrupo grupo){
        Response <BeanGrupo> result = new DaoGrupo().saveGrupo(grupo);
        response.put("result",result);
        return response;
    }

    @POST @Path("/calificacion") @Consumes (value = {"application/json"}) @Produces(value = {"application/json"})
    public Map <String,Object> saveCalificacion (BeanCalificacion calificacion){
        Response <BeanCalificacion> result = new DaoCalificacion().saveCalificacion(calificacion);
        response.put("result",result);
        return response;
    }

    @PUT @Path("/docentes") @Consumes (value = {"application/json"}) @Produces(value = {"application/json"})
    public Map <String,Object> updateDocente (BeanDocente docente){
        Response<BeanDocente> result = new DaoDocente().updateDocente(docente);
        response.put("result",result);
        return response;
    }

    @PUT @Path("/alumnos") @Consumes(value = {"application/json"}) @Produces(value = {"application/json"})
    public Map <String,Object> updateAlumno (BeanAlumno alumno){
        Response <BeanAlumno> result = new DaoAlumno().updateAlumno(alumno);
        response.put("result", result);
        return response;
    }

    @PUT @Path("/grupos") @Consumes(value = {"applcation/json"}) @Produces(value = {"application/json"})
    public  Map<String,Object> updateGrupo (BeanGrupo grupo){
        Response <BeanGrupo> result = new DaoGrupo().updateGrupo(grupo);
        response.put("result",result);
        return response;
    }

    @PUT @Path("/calificaciones") @Consumes(value = {"application/json"}) @Produces(value = {"application/json"})
    public  Map<String,Object> updateCalificacion (BeanCalificacion calificacion){
        Response <BeanCalificacion> result = new DaoCalificacion().updateCalificacion(calificacion);
        response.put("result",result);
        return response;
    }
}
