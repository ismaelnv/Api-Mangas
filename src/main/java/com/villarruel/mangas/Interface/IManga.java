package com.villarruel.mangas.Interface;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.villarruel.mangas.Entity.Manga;

@Repository
public interface IManga extends CrudRepository<Manga,Integer> {
}
