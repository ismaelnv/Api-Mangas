package com.villarruel.mangas.Interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.villarruel.mangas.Entity.Operacion;

@Repository
public interface IOperacion  extends CrudRepository<Operacion,Integer>{
}
