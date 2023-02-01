package ru.education.animeRecommendation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnimeRecommendationApplication {
//https://kitsu.io/api/edge/anime?filter[text]=tokio
	public static void main(String[] args) {
		SpringApplication.run(AnimeRecommendationApplication.class, args);
	}

}
