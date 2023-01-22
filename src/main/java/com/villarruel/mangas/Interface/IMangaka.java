package com.villarruel.mangas.Interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.villarruel.mangas.Entity.Mangaka;

@Repository
public interface IMangaka extends CrudRepository<Mangaka,Integer> {
}
