package com.villarruel.mangas.Entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "clients")
public class Usuario {

    @Id
    @Column(name = "client_id")
    private Integer usuarioId;

    private String name;

    private String email;

    @Column(name = "birthdate")
    private Date cumpleaños;

    @Column(name = "gender")
    private String genero;

    @OneToMany(mappedBy = "usuario")
    private List<Operacion> operaciones;

    public Integer getUsuarioId() {
        return this.usuarioId;
    }

    public String getName() {
        return this.name;
    }

    public Date getCumpleaños() {
        return this.cumpleaños;
    }

    public String getEmail() {
        return this.email;
    }

    public String getGenero() {
        return this.genero;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCumpleaños(Date cumpleaños) {
        this.cumpleaños = cumpleaños;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
