package com.notes.notes.svc;

import com.notes.notes.model.Note;
import com.notes.notes.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class NoteService {

    @Autowired
    NoteRepository noteRepository;

    /**
     * create a new note
     */
    public String createNote(Note note) {

        if (note != null) {

            String identifier = UUID.randomUUID().toString();

            Note noteBuilt = Note.builder()
                    .note(note.getNote())
                    .identifier(identifier)
                    .createDate(new Date())
                    .modifiedDate(new Date())
                    .completed(false)
                    .build();
           noteRepository.save(noteBuilt);
           return identifier;
        }
        return null;
    }

    /**
     * retrieve a list of all notes
     */
    public List<Note> retrieveAllNotes() {
        List<Note> noteList = noteRepository.findAll();
        return noteList;
    }

    /**
     * retrieve one single note
     */
    public Note retrieveOneNote(String identifier) {
        return noteRepository.findOne(identifier);
    }

    /**
     * delete a note
     */
    public void deleteNote(String identifier) {
        noteRepository.delete(identifier);
    }


    /**
     * delete all notes
     */
    public void deleteAllNotes() {
        noteRepository.deleteAll();
    }


}

