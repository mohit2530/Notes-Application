package com.notes.notes.controller;

import com.notes.notes.model.Note;
import com.notes.notes.svc.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class NoteController {

    @Autowired
    private NoteService noteService;

    @PostMapping("notes/create")
    public String createNote(@RequestBody Note note) {
       String identifier = noteService.createNote(note);
       return identifier;
    }

    @GetMapping("notes/allNotes")
    public List<Note> retrieveAllNotes() {
        return noteService.retrieveAllNotes();
    }

    @GetMapping("notes/{identifier}")
    public Optional<Note> retrieveNote(@PathVariable String identifier) {
        Note note = noteService.retrieveOneNote(identifier);
        return Optional.ofNullable(note);
    }

    @DeleteMapping("notes/{identifier}")
    public void deleteNote(@PathVariable String identifier) {
        noteService.deleteNote(identifier);
    }

    @DeleteMapping("notes/allNotes")
    public void deleteMapping() {
        noteService.deleteAllNotes();
    }

}
