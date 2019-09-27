package com.layman.mapper;

import com.layman.pojo.Vote;
import com.layman.pojo.VoteExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface VoteMapper {
    @SelectProvider(type= VoteSqlProvider.class, method="countByExample")
    long countByExample(VoteExample example);

    @DeleteProvider(type= VoteSqlProvider.class, method="deleteByExample")
    int deleteByExample(VoteExample example);

    @Delete({
        "delete from vote",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into vote (id, number, ",
        "create_id, user_count, ",
        "vote_title, vote_content)",
        "values (#{id,jdbcType=VARCHAR}, #{number,jdbcType=VARCHAR}, ",
        "#{createId,jdbcType=VARCHAR}, #{userCount,jdbcType=INTEGER}, ",
        "#{voteTitle,jdbcType=VARCHAR}, #{voteContent,jdbcType=VARCHAR})"
    })
    int insert(Vote record);

    @InsertProvider(type= VoteSqlProvider.class, method="insertSelective")
    int insertSelective(Vote record);

    @SelectProvider(type= VoteSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="number", property="number", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_id", property="createId", jdbcType= JdbcType.VARCHAR),
        @Result(column="user_count", property="userCount", jdbcType= JdbcType.INTEGER),
        @Result(column="vote_title", property="voteTitle", jdbcType= JdbcType.VARCHAR),
        @Result(column="vote_content", property="voteContent", jdbcType= JdbcType.VARCHAR)
    })
    List<Vote> selectByExample(VoteExample example);

    @Select({
        "select",
        "id, number, create_id, user_count, vote_title, vote_content",
        "from vote",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="number", property="number", jdbcType= JdbcType.VARCHAR),
        @Result(column="create_id", property="createId", jdbcType= JdbcType.VARCHAR),
        @Result(column="user_count", property="userCount", jdbcType= JdbcType.INTEGER),
        @Result(column="vote_title", property="voteTitle", jdbcType= JdbcType.VARCHAR),
        @Result(column="vote_content", property="voteContent", jdbcType= JdbcType.VARCHAR)
    })
    Vote selectByPrimaryKey(String id);

    @UpdateProvider(type= VoteSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Vote record, @Param("example") VoteExample example);

    @UpdateProvider(type= VoteSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Vote record, @Param("example") VoteExample example);

    @UpdateProvider(type= VoteSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Vote record);

    @Update({
        "update vote",
        "set number = #{number,jdbcType=VARCHAR},",
          "create_id = #{createId,jdbcType=VARCHAR},",
          "user_count = #{userCount,jdbcType=INTEGER},",
          "vote_title = #{voteTitle,jdbcType=VARCHAR},",
          "vote_content = #{voteContent,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Vote record);
}