package mx.edu.utez.examenrecuperacionu2.model.calificacion;

import mx.edu.utez.examenrecuperacionu2.model.alumno.BeanAlumno;

public class BeanCalificacion {
    private Long id;
    private String grade;
    private BeanAlumno alumno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public BeanAlumno getAlumno() {
        return alumno;
    }

    public void setAlumno(BeanAlumno alumno) {
        this.alumno = alumno;
    }
}
