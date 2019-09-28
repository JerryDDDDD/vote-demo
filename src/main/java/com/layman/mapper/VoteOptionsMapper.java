package com.layman.mapper;

import com.layman.pojo.VoteOptions;
import com.layman.pojo.VoteOptionsExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface VoteOptionsMapper {
    @SelectProvider(type=VoteOptionsSqlProvider.class, method="countByExample")
    long countByExample(VoteOptionsExample example);

    @DeleteProvider(type=VoteOptionsSqlProvider.class, method="deleteByExample")
    int deleteByExample(VoteOptionsExample example);

    @Delete({
        "delete from vote_options",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into vote_options (id, vote_option, ",
        "vote_id, poll)",
        "values (#{id,jdbcType=VARCHAR}, #{voteOption,jdbcType=VARCHAR}, ",
        "#{voteId,jdbcType=VARCHAR}, #{poll,jdbcType=INTEGER})"
    })
    int insert(VoteOptions record);

    @InsertProvider(type=VoteOptionsSqlProvider.class, method="insertSelective")
    int insertSelective(VoteOptions record);

    @SelectProvider(type=VoteOptionsSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="vote_option", property="voteOption", jdbcType= JdbcType.VARCHAR),
        @Result(column="vote_id", property="voteId", jdbcType= JdbcType.VARCHAR),
        @Result(column="poll", property="poll", jdbcType= JdbcType.INTEGER)
    })
    List<VoteOptions> selectByExample(VoteOptionsExample example);

    @Select({
        "select",
        "id, vote_option, vote_id, poll",
        "from vote_options",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="vote_option", property="voteOption", jdbcType= JdbcType.VARCHAR),
        @Result(column="vote_id", property="voteId", jdbcType= JdbcType.VARCHAR),
        @Result(column="poll", property="poll", jdbcType= JdbcType.INTEGER)
    })
    VoteOptions selectByPrimaryKey(String id);

    @UpdateProvider(type=VoteOptionsSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VoteOptions record, @Param("example") VoteOptionsExample example);

    @UpdateProvider(type=VoteOptionsSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VoteOptions record, @Param("example") VoteOptionsExample example);

    @UpdateProvider(type=VoteOptionsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(VoteOptions record);

    @Update({
        "update vote_options",
        "set vote_option = #{voteOption,jdbcType=VARCHAR},",
          "vote_id = #{voteId,jdbcType=VARCHAR},",
          "poll = #{poll,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(VoteOptions record);
}