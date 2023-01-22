package com.villarruel.mangas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.villarruel.mangas.Entity.Operacion;
import com.villarruel.mangas.Interface.IOperacion;

import java.util.List;
import java.util.Optional;

@Service
public class ServicioOperacion {

    @Autowired
    private IOperacion iOperacion;

    public List<Operacion> getAll(){
        return (List<Operacion>) iOperacion.findAll();
    }

    public Optional<Operacion> getOperacion(Integer idOperacion){
        return iOperacion.findById(idOperacion);
    }

    public Operacion  save(Operacion operacion){
        return iOperacion.save(operacion);
    }

    public Boolean delete(Integer idOperacion){
        if(getOperacion(idOperacion).isPresent()){
            iOperacion.deleteById(idOperacion);
            return true;
        }else{
            return false;
        }
    }

    public Operacion update(Integer id , Operacion operacion){
       Optional<Operacion> optenerO = iOperacion.findById(id);
        if( optenerO.isPresent()){
            iOperacion.save(operacion);
        }
        return operacion;
    }
    
}
