package com.example.typing.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.typing.dto.Player;
import com.example.typing.service.PlayerService;

@RestController
@RequestMapping("player")
public class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerService playerService;

    @PostMapping(path = "{id}")
    public Player confirmPlayer(@ModelAttribute Player player, HttpServletRequest request) {
        player.setIpAddress(request.getRemoteAddr());

        logger.info("remote addr is: " + request.getRemoteAddr());
        Player confirmedPlayer = playerService.find(player.getId(), player.getIpAddress());
        // 存在していなければ新しくレコードを作成する。
        if (confirmedPlayer == null) {
            createPlayer(player);
            return player;
        }
        // 存在していればそのまま返す。
        return confirmedPlayer;
    }

    private boolean createPlayer(Player player) {
        return playerService.create(player);
    }

    @PutMapping(path = "{id}/result")
    public void registerResult(Player player) {
        playerService.update(player);
    }

    @GetMapping(path = "ranking")
    public List<Player> showRanking() {
        return playerService.findAll();
    }

}
