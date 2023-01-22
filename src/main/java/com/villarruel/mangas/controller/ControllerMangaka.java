package com.villarruel.mangas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.villarruel.mangas.Entity.Mangaka;
import com.villarruel.mangas.service.serviceMangaka;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;

@RestController
@RequestMapping("/mangakas")
public class ControllerMangaka {
    
    @Autowired
    serviceMangaka serviceMangaka;
    
    @GetMapping("/all")
    @ApiOperation("Se encarga de traer una lista de mangakas")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Mangaka>> getALL(){
        return new ResponseEntity<>(serviceMangaka.getALL(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    @ApiOperation("Se encarga de traer un mangaka por su clave primaria")
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Mangaka NOT FOUND"),
    })
    public ResponseEntity<Mangaka> getMangaka(@ApiParam(value = "La indentificacion del mangaka", required = true, example = "2") @PathVariable("id") Integer id){
        return serviceMangaka.getMangaka(id).map(serviceMangaka -> new ResponseEntity<>(serviceMangaka, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));  
    }
    
    @PostMapping("/save")
    @ApiOperation("Se encarga de agregar mangakas")
    @ApiResponse(code = 201, message = "Mangakia CREATED")
    public ResponseEntity<Mangaka> save(@RequestBody Mangaka mangaka){
        return new ResponseEntity<>(serviceMangaka.save(mangaka),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("Se encarga de eliminar Mangakas")
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Mangaka NOT FOUND")
    })
    public ResponseEntity delete(@PathVariable("id") Integer id){
        if(serviceMangaka.delete(id)){
            return new ResponseEntity<>(HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    @ApiOperation("Se encarga de actualizar Mangakas")
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Mangaka NOT FOUND"),
    })
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Mangaka mangaka){
        if(serviceMangaka.getMangaka(id).isPresent()){
            return  new ResponseEntity<>(serviceMangaka.update(id,mangaka), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
