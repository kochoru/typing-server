package com.example.typing.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.typing.mapper.PlayerMapper;

@Transactional(propagation = Propagation.REQUIRED)
public class PlayerService {

    @Autowired
    PlayerMapper playerMapper;



}
