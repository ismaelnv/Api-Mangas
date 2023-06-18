package com.villarruel.mangas.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "manga")
public class Manga {

    @Id
    @Column(name = "manga_id")
    private Integer mangaId;

    @Column(name = "mangaka_id")
    private Integer mangakaId;

    private String title;

    private Integer year;

    @Column(name = "language")
    private String lenguage;

    @Column(name = "cover_url")
    private String coverUrl;

    private String categoria;
    private Double price;
    private Float sellable;
    private Integer copies;

    @Column(name = "description")
    private String descriptin;

    @ManyToOne
    @JoinColumn(name = "mangaka_id", insertable = false, updatable = false)
    private Mangaka mangaka;

    public Integer getMangaId() {
        return this.mangaId;
    }

    public Integer getMangakaId() {
        return this.mangakaId;
    }

    public Integer getYear() {
        return this.year;
    }

    public String getTitle() {
        return this.title;
    }

    public String getLenguage() {
        return this.lenguage;
    }

    public String getCoverUrl() {
        return this.coverUrl;
    }

    public Double getPrice() {
        return this.price;
    }

    public Float getSellable() {
        return this.sellable;
    }

    public Integer getCopies() {
        return this.copies;
    }

    public String getDescriptin() {
        return this.descriptin;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setManga(Integer mangaId) {
        this.mangaId = mangaId;
    }

    public void setMangaka(Integer mangakaId) {
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

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
