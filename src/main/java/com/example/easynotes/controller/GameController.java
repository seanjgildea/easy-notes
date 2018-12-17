package com.example.easynotes.controller;

import com.example.easynotes.model.Game;
import com.example.easynotes.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.Date;

@Controller()
public class GameController {

    @Autowired
    GameRepository gameRepository;

    @PostConstruct
    public void init() throws Exception {

    }


    @GetMapping("/")
    public String getGames(Model model) {

        model.addAttribute("games", gameRepository.findAllByOrderByCreateDateDesc());
        return "viewGames";
    }

    @RequestMapping(path = "/game/add", method = RequestMethod.GET)
    public String homePage(@ModelAttribute("command") Game command, Model model) {

        return "addGame";
    }

    @PostMapping("/game/post")
    public String postGame(@ModelAttribute("command") Game command, Model model) {
        command.setCreateDate(LocalDateTime.now());
        gameRepository.save(command);
        return "viewGames";
    }

    @GetMapping("/game/search")
    public String searchTitle(Model model, String title) {
        model.addAttribute("games", gameRepository.findByTitleContaining(title));
        return "viewGames";
    }

    @GetMapping("/game/priceSort")
    public String sortByPrice(Model model) {
        model.addAttribute("games", gameRepository.findAllByOrderByPriceAsc());
        return "viewGames";
    }

    @GetMapping("/game/edit/{id}")
    public String editGame(@PathVariable("id") Long id, Model model) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
        model.addAttribute("command", game);
        return "editGame";
    }

    @PostMapping("/game/update/{id}")
    public String updateGame(@PathVariable("id") Long id, @Valid Game game, BindingResult result, Model model) {
        if (result.hasErrors()) {
            game.setId(id);
            return "editGame";
        }

        if ( game.getCreateDate() == null ) {
            game.setCreateDate(LocalDateTime.now());
        }

        gameRepository.save(game);
        model.addAttribute("games", gameRepository.findAllByOrderByCreateDateDesc());
        return "viewGames";
    }
}
