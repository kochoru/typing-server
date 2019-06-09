package me.kochoru.typing.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
class Player {
    var id: String = ""
      set(value) { this.id = value }
    var department: String = ""
    var name: String = ""
    var handleName: String? = null
    var displayNameEnable: Boolean = false
    var score: Int? = null
    var challengeCount: Int = 0
    var adminFlg: Boolean = false
    var lastPlayTime: Date? = null
    var ipAddress: String = ""
}
