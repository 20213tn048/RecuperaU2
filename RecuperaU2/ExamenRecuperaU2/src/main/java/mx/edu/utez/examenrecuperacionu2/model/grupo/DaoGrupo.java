package mx.edu.utez.examenrecuperacionu2.model.grupo;

import mx.edu.utez.examenrecuperacionu2.model.RepositoryGrupo;
import mx.edu.utez.examenrecuperacionu2.model.docente.BeanDocente;
import mx.edu.utez.examenrecuperacionu2.model.docente.DaoDocente;
import mx.edu.utez.examenrecuperacionu2.utils.MySQLConnection;
import mx.edu.utez.examenrecuperacionu2.utils.Response;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoGrupo implements RepositoryGrupo <BeanGrupo> {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();
    @Override
    public List<BeanGrupo> findAllGrupos() {
        List<BeanGrupo> grupos = new ArrayList<>();
        BeanGrupo grupo = null;
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM grupos");
            rs = pstm.executeQuery();
            while (rs.next()){
                grupo = new BeanGrupo();
                grupo.setId(rs.getLong("id"));
                grupo.setGrade(rs.getString("grade"));
                grupo.setGrup(rs.getString("grup"));
                grupo.setDivision(rs.getString("division"));
                grupos.add(grupo);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoGrupo.class.getName()).log(Level.SEVERE,"Error -> findAllGrupos" + e.getMessage());
        }finally {
            client.close(connection,pstm,rs);
        }
        return grupos;
    }

    @Override
    public BeanGrupo findGrupoById(Long id) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM grupos WHERE id = ?");
            pstm.setLong(1,id);
            rs = pstm.executeQuery();
            while (rs.next()){
                BeanGrupo grupo = new BeanGrupo();
                grupo = new BeanGrupo();
                grupo.setId(rs.getLong("id"));
                grupo.setGrade(rs.getString("grade"));
                grupo.setGrup(rs.getString("grup"));
                grupo.setDivision(rs.getString("division"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoGrupo.class.getName()).log(Level.SEVERE,"Error -> findGrupoById" +e.getMessage());
        }finally {
            client.close(connection, pstm,rs);
        }
        return null;
    }

    @Override
    public Response saveGrupo(BeanGrupo grupo) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("INSERT INTO grupos (grade,grup,division) VALUES  (?,?,?)");
            pstm.setString(1,grupo.getGrade());
            pstm.setString(2,grupo.getGrup());
            pstm.setString(3,grupo.getDivision());

            if(pstm.executeUpdate() == 1){
                return new Response<BeanGrupo>(200,"Registro exitoso",grupo,false);
            }else{
                return new Response<BeanGrupo>(200,"Fallo al registrar. Usuario existente",grupo,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> saveDocente" + e.getMessage());
        }
        return null;    }

    @Override
    public Response updateGrupo(BeanGrupo grupo) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("UPDATE alumnos   SET grade = ?,grup = ?, division = ? where id = ?");
            pstm.setString(1, grupo.getGrade());
            pstm.setString(2,grupo.getGrup());
            pstm.setString(3,grupo.getDivision());
            pstm.setLong(4, grupo.getId());
            if(pstm.executeUpdate() == 1){
                return new Response<BeanGrupo>(200,"Docente actualizado",grupo,false);
            }else{
                return new Response<BeanGrupo>(200,"Fallo de actualización. Usuario inexistente o captura de datos erronea",grupo,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> updateDocente" + e.getMessage());
            return new Response<BeanGrupo>(200,"Error con el servidor",grupo,true);
        }
    }
}
