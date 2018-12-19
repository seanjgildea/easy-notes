package com.example.easynotes.repository;

import com.example.easynotes.model.Game;
import com.example.easynotes.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    public List<Game> findByTitleContaining(String title);
    public List<Game> findAllByOrderByPriceAsc();
    public List<Game> findAllByOrderByCreateDateDesc();
    public List<Game> findAllByOrderByPlatformAsc();
    public List<Game> findAllByOrderByTitleAsc();
}