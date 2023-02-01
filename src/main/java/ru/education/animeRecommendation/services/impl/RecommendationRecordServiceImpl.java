package ru.education.animeRecommendation.services.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.education.animeRecommendation.config.AnimeClientConfig;
import ru.education.animeRecommendation.dao.RecommendationRecordRepository;
import ru.education.animeRecommendation.exceptions.RequestException;
import ru.education.animeRecommendation.model.AnimeRecommendationRecord;
import ru.education.animeRecommendation.services.RecommendationRecordService;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Service
@Slf4j
public class RecommendationRecordServiceImpl implements RecommendationRecordService {

    private final RecommendationRecordRepository recordRepository;

    private final AnimeClientConfig config;

    private final ObjectMapper objectMapper;


    @Autowired
    public RecommendationRecordServiceImpl(RecommendationRecordRepository recordRepository, AnimeClientConfig config, ObjectMapper objectMapper) {
        this.recordRepository = recordRepository;
        this.config = config;
        this.objectMapper = objectMapper;
    }

    @Override
    public AnimeRecommendationRecord getRecord(String filter) {
        String url = config.getUrl() + filter;
        try {
            var client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            HttpResponse<String> response =
                    client.send(request, HttpResponse.BodyHandlers.ofString());
            AnimeRecommendationRecord record = objectMapper.readValue(response.body(), AnimeRecommendationRecord.class);
            recordRepository.save(record);
            return record;
        } catch (Exception ex) {
            if (ex instanceof InterruptedException) {
                Thread.currentThread().interrupt();
            }
            log.error("Recommendation record request error, url: {}", url, ex);
            throw new RequestException(ex);
        }
    }
}
