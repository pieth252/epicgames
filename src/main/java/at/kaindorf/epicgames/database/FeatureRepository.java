package at.kaindorf.epicgames.database;

import at.kaindorf.epicgames.pojos.Feature;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<Feature, String> {
}
