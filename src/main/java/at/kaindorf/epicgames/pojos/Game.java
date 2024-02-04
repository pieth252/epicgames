package at.kaindorf.epicgames.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "game_id")
    private Long gameId;
    @Column(length = 100)
    @NotNull
    private String title;
    @Column(length = 1000)
    @NotNull
    private String description;
    @NotNull
    private Double price;
    @NotNull
    private String developer;
    @Column(name = "release_date")
    @NotNull
    private LocalDateTime releaseDate;
    @NotNull
    private Short rating;
    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "games_tags",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "tag_id"))
    private Set<Tag> tags;
    @ToString.Exclude
    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "games_features",
            joinColumns = @JoinColumn(name = "game_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id"))
    private Set<Feature> features;
    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;

    public void addTag(Tag tag){
    }

    public void addFeature(Feature feature){

    }
}
