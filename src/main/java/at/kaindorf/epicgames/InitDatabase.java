package at.kaindorf.epicgames;

import at.kaindorf.epicgames.database.GameRepository;
import at.kaindorf.epicgames.pojos.Game;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Component
@Slf4j
public class InitDatabase {

    @Autowired
    private GameRepository gameRepo;
    //private final List<Game> games;

    public InitDatabase() {
/*        InputStream is =
                InitDatabase.class.getClassLoader().getResourceAsStream("static/epic-games.json");
        try {
            ObjectMapper mapper = new ObjectMapper()
                    .registerModules(new JavaTimeModule())
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            games = mapper.readValue(is, new TypeReference<>() {
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(games.size());*/
    }
    @PostConstruct
    public void saveDepartments() {
/*
        gameRepo.saveAll(games);
*/
    }

}
