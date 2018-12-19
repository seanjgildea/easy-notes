package com.example.easynotes.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Set;

@Entity
@Data
public class Platform {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "platform", fetch = FetchType.LAZY)
    private Set<Game> games;
}
