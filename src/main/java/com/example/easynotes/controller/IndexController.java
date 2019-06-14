package com.example.easynotes.controller;

import com.example.easynotes.model.Game;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.WebRequest;

import java.util.Arrays;

@RestController
public class IndexController {

    @Autowired
    RestTemplate restTemplate;

    Logger logger = LoggerFactory.getLogger(IndexController.class);

    /*
    @GetMapping("/login")
    public String showForm(Login login) {

        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "login";
    }*/

    @GetMapping("/retrievePosts")
    public String posts(Model model) {

        String url = "https://jsonplaceholder.typicode.com/posts";
        logger.info("Calling REST endpoint " + url );

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("user-agent", "Mozilla/5.0 Firefox/26.0");
        headers.set("user-key", "1f50ac0213cdd884236601fcaf5ed6cc");

        HttpEntity<String> entity = new HttpEntity<String>("fields name; limit 50;", headers);
        ResponseEntity<Game[]> respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Game[].class);

        Game [] games = respEntity.getBody();
        for ( Game game: games ) {
            logger.info("** ->" + game.getTitle() + " " + game.getDescription());
        }

        logger.info(respEntity.toString());

        return "index";
    }


    /*
    Calls the /games endpoint
     */
    @GetMapping("/retrieveGames")
    public String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {

        String url = "https://api-v3.igdb.com/platforms";
        logger.info("Calling REST endpoint " + url );

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();

        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("user-agent", "Mozilla/5.0 Firefox/26.0");
        headers.set("user-key", "1f50ac0213cdd884236601fcaf5ed6cc");

        HttpEntity<String> entity = new HttpEntity<String>("fields name; limit 50;", headers);
        ResponseEntity<Game[]> respEntity = restTemplate.exchange(url, HttpMethod.GET, entity, Game[].class);

        Game [] games = respEntity.getBody();
        for ( Game game: games ) {
            logger.info("** ->" + game.getName() + " " + game.getDescription());
        }

        logger.info(respEntity.toString());
        logger.info("Finished calling the rest endpoint");

        model.addAttribute("name", name);
        return "hello";
    }


}
