package com.example.easynotes.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @BeforeAll
    public static void beforeClass() {
        System.out.println("Before, i am called once");
    }

    Game game;


    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void getPrice() {
        game.setPrice(9.99);
        assertEquals(3, 3, "Values do not match!");
    }

    @AfterEach
    void tearDown() {

    }
}