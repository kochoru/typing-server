package com.example.typing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.typing.dto.Player;

public interface PlayerMapper {

    @Select("select "
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
            + "from typing_app.t_player "
            + "where id = #{id} and ip_address = #{ipAddress}")
    Player findOne(@Param("id") String id, @Param("ipAddress") String ipAddress);

    @Select("select "
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
            + "from typing_app.t_player "
            + "where id = #{id}")
    Player findOneByUserId(@Param("id") String id);

    @Select("select "
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
            + "from typing_app.t_player "
            + "order by score desc")
    List<Player> findAll();

    @Select("select "
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
            + "from typing_app.t_player "
            + "where ip_address = #{ipAddress}")
    Player findOneByIpAddress(@Param("ipAddress") String ipAddress);

    @Select("select "
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
            + "from typing_app.t_player "
            + "where last_play_time >= timestamp '2018-01-23 08:40:00' "
            + "and last_play_time <= timestamp '2018-01-23 17:10:00' "
            + "order by score desc")
    List<Player> findPlayersProductionMode();

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
    boolean create(Player entity);

    @Update("update typing_app.t_player set "
            + "score = #{score}, "
            + "last_play_time = #{lastPlayTime}, "
            + "challenge_count = #{challengeCount} "
            + "where id = #{id} and ip_address = #{ipAddress}")
    boolean update(Player entity);

    @Delete("delete from typing_app.t_player "
            + "where id = #{id} and ip_address = #{ipAddress}")
    boolean delete(@Param("id") String id, @Param("ipAddress") String ipAddress);
}
