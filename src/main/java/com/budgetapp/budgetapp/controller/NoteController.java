package com.budgetapp.budgetapp.controller;

import com.budgetapp.budgetapp.domain.Note;
import com.budgetapp.budgetapp.service.NoteService;
import java.util.List;
// import java.util.Set;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
public class NoteController {

    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/notes")
    public List getNotes() {
        return noteService.list();
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
    public ResponseEntity createNote(@RequestBody Note note) {
        // Board board = boardService.find(boardID);
        // Set<Note> boardNotes = board.getNotes();
        // boardNotes.add(note);
        // boardService.update(board);
        noteService.add(note);

        return new ResponseEntity(note, HttpStatus.OK);
    }

    @DeleteMapping(value = "/notes/{id}")
    public ResponseEntity deleteNote(@PathVariable int id) {

        if (noteService.find(id) != null) {
            // Board board = boardService.find(boardId);
            // if (board != null) {
            // Set<Note> boardNotes = board.getNotes();
            // for (Note t : boardNotes) {
            // if (t.getId().equals(noteId)) {
            // boardNotes.remove(t);
            // break;
            // }
            // }
            // board.setNotes(boardNotes);
            // boardService.update(board);

            // noteService.remove(noteId);
            // return new ResponseEntity(noteId, HttpStatus.OK);
            // } else {
            // return new ResponseEntity("No Board found for ID " + boardId,
            // HttpStatus.NOT_FOUND);
            // }
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
