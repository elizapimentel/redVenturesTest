package com.redventures.elizaTest.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.util.UUID;

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
    private UUID id;
    private String imageInactive;
    private String imageActive;
    private String name;
    private String description;
    private Number price;
}
