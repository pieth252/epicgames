package at.kaindorf.epicgames.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@NoArgsConstructor
public class Publisher implements Serializable {
    @Id
    @Column(name = "publisher_id")
    private Integer publisherId;
    @Column(length = 100)
    private String name;
}
