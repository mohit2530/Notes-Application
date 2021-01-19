package com.notes.notes.controller;

import com.notes.notes.model.Note;
import com.notes.notes.svc.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("notes/")
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping("ping")
    public String ping() {
        return "Ping Successful.";
    }

    @PostMapping("create")
    public String createNote(@RequestBody Note note) {
       String identifier = noteService.createNote(note);
       return identifier;
    }

    @GetMapping("allNotes")
    public List<Note> retrieveAllNotes() {
        return noteService.retrieveAllNotes();
    }

    @GetMapping("{identifier}")
    public Note retrieveNote(@PathVariable String identifier) {
        Note note = noteService.retrieveOneNote(identifier);
        return note;
    }

    @DeleteMapping("{identifier}")
    public void deleteNote(@PathVariable String identifier) {

        noteService.deleteNote(identifier);
    }

    @DeleteMapping("allNotes")
    public void deleteMapping() {
        noteService.deleteAllNotes();
    }

}
