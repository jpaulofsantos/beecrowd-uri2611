package com.devsuperior.uri2611;

import com.devsuperior.uri2611.dto.GenreMinDTO;
import com.devsuperior.uri2611.dto.MovieMinDTO;
import com.devsuperior.uri2611.projections.GenreMinProjection;
import com.devsuperior.uri2611.projections.MovieMinProjection;
import com.devsuperior.uri2611.repositories.GenreRepository;
import com.devsuperior.uri2611.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

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

		System.out.println("");
		System.out.println("----SQL-Movie----");

		for (MovieMinProjection item: movieMinProjectionList) {
			System.out.println(item.getId() + " - " + item.getName());
		}

		System.out.println("");
		System.out.println("----SQL-Genres----");

		for (GenreMinProjection item: genreMinProjectionsList) {
			System.out.println(item.getId() + " - " + item.getDescription());
		}

		//convertendo a lista de projection para dto
		List<MovieMinDTO> movieMinDTOList = movieMinProjectionList.stream().map(x-> new MovieMinDTO(x)).collect(Collectors.toList());

		System.out.println("");
		System.out.println("----SQL-DTO----");

		for (MovieMinDTO item : movieMinDTOList) {
			System.out.println(item.getId() + " - " + item.getName());
		}


		List<MovieMinDTO> movieMinDTOListJPQL = movieRepository.searchJPQL("Action");

		System.out.println("");
		System.out.println("----JPQL-Movie----");

		for (MovieMinDTO item : movieMinDTOListJPQL) {
			System.out.println(item.getId() + " - " + item.getName());
		}

		System.out.println("");
		System.out.println("----JPQL-Genre----");

		List<GenreMinDTO> genreMinDTOList = genreRepository.searchJPQL();
		for (GenreMinDTO item : genreMinDTOList) {
			System.out.println(item.getId() + " - " + item.getDescription());
		}
	}
}
