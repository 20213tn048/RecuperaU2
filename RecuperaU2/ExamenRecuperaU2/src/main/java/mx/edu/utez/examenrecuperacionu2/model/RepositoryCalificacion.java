package mx.edu.utez.examenrecuperacionu2.model;

import mx.edu.utez.examenrecuperacionu2.model.calificacion.BeanCalificacion;
import mx.edu.utez.examenrecuperacionu2.utils.Response;

import java.util.List;

public interface RepositoryCalificacion <T>{
    BeanCalificacion findCalificacionesByDni(String dni);
    Response saveCalificacion (BeanCalificacion calificacion);
    Response updateCalificacion (BeanCalificacion calificacion);
}
