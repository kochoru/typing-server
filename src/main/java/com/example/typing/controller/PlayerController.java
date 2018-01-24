package com.example.typing.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.typing.dto.Player;
import com.example.typing.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    PlayerService playerService;

    @PostMapping
    public Player confirmPlayer(@ModelAttribute Player player, HttpServletRequest request) {
        player.setIpAddress(request.getRemoteAddr());
        player.setLastPlayTime(new Date());

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

    private boolean createPlayer(@ModelAttribute Player player) {
        return playerService.create(player);
    }

    @PutMapping(path = "/{id}/result")
    public void registerResult(@PathVariable String id, int score, int challengeCount, HttpServletRequest request) {
        Player player = new Player();
        player.setId(id);
        player.setIpAddress(request.getRemoteAddr());
        player.setScore(score);
        player.setChallengeCount(challengeCount);
        player.setLastPlayTime(new Date());
        playerService.update(player);
    }

    @GetMapping(path = "/ranking")
    public List<Player> showRanking() {
        return playerService.findAllProduction();
    }

    @GetMapping(path = "/perfectRanking")
    public List<Player> showPerfectRanking() {
        return playerService.findAllProduction();
    }

}
