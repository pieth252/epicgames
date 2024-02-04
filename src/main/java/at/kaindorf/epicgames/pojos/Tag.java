package at.kaindorf.epicgames.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
    @Column(name = "tag_id")
    private Integer tagId;
    @NotNull
    private String name;
    @ManyToMany(mappedBy = "games")
    @ToString.Exclude
    private Set<Game> games;

    public void addGame(Game game){

    }
}
