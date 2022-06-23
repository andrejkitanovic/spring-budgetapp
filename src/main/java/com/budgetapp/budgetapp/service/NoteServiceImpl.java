package com.budgetapp.budgetapp.service;

import com.budgetapp.budgetapp.dao.NoteDao;
import com.budgetapp.budgetapp.domain.Note;
import com.budgetapp.budgetapp.domain.User;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteDao dao;

    @Override
    public void add(Note note) {
        dao.insert(note);
    }

    @Override
    public void update(Note note) {
        dao.update(note);
    }

    @Override
    public void remove(int noteID) {
        dao.delete(noteID);
    }

    @Override
    public List<Note> list(Integer userID) {
        List<Note> allNotes = dao.findAll();
        List<Note> userNotes = new ArrayList<>();

        for (Note log : allNotes) {
            User user = log.getUser();

            if (user.getId() == userID) {
                userNotes.add(log);
            }

        }
        return userNotes;
    }

    @Override
    public Note findByName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); // To change body of generated methods, choose
                                                                       // Tools | Templates.
    }

    @Override
    public Note find(int noteID) {
        return dao.findById(noteID);
    }

}
