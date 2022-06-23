package com.it355pz.IT355PZV2.service;

import com.it355pz.IT355PZV2.dao.NoteDao;
import com.it355pz.IT355PZV2.domain.Note;
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
    public List<Note> list() {
//        List<Note> allNotes = dao.findAll();
//        List<Note> userNotes = new ArrayList<>();
//        System.out.println("userId: " + userID);
//        System.out.println("allNotes: " + allNotes.toString());
//        for (Note b : allNotes) {
//            Set<User> noteUsers = b.getUsers();
//            for (User u : noteUsers) {
//                if(u.getId() == userID) {
//                    userNotes.add(b);
//                }
//            }
//        }
        return dao.findAll();
    }

    @Override
    public Note findByName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Note find(int noteID) {
        return dao.findById(noteID);
    }
    
}
