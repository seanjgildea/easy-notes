package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import com.example.easynotes.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class NoteController {

    @Autowired
    NoteRepository noteRepository;

    @Autowired
    OwnerRepository ownerRepository;

    @GetMapping("/owner/{ownerId}/notes")
    public Page<Note> getAllNotesByOwnerId(@PathVariable (value = "ownerId") Long ownerId, Pageable pageable) {
        return noteRepository.findByOwnerId(ownerId, pageable);
    }

    // Create note tied to an Owner
    @PostMapping("/owner/{ownerId}/owner")
    public Note createNote(@PathVariable (value = "ownerId") Long ownerId, @Valid @RequestBody Note note) {
        return ownerRepository.findById(ownerId).map(owner -> {
            note.setOwner(owner);
            return noteRepository.save(note);
        }).orElseThrow(() -> new ResourceNotFoundException("OwnerId " + ownerId + " not found"));
    }

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {
        return noteRepository.save(note);
    }

    @GetMapping("/notes/{id}")
    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));
    }

    @PutMapping("/notes/{id}")
    public Note updateNote(@PathVariable(value = "id") Long noteId, @Valid @RequestBody Note noteDetails ) {

        Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        note.setTitle(noteDetails.getTitle());
        note.setContent(noteDetails.getContent());

        Note updatedNote = noteRepository.save(note);
        return updatedNote;
    }

    /*
    @DeleteMapping("/notes/{id}")
    public ResponseEntity<?> deleteNote(@PathVariable(value = "id") Long noteId) {

        Note note = noteRepository.findById(noteId).orElseThrow(() -> new ResourceNotFoundException("Note", "id", noteId));

        noteRepository.delete(note);

        return ResponseEntity.ok().build();
    }*/


}
