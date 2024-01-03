package com.devsuperior.uri2611.dto;

import com.devsuperior.uri2611.projections.GenreMinProjection;

public class GenreMinDTO {

    private Long id;

    private String description;

    public GenreMinDTO(){

    }

    public GenreMinDTO(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    public GenreMinDTO(GenreMinProjection genreMinProjection) {
        id = genreMinProjection.getId();
        description = genreMinProjection.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
