package com.villarruel.mangas.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.List;

@Entity
@Table(name = "mangakas")
public class Mangaka {

    @Id
    @Column(name = "mangaka_id")
    private Integer id;

    private String name;
    private String year;

    @OneToMany(mappedBy = "mangaka")
    private List<Manga> mangas;  

    public Integer getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getYear(){
        return this.year;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setYear(String year){
        this.year = year;
    }
}
