package com.example.easynotes.model;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    @Test
    public void getTitle() {
        Game game = new Game();

        String title = game.getTitle();

        assertEquals("Secret of Mana", title);
    }
}