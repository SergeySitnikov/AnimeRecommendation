package ru.education.animeRecommendation.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.animeRecommendation.model.AnimeRecommendationRecord;

public interface RecommendationRecordRepository extends JpaRepository<AnimeRecommendationRecord, Long> {
}
