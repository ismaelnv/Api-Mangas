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

import com.villarruel.mangas.Entity.Manga;
import com.villarruel.mangas.service.ServiceManga;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import java.util.List;


@RestController
@RequestMapping("/mangas")
public class ControllerManga {

    @Autowired
    private ServiceManga serviceManga;

    @GetMapping("/all")
    @ApiOperation("Se encarga de traer una lista de mangas")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Manga>> getALL(){
        return new ResponseEntity<>(serviceManga.getAll(), HttpStatus.OK);
    }
   
    @GetMapping("/{id}")
    @ApiOperation("Traer un manga por la clave primaria")
    @ApiResponses({
        @ApiResponse(code = 200 , message = "OK"),
        @ApiResponse(code = 404, message = "Manga NOT FOUNT"),
    })
    public ResponseEntity<Manga> getManga( @ApiParam(value = "La indentificacion del manga ", required = true, example = "1") @PathVariable("id") Integer mangaId){
        return serviceManga.getManga(mangaId).map(serviceManga -> new ResponseEntity<>(serviceManga, HttpStatus.OK))
        .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    @PostMapping("/save")
    @ApiOperation("Se encarga de agregar los mangas")
    @ApiResponse(code = 201, message = "Manga CREATED")
    public ResponseEntity<Manga> save(@RequestBody Manga manga){
        return new ResponseEntity<>(serviceManga.save(manga), HttpStatus.CREATED);
    }
    
    @DeleteMapping("/{id}")
    @ApiOperation("Se encarga de eliminar los mangas")
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Manga NOT FOUNT"),
    })
    public ResponseEntity delete(@PathVariable("id") Integer mangaId){
       if(serviceManga.delete(mangaId)){
        return new ResponseEntity<>(HttpStatus.OK);
       }else{
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       } 
    }
    
    @PutMapping("/{id}")
    @ApiOperation("Se encarga de actualizara los mangas")
    @ApiResponses({
        @ApiResponse(code = 200, message = "OK"),
        @ApiResponse(code = 404, message = "Manga NOT FOUND"),
    })
    public ResponseEntity update(@PathVariable("id") Integer id, @RequestBody Manga manga){
        if(serviceManga.getManga(id).isPresent()){
            return new ResponseEntity<>(serviceManga.Update(id, manga), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    
}
