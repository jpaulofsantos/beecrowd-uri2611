package com.devsuperior.uri2611.repositories;

import com.devsuperior.uri2611.dto.GenreMinDTO;
import com.devsuperior.uri2611.entities.Genre;
import com.devsuperior.uri2611.projections.GenreMinProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface GenreRepository extends JpaRepository<Genre, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM genres")
    List<GenreMinProjection> searchSQL();

    @Query("SELECT new com.devsuperior.uri2611.dto.GenreMinDTO(obj.id, obj.description) FROM Genre obj")
    List<GenreMinDTO> searchJPQL();
}
