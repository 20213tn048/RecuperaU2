package mx.edu.utez.examenrecuperacionu2.model.docente;

import mx.edu.utez.examenrecuperacionu2.model.RepositoryDocente;
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

public class DaoDocente implements RepositoryDocente<BeanDocente> {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();
    @Override
    public List<BeanDocente> findAllDocentes() {
        List<BeanDocente> docentes = new ArrayList<>();
        BeanDocente docente = null;
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM docentes");
            rs = pstm.executeQuery();
            while(rs.next()){
                docente = new BeanDocente();
                docente.setId(rs.getLong("id"));
                docente.setName(rs.getString("name"));
                docente.setSurname(rs.getString("surname"));
                docente.setLastname(rs.getString("lastname"));
                docente.setBirthday(rs.getString("birthday"));
                docente.setCurp(rs.getString("curp"));
                docente.setDni(rs.getLong("dni"));
                docentes.add(docente);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> findAll (Docente)" + e.getMessage());
        }finally {
            client.close(connection,pstm,rs);
        }
        return docentes;
    }

    @Override
    public BeanDocente findDocenteByDni(String dni) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM docentes where dni = ?;");
            pstm.setString(1,dni);
            rs = pstm.executeQuery();
            while (rs.next()){
                BeanDocente docente = new BeanDocente();
                docente.setId(rs.getLong("id"));
                docente.setName(rs.getString("name"));
                docente.setSurname(rs.getString("surname"));
                docente.setLastname(rs.getString("lastname"));
                docente.setBirthday(rs.getString("birthday"));
                docente.setCurp(rs.getString("curp"));
                docente.setDni(rs.getLong("dni"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> findByCurp (Docente)" + e.getMessage());
        }finally {
            client.close(connection,pstm,rs);
        }
        return null;
    }

    @Override
    public Response saveDocente(BeanDocente docente) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("INSERT INTO docentes (name,surname,lastname,birthday,curp,dni) VALUES  (?,?,?,?,?,?)");
            pstm.setString(1,docente.getName());
            pstm.setString(2,docente.getSurname());
            pstm.setString(3,docente.getLastname());
            pstm.setString(4,docente.getBirthday());
            pstm.setString(5,docente.getCurp());
            pstm.setLong(6,docente.getDni());
            if(pstm.executeUpdate() == 1){
                return new Response<BeanDocente>(200,"Registro exitoso",docente,false);
            }else{
                return new Response<BeanDocente>(200,"Fallo al registrar. Usuario existente",docente,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> saveDocente" + e.getMessage());
        }
        return null;
    }

    @Override
    public Response updateDocente(BeanDocente docente) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("UPDATE alumnos   SET name = ?, surname = ?, lastname = ?, birthday = ?, curp = ?, dni = ? where dni = ?");
            pstm.setString(1, docente.getName());
            pstm.setString(2,docente.getSurname());
            pstm.setString(3,docente.getLastname());
            pstm.setString(4, docente.getBirthday());
            pstm.setString(5,docente.getCurp());
            pstm.setLong(6,docente.getDni());
            pstm.setLong(7,docente.getDni());
            if(pstm.executeUpdate() == 1){
                return new Response<BeanDocente>(200,"Docente actualizado",docente,false);
            }else{
                return new Response<BeanDocente>(200,"Fallo de actualización. Usuario inexistente o captura de datos erronea",docente,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> updateDocente" + e.getMessage());
            return new Response<BeanDocente>(200,"Error con el servidor",docente,true);
        }
    }


}
