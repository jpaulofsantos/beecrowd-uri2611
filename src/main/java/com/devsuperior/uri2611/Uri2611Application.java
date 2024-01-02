package com.devsuperior.uri2611;

import com.devsuperior.uri2611.projections.GenreMinProjection;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.GenreRepository;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Uri2611Application implements CommandLineRunner {

	@Autowired
	MovieRepository movieRepository;
	@Autowired
	GenreRepository genreRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(Uri2611Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		List<MovieMinProjection> movieMinProjectionList = movieRepository.searchSQL("Action");
		List<GenreMinProjection> genreMinProjectionsList = genreRepository.searchSQL();

		for (MovieMinProjection item: movieMinProjectionList) {
			System.out.println(item.getId() + " - " + item.getName());
		}

		for (GenreMinProjection item: genreMinProjectionsList) {
			System.out.println(item.getId() + " - " + item.getDescription());
		}
	}
}
