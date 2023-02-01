package ru.education.animeRecommendation.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@MappedSuperclass
@Data
public class Record {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "recordId")
    @JsonIgnore
    private Long recordId;

    @Column(name = "name")
    private String name;
}
