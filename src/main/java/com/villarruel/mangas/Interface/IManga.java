package com.villarruel.mangas.Interface;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.villarruel.mangas.Entity.Manga;

@Repository
public interface IManga extends CrudRepository<Manga, Integer> {

    @Query("SELECT m FROM Manga m WHERE m.categoria = :categoria")
    List<Manga> finByManga(@Param("categoria") String categoria);

}
