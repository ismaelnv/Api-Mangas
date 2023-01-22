package com.villarruel.mangas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.villarruel.mangas.Entity.Usuario;
import com.villarruel.mangas.Interface.IUsuario;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceUsuario {

    @Autowired
    private IUsuario iUsuario;

    public List<Usuario> getAll(){
        return (List<Usuario>) iUsuario.findAll(); 
    }
     
    public Optional<Usuario> getUsuario(Integer usuarioId){
        return iUsuario.findById(usuarioId);
    }

    public Usuario save(Usuario usuario){
        return iUsuario.save(usuario);
    }

    public boolean delete(Integer usuarioId){
        if(getUsuario(usuarioId).isPresent()){
            iUsuario.deleteById(usuarioId);
            return true;
        }else{
            return false;
        }
    }

    public Usuario update(Integer id, Usuario usuario){
        Optional<Usuario> obtenerU = iUsuario.findById(id);
        if(obtenerU.isPresent()){
            return iUsuario.save(usuario);
        }
        return usuario;
    } 
}
