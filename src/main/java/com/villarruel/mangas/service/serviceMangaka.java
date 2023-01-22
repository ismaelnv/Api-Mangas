package com.villarruel.mangas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.villarruel.mangas.Entity.Mangaka;
import com.villarruel.mangas.Interface.IMangaka;

import java.util.List;
import java.util.Optional;

@Service
public class serviceMangaka {

    @Autowired
    private IMangaka iMangaka;

    public List<Mangaka> getALL(){
        return (List<Mangaka>) iMangaka.findAll();
    }

    public Optional<Mangaka> getMangaka(Integer id){
        return  iMangaka.findById(id);
    }

    public Mangaka save(Mangaka mangaka){
        return iMangaka.save(mangaka);
    }

    public Boolean delete(Integer id){
        if(getMangaka(id).isPresent()){
            iMangaka.deleteById(id);
            return true;
        }else{
            return false;
        }
    }

    public  Mangaka  update(Integer id, Mangaka mangaka){
     Optional<Mangaka> mangakaDb  = iMangaka.findById(id);

        if(mangakaDb.isPresent()){
          iMangaka.save(mangaka);
        }
        return  mangaka;
    }
}
