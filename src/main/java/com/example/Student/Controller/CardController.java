package com.example.Student.Controller;

import com.example.Student.Model.Card;
import com.example.Student.Service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/card")
public class CardController {
    @Autowired
    CardService cs;
    @PostMapping("/add")
    public String add(@RequestBody Card card){
        return cs.add(card);
    }
}
