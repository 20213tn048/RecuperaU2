package mx.edu.utez.examenrecuperacionu2.model;

import mx.edu.utez.examenrecuperacionu2.model.alumno.BeanAlumno;
import mx.edu.utez.examenrecuperacionu2.utils.Response;

import java.util.List;

public interface RepositoryAlumno <T>{
    List<T> findAllAlumnos();
    BeanAlumno findAlumnoByDni(String dni);
    Response saveAlumno(BeanAlumno alumno);
    Response updateAlumno(BeanAlumno alumno);

}
