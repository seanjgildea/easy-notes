package com.example.easynotes.model;

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
    @NotNull( message = "Please enter a title")
    private String title;

    @Digits(integer=6, fraction=2, message = "Please enter a valid price")
    @NotNull( message = "Please enter a price")
    private Double price;

    @Size(max = 750)
    @URL
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
    private String description;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName="id", nullable=false, unique=false )
    private User user;
}
