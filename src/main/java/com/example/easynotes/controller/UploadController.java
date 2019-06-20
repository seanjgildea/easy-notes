package com.example.easynotes.controller;

import com.example.easynotes.consts.Constants;
import com.example.easynotes.model.Game;
import com.example.easynotes.model.Upload;
import com.example.easynotes.repository.GameRepository;
import com.example.easynotes.repository.UploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.logging.Logger;

@Controller()
public class UploadController {

    private static final Logger log = Logger.getLogger(UploadController.class.getName());

    @Autowired
    GameRepository gameRepository;

    @Autowired
    UploadRepository uploadRepository;

    @GetMapping("/file/add")
    public String upload(Model model) {

        return "fileUpload";
    }

    @PostMapping("/file/upload")
    public String upload(@RequestParam("file") MultipartFile file, ModelMap modelMap) {

        log.info("INSIDE UPLOAD FILE METHOD");

        Upload upload = new Upload();

        try {
            upload.setFile(file.getBytes());

        }catch( IOException e ) {
            e.printStackTrace();
        }

        uploadRepository.save(upload);


        modelMap.addAttribute("games", gameRepository.findAllByOrderByCreateDateDesc());
        return "viewGames";
    }

}
