package com.it355pz.IT355PZV2.dao;

import com.it355pz.IT355PZV2.domain.Note;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class NoteDaoImpl extends HibernateDao<Note, Integer> implements NoteDao {

    @Autowired
    public NoteDaoImpl(SessionFactory sessionFactory) {
        super(sessionFactory, Note.class);
    }
}
