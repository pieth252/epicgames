package at.kaindorf.epicgames.database;

import at.kaindorf.epicgames.pojos.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TagRepository extends JpaRepository<Tag, String> {
}
