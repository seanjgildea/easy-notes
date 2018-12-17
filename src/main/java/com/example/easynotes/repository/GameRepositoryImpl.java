package com.example.easynotes.repository;

import com.example.easynotes.model.Game;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class GameRepositoryImpl implements GameRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Game> sortByPrice() {
        //Query query = entityManager.createNativeQuery("SELECT em.* FROM notes_app.game as em ", Game.class);
        //query.setParameter(1, firstName + "%");
        return null;
    }
}
