package at.kaindorf.epicgames.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_id")
    private Integer tagId;
    @NotNull
    private String name;
    @ManyToMany(mappedBy = "tags")
    @ToString.Exclude
    private Set<Game> games;

    public void addGame(Game game){

    }
}
