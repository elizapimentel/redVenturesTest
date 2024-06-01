package com.redventures.elizaTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Table(name = "broth")
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Broth implements Serializable {

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

    public Broth(Long id, String brothName, String image) {
    }
}
