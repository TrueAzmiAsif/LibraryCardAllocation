package com.example.Student.Service;

import com.example.Student.Model.Card;
import com.example.Student.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardService {
    @Autowired
    CardRepository cr;
    public String add(Card card){
        cr.save(card);
        return "Done";
    }
}
