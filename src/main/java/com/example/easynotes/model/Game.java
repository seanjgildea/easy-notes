package com.example.easynotes.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.URL;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Entity
@Data
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 250)
    @JsonProperty("name")
    private String name;

    @Size(max = 250)
    @NotNull( message = "Please enter a title")
    private String title;

    @Digits(integer=6, fraction=2, message = "Please enter a valid price")
    @NotNull( message = "Please enter a price")
    @JsonProperty("rating")
    private Double price;

    @Size(max = 750)
    @URL
    @JsonProperty(  value="url", required=true, defaultValue="No url")
    private String link;

    @ManyToOne
    @NotNull
    @JoinColumn(name = "platform_id", referencedColumnName="id", nullable=false, unique=false )
    private Platform platform;

    @Lob
    @Column(name="image")
    private byte[] image;

    private LocalDateTime createDate;

    @Size(max = 2500)
    @NotNull
    @JsonProperty("body")
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName="id", nullable=false, unique=false )
    private User user;
}
