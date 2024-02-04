package at.kaindorf.epicgames.pojos;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.*;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class Publisher implements Serializable {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;
    @Column(length = 100)
    private String name;
}
