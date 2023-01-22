package com.villarruel.mangas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.villarruel.mangas.Entity.Operacion;
import com.villarruel.mangas.service.ServicioOperacion;

import java.util.List;

@RestController
@RequestMapping("/operaciones")
public class ControllerOperaciones {

    @Autowired
    private ServicioOperacion servicioOperacion;

    @GetMapping("/all")
    public ResponseEntity<List<Operacion>> getAll(){
        return new ResponseEntity<>( servicioOperacion.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Operacion> getOperacion(@PathVariable("id") Integer idOperacion){
        return servicioOperacion.getOperacion(idOperacion).map(servicioOperacion -> new ResponseEntity<>(servicioOperacion, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<Operacion> save(@RequestBody Operacion operacion){
        return  new ResponseEntity<>(servicioOperacion.save(operacion), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity  delete(@PathVariable("id") Integer idOperacion){
        if(servicioOperacion.delete(idOperacion)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable ("id") Integer idOPeracion, @RequestBody Operacion operacion){
        if(servicioOperacion.getOperacion(idOPeracion).isPresent()){
            return new ResponseEntity<>(servicioOperacion.update(idOPeracion, operacion), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    
}
