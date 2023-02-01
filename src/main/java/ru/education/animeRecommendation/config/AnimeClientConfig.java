package ru.education.animeRecommendation.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "anime-client")
public class AnimeClientConfig {
    String url;
}
