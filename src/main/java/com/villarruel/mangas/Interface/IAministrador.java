package com.villarruel.mangas.Interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.villarruel.mangas.Entity.Administradores;

@Repository
public interface IAministrador extends CrudRepository<Administradores, Integer> {

}
