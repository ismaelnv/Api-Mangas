package com.villarruel.mangas.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "administradores")
public class Administradores {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "nombre")
    private String name;
    @Column(name = "contraseña")
    private String contraseña;
    @Column(name = "email")
    private String email;

    public Integer getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getContraseña() {
        return this.contraseña;
    }

    public String getEmail() {
        return this.email;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
