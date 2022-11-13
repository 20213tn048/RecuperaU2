package mx.edu.utez.examenrecuperacionu2.model.alumno;

import mx.edu.utez.examenrecuperacionu2.model.docente.BeanDocente;
import mx.edu.utez.examenrecuperacionu2.model.grupo.BeanGrupo;

public class BeanAlumno {
    private Long id;
    private String nombre;
    private String surname;
    private String lastname;
    private String birthday;
    private String curp;
    private String dni;
    private BeanGrupo grupo;
    private BeanDocente docente;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public BeanGrupo getGrupo() {
        return grupo;
    }

    public void setGrupo(BeanGrupo grupo) {
        this.grupo = grupo;
    }

    public BeanDocente getDocente() {
        return docente;
    }

    public void setDocente(BeanDocente docente) {
        this.docente = docente;
    }
}
