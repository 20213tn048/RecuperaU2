package mx.edu.utez.examenrecuperacionu2.model.grupo;

import mx.edu.utez.examenrecuperacionu2.model.docente.BeanDocente;

public class BeanGrupo {
    private Long id;
    private String grade;
    private String grup;
    private String division;
    private BeanDocente idDocente;

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

    public String getGrup() {
        return grup;
    }

    public void setGrup(String grup) {
        this.grup = grup;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public BeanDocente getIdDocente() {
        return idDocente;
    }

    public void setIdDocente(BeanDocente idDocente) {
        this.idDocente = idDocente;
    }
}
