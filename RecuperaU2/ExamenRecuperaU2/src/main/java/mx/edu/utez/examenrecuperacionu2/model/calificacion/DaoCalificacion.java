package mx.edu.utez.examenrecuperacionu2.model.calificacion;

import mx.edu.utez.examenrecuperacionu2.model.RepositoryCalificacion;
import mx.edu.utez.examenrecuperacionu2.utils.Response;

public class DaoCalificacion implements RepositoryCalificacion <BeanCalificacion> {
    @Override
    public BeanCalificacion findCalificacionesByDni(String dni) {
        return null;
    }

    @Override
    public Response saveCalificacion(BeanCalificacion calificacion) {
        return null;
    }

    @Override
    public Response updateCalificacion(BeanCalificacion calificacion) {
        return null;
    }
}
