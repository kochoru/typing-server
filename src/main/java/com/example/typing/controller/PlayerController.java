package com.example.typing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.typing.dto.Player;
import com.example.typing.service.PlayerService;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    // TODO: idとipアドレスだけでよい？
    @PostMapping()
    public Player confirmUser(Player player) {
        

    }
}
