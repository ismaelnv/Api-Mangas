package com.villarruel.mangas.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.villarruel.mangas.Entity.Administradores;
import com.villarruel.mangas.service.ServiceAministrador;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Controller()
@RequestMapping("/administrador")
public class ControllerAministrador {

    @Autowired
    private ServiceAministrador serviceAministrador;

    @GetMapping("/")
    @ApiOperation("Obtiene todos los aministradores")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<Administradores>> getAll() {
        return new ResponseEntity<>(serviceAministrador.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Se encarga de traer un aministrador por su ID")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 400, message = "Administrador not found"),
    })
    public ResponseEntity<Administradores> getAministrador(@PathVariable("id") Integer id) {
        return serviceAministrador.getAministrador(id)
                .map(serviceAministrador -> new ResponseEntity<>(serviceAministrador, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Administradores> saveAministrador(@RequestBody Administradores aministradores) {
        return new ResponseEntity<>(serviceAministrador.saveAministradores(aministradores), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteAministrador(@PathVariable("id") Integer id) {
        if (serviceAministrador.deleteAministrador(id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Administradores> updateAministrador(@PathVariable("id") Integer id,
            @RequestBody Administradores administradores) {
        if (serviceAministrador.getAministrador(id).isPresent()) {
            return new ResponseEntity<>(serviceAministrador.updateAministrador(id, administradores), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}