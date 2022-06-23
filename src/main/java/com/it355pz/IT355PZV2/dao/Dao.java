package com.it355pz.IT355PZV2.dao;

import java.util.List;

public interface Dao<E, I> {

    void insert(E entity);

    void update(E entity);

    void delete(I id);

    List<E> findAll();

    E findById(I id);
}
