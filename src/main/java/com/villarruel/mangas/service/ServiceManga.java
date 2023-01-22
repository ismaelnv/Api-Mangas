package com.villarruel.mangas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.villarruel.mangas.Entity.Manga;
import com.villarruel.mangas.Interface.IManga;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceManga {

    @Autowired
    private IManga iManga;

    public List<Manga> getAll(){
        return (List<Manga>) iManga.findAll();
    }

    public Optional<Manga> getManga(Integer mangaId){
        return iManga.findById(mangaId);
    }

    public Manga save( Manga manga){
        return iManga.save(manga);
    }

    public Boolean delete(Integer mangaId){
        if(getManga(mangaId).isPresent()){
            iManga.deleteById(mangaId);;
            return true;
        }else{
            return false;
        }
    } 

    public Manga Update(Integer id, Manga manga){
        Optional<Manga> optenerM = iManga.findById(id);
        if(optenerM.isPresent()){
            iManga.save(manga);
        }
        return manga;
    }
}
