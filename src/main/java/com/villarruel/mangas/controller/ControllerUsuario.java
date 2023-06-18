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

import com.villarruel.mangas.Entity.Usuario;
import com.villarruel.mangas.service.ServiceUsuario;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class ControllerUsuario {

    @Autowired
    private ServiceUsuario serviceUsuario;

    @GetMapping("/all")
    @ApiOperation("Obtener una listas de usuarios")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Usuario>> getAll() {
        return new ResponseEntity<>(serviceUsuario.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Obtener usuarios por su clave primaria")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Usuarios NOT_FOUND") })
    public ResponseEntity<Usuario> getUsuario(@PathVariable("id") Integer usuarioId) {
        return serviceUsuario.getUsuario(usuarioId)
                .map(serviceUsuario -> new ResponseEntity<>(serviceUsuario, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Se encarga de agregar usuarios")
    @ApiResponse(code = 201, message = "Usuario CREATED")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {
        return new ResponseEntity<>(serviceUsuario.save(usuario), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Se encarga de eliminar usuarios")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Usuario NOT_FOUND") })
    public ResponseEntity delete(@PathVariable("id") Integer usuarioId) {
        if (serviceUsuario.delete(usuarioId)) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("Se encarga de actualizar los usuarios")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Usuario CREATED"),
    })
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Usuario usuario) {
        if (serviceUsuario.getUsuario(id).isPresent()) {
            return new ResponseEntity<>(serviceUsuario.update(id, usuario), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
