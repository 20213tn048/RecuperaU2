package mx.edu.utez.examenrecuperacionu2.model;

import mx.edu.utez.examenrecuperacionu2.model.grupo.BeanGrupo;
import mx.edu.utez.examenrecuperacionu2.utils.Response;

import java.util.List;

public interface RepositoryGrupo <T>{
    List<T> findAllGrupos();
    BeanGrupo findGrupoById(Long id);
    Response saveGrupo (BeanGrupo grupo);
    Response updateGrupo(BeanGrupo grupo);
}
