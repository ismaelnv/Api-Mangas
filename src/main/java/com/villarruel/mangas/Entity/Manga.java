package com.villarruel.mangas.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "mangas")
public class Manga {
    
    @Id
    @Column(name = "manga_id")
    private Integer mangaId;
    
    @Column(name = "mangaka_id")
    private Integer mangakaId;
    
    private String title;

    private Integer year;

    private String lenguage;

    @Column(name = "cover_url")
    private String coverUrl;

    private Double price;
    private Float  sellable;
    private Integer copies;
    private String descriptin;
    
    @ManyToOne
    @JoinColumn(name = "mangaka_id", insertable = false, updatable = false)
    private Mangaka mangaka;

    public Integer getMangaId(){
        return this.mangaId;
    }

    public Integer getMangakaId(){
        return this.mangakaId;
    }

    public Integer getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public String getLenguage() {
        return lenguage;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public Double getPrice() {
        return price;
    }

    public Float getSellable() {
        return sellable;
    }

    public Integer getCopies() {
        return copies;
    }

    public String getDescriptin() {
        return descriptin;
    }

    public void setManga(Integer mangaId){
        this.mangaId = mangaId;
    }

    public void setMangaka(Integer mangakaId){
        this.mangakaId = mangakaId;
    }

    public void setDescriptin(String descriptin) {
        this.descriptin = descriptin;
    }

    public void setCopies(Integer copies) {
        this.copies = copies;
    }

    public void setSellable(Float sellable) {
        this.sellable = sellable;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public void setLenguage(String lenguage) {
        this.lenguage = lenguage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
  