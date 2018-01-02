package com.example.typing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.typing.dto.Player;
import com.example.typing.mapper.PlayerMapper;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class PlayerService {

    @Autowired
    PlayerMapper playerMapper;

    public boolean create(Player player) {
        return playerMapper.create(player);
    }

    public boolean update(Player player) {
        return playerMapper.update(player);
    }

    public Player find(String id, String ipAddress) {
        return playerMapper.findOne(id, ipAddress);
    }

    public List<Player> findAll() {
        return playerMapper.findAll();
    }

    public List<Player> findAllProduction() {
        return playerMapper.findPlayersProductionMode();
    }

    public boolean delete(Player player) {
        return playerMapper.delete(player.getId(), player.getIpAddress());
    }
}
