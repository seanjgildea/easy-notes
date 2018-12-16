package com.example.easynotes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller()
public class GameController {

    @GetMapping("/game/view")
    public String getGames() {
        return "viewGames";
    }

    @GetMapping("/game/add")
    public String addGame() {
        return "addGame";
    }

    @PostMapping("/game/post")
    public String postGame() {
        System.out.println("Adding game");
        return "postGame";
    }
}
