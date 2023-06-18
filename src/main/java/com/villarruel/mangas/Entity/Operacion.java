package com.villarruel.mangas.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "operations")
public class Operacion {
    
    @Id
    @Column(name = "operation_id")
    private Integer idOperacion;

    @Column(name = "manga_id")
    private Integer mangaId;

    @Column(name = "client_id ")
    private Integer usuarioId;

    @Column(name = "type")
    private String tipoDeOperacion;

    @ManyToOne
    @JoinColumn(name = "client_id", insertable = false, updatable = false)
    private Usuario usuario;

    public Integer getIdOperacion() {
        return this.idOperacion;
    }

    public Integer getMangaId() {
        return this.mangaId;
    }

    public Integer getUsuarioId() {
        return this.usuarioId;
    }

    public String getTipoDeOperacion() {
        return this.tipoDeOperacion;
    }

    public void setIdOperacion(Integer idOperacion) {
        this.idOperacion = idOperacion;
    }

    public void setMangaId(Integer mangaId) {
        this.mangaId = mangaId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

    public void setTipoDeOperacion(String tipoDeOperacion) {
        this.tipoDeOperacion = tipoDeOperacion;
    } 
}
