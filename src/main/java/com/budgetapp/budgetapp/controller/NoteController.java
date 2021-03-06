package com.budgetapp.budgetapp.controller;

import com.budgetapp.budgetapp.domain.User;
import com.budgetapp.budgetapp.domain.Note;
import com.budgetapp.budgetapp.service.NoteService;
import com.budgetapp.budgetapp.service.UserService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    private final NoteService noteService;
    private final UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping("/notes")
    public List getNotes(@RequestHeader("user") int userID) {
        return noteService.list(userID);
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<Note> getNote(@PathVariable("id") int id) {
        Note note = noteService.find(id);

        if (note == null) {
            return new ResponseEntity("No Note found for ID " + id, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(note, HttpStatus.OK);
    }

    @PostMapping(value = "/notes", consumes = { "application/xml", "application/json" })
    @Transactional
    public ResponseEntity createNote(@RequestBody Note note, @RequestHeader("user") int userID) {
        // Note note = noteService.add(note);

        User user = userService.find(userID);
        note.setUser(user);
        noteService.add(note);

        return new ResponseEntity(note, HttpStatus.OK);
    }

    @DeleteMapping(value = "/notes/{id}")
    public ResponseEntity deleteNote(@PathVariable int id) {
        Note note = noteService.find(id);

        if (note != null) {
            noteService.remove(id);
            return new ResponseEntity(id, HttpStatus.OK);
        }

        return new ResponseEntity("No Note found for ID " + id, HttpStatus.NOT_FOUND);
    }

    @PutMapping(value = "/notes/{id}", consumes = { "application/xml",
            "application/json" })
    @Transactional
    public ResponseEntity updateNote(@PathVariable int id, @RequestBody Note note) {
        Note newNote = noteService.find(id);

        if (null == newNote) {
            return new ResponseEntity("No Note found for ID " + id,
                    HttpStatus.NOT_FOUND);
        }

        newNote.setDescription(note.getDescription());
        noteService.update(newNote);
        return new ResponseEntity(newNote, HttpStatus.OK);
    }
}
