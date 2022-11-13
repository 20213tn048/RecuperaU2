package mx.edu.utez.examenrecuperacionu2.model.docente;

import mx.edu.utez.examenrecuperacionu2.model.grupo.BeanGrupo;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class BeanDocente {
    private Long id;
    private String name;
    private String surname;
    private String lastname;
    private String birthday;
    private String curp;
    private Long dni;

    private BeanGrupo grup;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getDni() {
        return dni;
    }
    public void setDni(Long dni) {
        this.dni = dni;
    }

    public BeanGrupo getGrup() {
        return grup;
    }

    public void setGrup(BeanGrupo grup) {
        this.grup = grup;
    }
}
