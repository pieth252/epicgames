package at.kaindorf.epicgames.pojos;

import jakarta.persistence.*;
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
public class Feature implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feature_id")
    private Integer featureId;
    @NotNull
    @Column(length = 50)
    private String name;
}
