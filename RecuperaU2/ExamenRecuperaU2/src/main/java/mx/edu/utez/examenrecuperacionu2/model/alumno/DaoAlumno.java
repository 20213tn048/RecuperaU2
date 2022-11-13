package mx.edu.utez.examenrecuperacionu2.model.alumno;

import mx.edu.utez.examenrecuperacionu2.model.RepositoryAlumno;
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

public class DaoAlumno implements RepositoryAlumno <BeanAlumno> {
    Connection connection;
    PreparedStatement pstm;
    ResultSet rs;
    MySQLConnection client = new MySQLConnection();
    @Override
    public List<BeanAlumno> findAllAlumnos() {
        List<BeanAlumno> alumnos = new ArrayList<>();
        BeanAlumno alumno = null;
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM alumnos");
            rs = pstm.executeQuery();
            while(rs.next()){
                alumno = new BeanAlumno();
                alumno.setId(rs.getLong("id"));
                alumno.setNombre(rs.getString("nombre"));
                alumno.setSurname(rs.getString("apellidoP"));
                alumno.setLastname(rs.getString("apellidoM"));
                alumno.setBirthday(rs.getString("nacimiento"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setDni(rs.getString("dni"));
                alumnos.add(alumno);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> findAll (Alumno)" + e.getMessage());
        }finally {
            client.close(connection,pstm,rs);
        }
        return alumnos;
    }

    @Override
    public BeanAlumno findAlumnoByDni(String dni) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("SELECT * FROM alumnos where dni = ?;");
            pstm.setString(1,dni);
            rs = pstm.executeQuery();
            while (rs.next()){
                BeanAlumno alumno = new BeanAlumno();
                alumno.setId(rs.getLong("id"));
                alumno.setNombre(rs.getString("name"));
                alumno.setSurname(rs.getString("surname"));
                alumno.setLastname(rs.getString("lastname"));
                alumno.setBirthday(rs.getString("birthday"));
                alumno.setCurp(rs.getString("curp"));
                alumno.setDni(rs.getString("dni"));
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> findByDni (Alumno)" + e.getMessage());
        }finally {
            client.close(connection,pstm,rs);
        }
        return null;
    }

    @Override
    public Response saveAlumno(BeanAlumno alumno) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("INSERT INTO alumnos (name,surname,lastname,birthday,curp,dni) VALUES  (?,?,?,?,?,?)");
            pstm.setString(1,alumno.getNombre());
            pstm.setString(2,alumno.getSurname());
            pstm.setString(3,alumno.getLastname());
            pstm.setString(4,alumno.getBirthday());
            pstm.setString(5,alumno.getCurp());
            pstm.setString(6,alumno.getDni());
            if(pstm.executeUpdate() == 1){
                return new Response<BeanAlumno>(200,"Registro exitoso",alumno,false);
            }else{
                return new Response<BeanAlumno>(200,"Fallo al registrar. Usuario existente",alumno,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoAlumno.class.getName()).log(Level.SEVERE,"Error -> saveDocente" + e.getMessage());
        }
        return null;
    }

    @Override
    public Response updateAlumno(BeanAlumno alumno) {
        try{
            connection = client.getConnection();
            pstm = connection.prepareStatement("UPDATE docentes SET name = ?, surname = ?, lastname = ?, birthday = ?, curp = ?, dni = ? where dni = ?");
            pstm.setString(1, alumno.getNombre());
            pstm.setString(2,alumno.getSurname());
            pstm.setString(3,alumno.getLastname());
            pstm.setString(4, alumno.getBirthday());
            pstm.setString(5,alumno.getCurp());
            pstm.setString(6,alumno.getDni());
            pstm.setString(7,alumno.getDni());
            if(pstm.executeUpdate() == 1){
                return new Response<BeanAlumno>(200,"Docente actualizado",alumno,false);
            }else{
                return new Response<BeanAlumno>(200,"Fallo de actualización. Usuario inexistente o captura de datos erronea",alumno,true);
            }
        }catch (SQLException e){
            Logger.getLogger(DaoDocente.class.getName()).log(Level.SEVERE,"Error -> updateDocente" + e.getMessage());
            return new Response<BeanAlumno>(200,"Error con el servidor",alumno,true);
        }    }

}
