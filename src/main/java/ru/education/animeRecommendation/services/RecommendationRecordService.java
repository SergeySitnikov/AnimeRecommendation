package ru.education.animeRecommendation.services;

import ru.education.animeRecommendation.model.AnimeRecommendationRecord;

import java.io.IOException;

public interface RecommendationRecordService {
    AnimeRecommendationRecord getRecord(String filter);
}
