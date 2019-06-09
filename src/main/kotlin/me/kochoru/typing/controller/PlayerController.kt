package me.kochoru.typing.controller

import java.util.Date

import javax.servlet.http.HttpServletRequest

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

import me.kochoru.typing.dto.Player
import me.kochoru.typing.service.PlayerService

@RestController
@RequestMapping("/player")
class PlayerController {

    private val logger = LoggerFactory.getLogger(this.javaClass)

    @Autowired
    internal var playerService: PlayerService? = null

    @PostMapping
    fun confirmPlayer(@ModelAttribute player: Player, request: HttpServletRequest): Player {
        player.ipAddress = request.getRemoteAddr()
        player.lastPlayTime = Date()

        logger.info("remote addr is: " + request.getRemoteAddr())
        val confirmedPlayer = playerService!!.find(player.id, player.ipAddress!!)
        // 存在していなければ新しくレコードを作成する。
        if (confirmedPlayer == null) {
            createPlayer(player)
            return player
        }
        // 存在していればそのまま返す。
        return confirmedPlayer
    }

    private fun createPlayer(@ModelAttribute player: Player): Boolean {
        return playerService!!.create(player)
    }

    @PutMapping(path = ["/{id}/result"])
    fun registerResult(@PathVariable id: String, score: Int, challengeCount: Int, request: HttpServletRequest) {
        val player = Player()
        player.id = id
        player.ipAddress = request.getRemoteAddr()
        player.score = score
        player.challengeCount = challengeCount
        player.lastPlayTime = Date()
        playerService!!.update(player)
    }

    @GetMapping(path = ["/ranking"])
    fun showRanking(): List<Player> {
        return playerService!!.findAll()
    }

    @GetMapping(path = ["/perfectRanking"])
    fun showPerfectRanking(): List<Player> {
        return playerService!!.findAll()
    }

}
