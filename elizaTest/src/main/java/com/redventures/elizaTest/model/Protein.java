package com.redventures.elizaTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Entity
@Table(name = "protein")
@AllArgsConstructor
@NoArgsConstructor
public class Protein implements Serializable {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonProperty("id")
    @Id
    private Long id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private Number price;

    public Protein(Long protainId, String proteinName, String image) {
    }
}
