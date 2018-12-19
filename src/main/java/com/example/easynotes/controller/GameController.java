package com.example.easynotes.controller;

import com.example.easynotes.model.Game;
import com.example.easynotes.model.Platform;
import com.example.easynotes.repository.GameRepository;
import com.example.easynotes.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Controller()
public class GameController {

    public static final String VIEW_GAMES_URL = "viewGames";
    public static final String ADD_EDIT_GAMES_URL = "addEditGame";

    @Autowired
    GameRepository gameRepository;

    @Autowired
    PlatformRepository platformRepository;

    @GetMapping("/")
    public String getGames(Model model) {
        model.addAttribute("games", gameRepository.findAllByOrderByCreateDateDesc());
        return VIEW_GAMES_URL;
    }

    @GetMapping("/game/add")
    public String homePage(@ModelAttribute("command") Game command, Model model) {
        List<Platform> platforms = platformRepository.findAll();
        model.addAttribute("platforms", platforms);
        model.addAttribute("pageTitle", "Add ");
        return ADD_EDIT_GAMES_URL;
    }

    @PostMapping("/game/add")
    public String postGame(@Valid @ModelAttribute("command") Game command, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {

            bindingResult.getAllErrors().forEach(objectError -> {
                System.out.println(objectError.toString());
            });

            List<Platform> platforms = platformRepository.findAll();
            model.addAttribute("platforms", platforms);
            return ADD_EDIT_GAMES_URL;
        }

        command.setCreateDate(LocalDateTime.now());
        gameRepository.save(command);
        return getGames(model);
    }

    @GetMapping("/game/edit/{id}")
    public String editGame(@PathVariable("id") Long id, Model model) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid Id:" + id));
        model.addAttribute("command", game);

        List<Platform> platforms = platformRepository.findAll();
        model.addAttribute("platforms", platforms);
        model.addAttribute("pageTitle", "Edit ");
        return ADD_EDIT_GAMES_URL;
    }

    @PostMapping("/game/update/{id}")
    public String updateGame(@PathVariable("id") Long id, @Valid Game game, BindingResult result, Model model) {
        if (result.hasErrors()) {
            game.setId(id);
            return ADD_EDIT_GAMES_URL;
        }

        if ( game.getCreateDate() == null ) {
            game.setCreateDate(LocalDateTime.now());
        }

        gameRepository.save(game);
        model.addAttribute("games", gameRepository.findAllByOrderByCreateDateDesc());
        return getGames(model);
    }

    @GetMapping("/game/search")
    public String searchTitle(Model model, String title) {
        model.addAttribute("games", gameRepository.findByTitleContaining(title));
        return VIEW_GAMES_URL;
    }

    @GetMapping("/game/priceSort")
    public String sortByPrice(Model model) {
        model.addAttribute("games", gameRepository.findAllByOrderByPriceAsc());
        return VIEW_GAMES_URL;
    }

    @GetMapping("/game/titleSort")
    public String sortByTitle(Model model) {
        model.addAttribute("games", gameRepository.findAllByOrderByTitleAsc());
        return VIEW_GAMES_URL;
    }

    @GetMapping("/game/platformSort")
    public String sortByPlatform(Model model) {
        model.addAttribute("games", gameRepository.findAllByOrderByPlatformAsc());
        return VIEW_GAMES_URL;
    }


    @GetMapping("/game/delete/{id}")
    public String deleteUser(@PathVariable("id") long id, Model model) {
        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid game Id:" + id));
        gameRepository.delete(game);
        return getGames(model);
    }
}
