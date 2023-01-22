package com.villarruel.mangas.Interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.villarruel.mangas.Entity.Usuario;

@Repository
public interface IUsuario extends CrudRepository<Usuario,Integer> {
}
