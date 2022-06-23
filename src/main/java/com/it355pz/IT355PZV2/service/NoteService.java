package com.it355pz.IT355PZV2.service;

import com.it355pz.IT355PZV2.domain.Note;
import java.util.List;

public interface NoteService {
    
    void add(Note note);

    void update(Note note);

    void remove(int noteID);

    List<Note> list();

    Note findByName(String username);

    Note find(int noteID);
}
