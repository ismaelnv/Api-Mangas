package com.villarruel.mangas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import com.villarruel.mangas.Entity.Administradores;
import com.villarruel.mangas.Interface.IAministrador;

@Service
public class ServiceAministrador {

    @Autowired
    private IAministrador iAministrador;

    public List<Administradores> getAll() {
        return (List<Administradores>) iAministrador.findAll();
    }

    public Optional<Administradores> getAministrador(Integer aministradorId) {
        return iAministrador.findById(aministradorId);
    }

    public Administradores saveAministradores(Administradores aministradores) {
        return iAministrador.save(aministradores);
    }

    public Boolean deleteAministrador(Integer id) {
        if (getAministrador(id).isPresent()) {
            iAministrador.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Administradores updateAministrador(Integer id, Administradores aministradores) {
        Optional<Administradores> optenerA = iAministrador.findById(id);
        if (optenerA.isPresent()) {
            iAministrador.save(aministradores);
        }
        return aministradores;
    }

}
