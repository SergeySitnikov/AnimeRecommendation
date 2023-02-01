package ru.education.animeRecommendation.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.education.animeRecommendation.model.AnimeRecommendationRecord;
import ru.education.animeRecommendation.services.RecommendationRecordService;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "${app.rest.api.prefix}/v1/anime")
public class RecommendationRecordRestV1 {

    private final RecommendationRecordService recordService;

    @GetMapping("/{filter}")
    public ResponseEntity<AnimeRecommendationRecord> getRecommendation(@PathVariable String filter) {
        return ResponseEntity.ok(recordService.getRecord(filter));
    }
}
