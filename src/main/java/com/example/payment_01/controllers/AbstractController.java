package com.example.payment_01.controllers;

import com.example.payment_01.dto.convertors.BaseConvertor;
import com.example.payment_01.exceptions.ServiceException;
import com.example.payment_01.services.AbstractService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class AbstractController<E, D, S extends AbstractService<? extends JpaRepository<E, Long>, E>> {
    @Autowired
    protected S service;
    @Autowired
    protected BaseConvertor<D, E> convertor;

    @PostMapping()
    @Transactional
    public void add(@Valid @RequestBody D d) throws ServiceException {
        service.insert(convertor.convertDto(d));
    }
}
