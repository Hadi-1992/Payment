package com.example.payment_01.services;

import com.example.payment_01.entities.accounts.Card;
import com.example.payment_01.repositories.CardRepository;
import org.springframework.stereotype.Service;

@Service
public class CardService extends AbstractService<CardRepository, Card> {
    public Card getByCardNumber(String CardNumber) {

//        return repository.findByCardNumber(CardNumber);
        return null;

    }
}
