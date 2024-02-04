package at.kaindorf.epicgames.database;

import at.kaindorf.epicgames.pojos.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, String> {
}
