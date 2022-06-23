package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.domain.Note;
import java.util.List;

public interface NoteService {
    
    void add(Note note);

    void update(Note note);

    void remove(int noteID);

    List<Note> list(Integer userID);

    Note findByName(String username);

    Note find(int noteID);
}
