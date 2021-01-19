package com.notes.notes.controller;

import com.notes.notes.model.Note;
import com.notes.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(value = "notes/v1/")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @PostMapping("create")
    public String createNote(@RequestBody Note note) {
        String identifier = UUID.randomUUID().toString();
        note.setIdentifier(identifier);
        noteRepository.save(note);
        return identifier;
    }

    @GetMapping("allNotes")
    public List<Note> retrieveAllNotes() {
        return noteRepository.findAll();
    }

    @GetMapping("notes/{identifier}")
    public Optional<Note> retrieveNote(@PathVariable String identifier) {
        Note note = noteRepository.findOne(identifier);
        return Optional.ofNullable(note);
    }

    @DeleteMapping("notes/{identifier}")
    public void deleteNote(@PathVariable String identifier) {
        noteRepository.delete(identifier);
    }
}
