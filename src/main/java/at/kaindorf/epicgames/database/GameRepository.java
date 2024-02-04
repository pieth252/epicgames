package at.kaindorf.epicgames.database;

import at.kaindorf.epicgames.pojos.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, String> {
}
