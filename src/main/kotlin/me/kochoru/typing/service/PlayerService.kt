package me.kochoru.typing.service

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

import me.kochoru.typing.dto.Player
import me.kochoru.typing.mapper.PlayerMapper

@Service
@Transactional(propagation = Propagation.REQUIRED)
class PlayerService(private val playerMapper: PlayerMapper) {

    fun create(player: Player): Boolean {
        return playerMapper.create(player)
    }

    fun update(player: Player): Boolean {
        return playerMapper.update(player)
    }

    fun find(id: String, ipAddress: String): Player {
        return playerMapper.findOne(id, ipAddress)
    }

    fun findAll(): List<Player> {
        return playerMapper.findAll()
    }

    fun delete(player: Player): Boolean {
        return playerMapper.delete(player.id, player.ipAddress)
    }
}
