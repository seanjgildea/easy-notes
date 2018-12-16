package com.example.easynotes.repository;

import com.example.easynotes.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {
    public Page<Note> findByOwnerId(Long ownerId, Pageable pageable);
    public Note findByTitle(String title);
}
