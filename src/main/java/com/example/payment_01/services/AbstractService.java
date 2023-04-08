package com.example.payment_01.services;

import com.example.payment_01.exceptions.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public abstract class AbstractService<R extends JpaRepository<E, Long>, E> {
    @Autowired
    protected R repository;

    public void insert(E e) throws ServiceException {
        repository.save(e);
    }

    public void update(E e)  {
        repository.save(e);
    }

    public Optional<E> findById(Long id) {
        return repository.findById(id);
    }

    public R getRepository() {
        return repository;
    }
}
