package mx.edu.utez.examenrecuperacionu2.model;

import mx.edu.utez.examenrecuperacionu2.model.docente.BeanDocente;
import mx.edu.utez.examenrecuperacionu2.utils.Response;

import java.util.List;

public interface RepositoryDocente <T>{
    List<T> findAllDocentes();

    BeanDocente findDocenteByDni(String dni);

    Response saveDocente(BeanDocente docente);

    Response updateDocente(T object);
}
