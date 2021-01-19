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
     * @param note
     * @return
     */
    public String createNote(Note note) {

        if (note != null) {

            String identifier = UUID.randomUUID().toString();

            Note noteBuilt = Note.builder()
                    .note(note.getNote())
                    .identifier(identifier)
                    .title(note.getTitle())
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
     * Retrieves a list of notes
     * @return
     */
    public List<Note> retrieveAllNotes() {
        List<Note> noteList = noteRepository.findAll();
        return noteList;
    }

    /**
     * retrieve a single note
     * @param identifier
     * @return
     */
    public Note retrieveOneNote(String identifier) {
        return noteRepository.findOne(identifier);
    }

    /**
     * delete a single note
     * @param identifier
     */
    public void deleteNote(String identifier) {

        if (noteRepository.exists(identifier)) {
            noteRepository.delete(identifier);
        }

    }

    /**
     * delete all notes
     */
    public void deleteAllNotes() {
        noteRepository.deleteAll();
    }


}

