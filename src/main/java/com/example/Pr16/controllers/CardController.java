package com.example.Pr16.controllers;

import com.example.Pr16.dao.CardDao;
import com.example.Pr16.models.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/card")
public class CardController {

    @Autowired
    private CardDao cardDao;

    @GetMapping
    public List<Card> getAll() {
        return cardDao.getAllCards();
    }

    @PostMapping
    public void save(@RequestBody Card card) {
        cardDao.save(card);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        cardDao.delete(id);
    }

}
