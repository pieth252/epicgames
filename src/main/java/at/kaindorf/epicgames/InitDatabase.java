package at.kaindorf.epicgames;

import at.kaindorf.epicgames.database.GameRepository;
import at.kaindorf.epicgames.pojos.Feature;
import at.kaindorf.epicgames.pojos.Game;
import at.kaindorf.epicgames.pojos.Publisher;
import at.kaindorf.epicgames.pojos.Tag;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

@Component
@Slf4j
public class InitDatabase {

    @Autowired
    private GameRepository gameRepo;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private final List<Game> games = new ArrayList<>();



    public InitDatabase() throws IOException {
        InputStream is =
                InitDatabase.class.getClassLoader().getResourceAsStream("static/epic-games.json");
        ObjectMapper mapper = new ObjectMapper()
                .registerModules(new JavaTimeModule())
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            JsonNode rootNode = mapper.readTree(is);

            Map<String, Publisher> publisherMap = new HashMap<>();
            Map<String, Tag> tagMap = new HashMap<>();
            Map<String, Feature> featureMap = new HashMap<>();


            for (JsonNode node : rootNode) {
                Game game = new Game();
                Publisher publisher;
                Set<Tag> tagSet = new HashSet<>();
                Set<Feature> featureSet = new HashSet<>();
                game.setTitle(node.findValue("title").asText());
                game.setDescription(node.findValue("description").asText());
                game.setPrice(node.findValue("price").asDouble());
                game.setDeveloper(node.findValue("developer").asText());
                game.setReleaseDate(LocalDateTime.parse(node.findValue("releaseDate").asText(), formatter));
                game.setRating(node.findValue("rating").shortValue());


                String publisherName = node.findValue("publisher").asText();
                if (!publisherMap.containsKey(publisherName)) {
                    publisher = new Publisher();
                    publisher.setName(publisherName);
                    publisherMap.put(publisherName, publisher);
                } else {
                    publisher = publisherMap.get(publisherName);
                }
                game.setPublisher(publisher);

                String[] tags =  node.findValue("tags").asText().split(",");
                for (int i = 0; i < tags.length; i++) {
                    Tag tag;
                    if (!tagMap.containsKey(tags[i])) {
                        tag = new Tag();
                        tag.setName(tags[i]);
                        tagMap.put(tags[i], tag);
                    } else {
                        tag = tagMap.get(tags[i]);
                    }
                    tagSet.add(tag);
                }

                String[] features =  node.findValue("features").asText().split(",");
                for (int i = 0; i < features.length; i++) {
                    Feature feature;
                    if (!featureMap.containsKey(features[i])) {
                        feature = new Feature();
                        feature.setName(features[i]);
                        featureMap.put(features[i], feature);
                    } else {
                        feature = featureMap.get(features[i]);
                    }
                    featureSet.add(feature);
                }
                game.setFeatures(featureSet);
                game.setTags(tagSet);
                games.add(game);
            }
    }



    @PostConstruct
    public void saveDepartments() {
        gameRepo.saveAll(games);
    }

}
