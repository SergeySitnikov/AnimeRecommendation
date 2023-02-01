package ru.education.animeRecommendation;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import ru.education.animeRecommendation.model.AnimeRecommendationRecord;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

@SpringBootTest
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        DataSourceTransactionManagerAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class})
public class ResponseConvertationTest {


    private final ObjectMapper objectMapper;

    @Autowired
    public ResponseConvertationTest(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Test
    public void testAnimeResponseJson() throws IOException, URISyntaxException {
        var uri = ClassLoader.getSystemResource("anime_response.json").toURI();
        var recordJson = Files.readString(Paths.get(uri), StandardCharsets.UTF_8);
        AnimeRecommendationRecord actual = objectMapper.readValue(recordJson, AnimeRecommendationRecord.class);
        AnimeRecommendationRecord expected = new AnimeRecommendationRecord();
        expected.setName("Tokyo Ghoul");
        expected.setSynopsis("Tokyo has become a cruel and merciless city—a place where vicious creatures called “ghouls”...");
        expected.setAgeRating("R");
        expected.setEpisodeCount(12);
        Assertions.assertEquals(expected, actual);
    }
}
