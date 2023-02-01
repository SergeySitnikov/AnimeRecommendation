package ru.education.animeRecommendation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "recommendationRecord")
public class AnimeRecommendationRecord extends Record {

    @Column(name = "synopsis")
    private String synopsis;

    @Column(name = "ageRating")
    private String ageRating;

    @Column(name = "episodeCount")
    private int episodeCount;

}
