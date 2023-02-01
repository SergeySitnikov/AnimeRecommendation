package ru.education.animeRecommendation.deserializers;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.core.TreeNode;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.IntNode;
import com.fasterxml.jackson.databind.node.TextNode;
import ru.education.animeRecommendation.model.AnimeRecommendationRecord;

import java.io.IOException;

public class AnimeCustomDeserializer extends StdDeserializer<AnimeRecommendationRecord> {

    public AnimeCustomDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public AnimeRecommendationRecord deserialize(JsonParser parser, DeserializationContext context) throws IOException, JacksonException {
        AnimeRecommendationRecord record = new AnimeRecommendationRecord();
        ObjectCodec codec = parser.getCodec();
        TreeNode treeNode = codec.readTree(parser);
        TreeNode attributes = treeNode.get("attributes");
        record.setName(((TextNode)attributes.get("canonicalTitle")).textValue());
        record.setSynopsis(((TextNode)attributes.get("synopsis")).textValue());
        record.setAgeRating(((TextNode)treeNode.get("ageRating")).textValue());
        record.setEpisodeCount(((IntNode) treeNode.get("episodeCount")).intValue());
        return record;
    }
}
