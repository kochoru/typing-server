package me.kochoru.typing.mapper

import org.apache.ibatis.annotations.*

import me.kochoru.typing.dto.Player

@Mapper
interface PlayerMapper {

    @Select("select "
            + "id, "
            + "name, "
            + "handle_name as handleName, "
            + "department, "
            + "display_name_enable as displayNameEnable, "
            + "ip_address as ipAddress, "
            + "score, "
            + "last_play_time as lastPlayTime, "
            + "admin_flg as adminFlg, "
            + "challenge_count as challengeCount "
            + "from typing_app.t_player "
            + "where id = #{id} and ip_address = #{ipAddress}")
    fun findOne(id: String, ipAddress: String): Player

    @Select("select "
            + "id, "
            + "name, "
            + "handle_name as handleName, "
            + "department, "
            + "display_name_enable as displayNameEnable, "
            + "ip_address as ipAddress, "
            + "score, "
            + "last_play_time as lastPlayTime, "
            + "admin_flg as adminFlg, "
            + "challenge_count as challengeCount "
            + "from typing_app.t_player "
            + "where id = #{id}")
    fun findOneByUserId(id: String): Player

    @Select("select "
            + "id, "
            + "name, "
            + "handle_name as handleName, "
            + "department, "
            + "display_name_enable as displayNameEnable, "
            + "ip_address as ipAddress, "
            + "score, "
            + "last_play_time as lastPlayTime, "
            + "admin_flg as adminFlg, "
            + "challenge_count as challengeCount "
            + "from typing_app.t_player "
            + "order by score desc")
    fun findAll(): List<Player>

    @Select("select "
            + "id, "
            + "name, "
            + "handle_name as handleName, "
            + "department, "
            + "display_name_enable as displayNameEnable, "
            + "ip_address as ipAddress, "
            + "score, "
            + "last_play_time as lastPlayTime, "
            + "admin_flg as adminFlg, "
            + "challenge_count as challengeCount "
            + "from typing_app.t_player "
            + "where ip_address = #{ipAddress}")
    fun findOneByIpAddress(ipAddress: String): Player

    @Insert("insert into typing_app.t_player ("
            + "id, "
            + "name, "
            + "handle_name, "
            + "department, "
            + "display_name_enable, "
            + "ip_address, "
            + "score, "
            + "last_play_time, "
            + "admin_flg, "
            + "challenge_count "
            + ") values ("
            + "#{id}, "
            + "#{name}, "
            + "#{handleName}, "
            + "#{department}, "
            + "#{displayNameEnable}, "
            + "#{ipAddress}, "
            + "#{score}, "
            + "#{lastPlayTime}, "
            + "#{adminFlg}, "
            + "#{challengeCount})")
    fun create(entity: Player): Boolean

    @Update("update typing_app.t_player set "
            + "score = #{score}, "
            + "last_play_time = #{lastPlayTime}, "
            + "challenge_count = #{challengeCount} "
            + "where id = #{id} and ip_address = #{ipAddress}")
    fun update(entity: Player): Boolean

    @Delete("delete from typing_app.t_player "
            + "where id = #{id} and ip_address = #{ipAddress}")
    fun delete(id: String, ipAddress: String): Boolean
}
