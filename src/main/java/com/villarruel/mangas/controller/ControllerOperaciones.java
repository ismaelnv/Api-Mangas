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

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/operaciones")
public class ControllerOperaciones {

    @Autowired
    private ServicioOperacion servicioOperacion;

    @GetMapping("/all")
    @ApiOperation("Se encarga de traer una lista de operaciones")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Operacion>> getAll() {
        return new ResponseEntity<>(servicioOperacion.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Se encarga  de traer una operacion por su clave primaria")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Operacion NOT FOUND"),
    })
    public ResponseEntity<Operacion> getOperacion(@PathVariable("id") Integer idOperacion) {
        return servicioOperacion.getOperacion(idOperacion)
                .map(servicioOperacion -> new ResponseEntity<>(servicioOperacion, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Se encarga de actualizar operaciones")
    @ApiResponse(code = 201, message = "Se encarga de agregar operaciones")
    public ResponseEntity<Operacion> save(@RequestBody Operacion operacion) {
        return new ResponseEntity<>(servicioOperacion.save(operacion), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Se encarga de eliminar operaciones")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = " OPERACION NOT_FOUND")
    })
    public ResponseEntity delete(@PathVariable("id") Integer idOperacion) {
        if (servicioOperacion.delete(idOperacion)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("Se  encarga de actualizar operaciones")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "OPERACION NOT_FOUND") })
    public ResponseEntity update(@PathVariable("id") Integer idOPeracion, @RequestBody Operacion operacion) {
        if (servicioOperacion.getOperacion(idOPeracion).isPresent()) {
            return new ResponseEntity<>(servicioOperacion.update(idOPeracion, operacion), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
