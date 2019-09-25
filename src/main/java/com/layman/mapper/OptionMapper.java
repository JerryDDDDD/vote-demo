package com.layman.mapper;

import com.layman.pojo.Option;
import com.layman.pojo.OptionExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface OptionMapper {
    @SelectProvider(type= OptionSqlProvider.class, method="countByExample")
    long countByExample(OptionExample example);

    @DeleteProvider(type= OptionSqlProvider.class, method="deleteByExample")
    int deleteByExample(OptionExample example);

    @Delete({
        "delete from option",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into option (id, option, ",
        "vote_id, poll)",
        "values (#{id,jdbcType=VARCHAR}, #{option,jdbcType=VARCHAR}, ",
        "#{voteId,jdbcType=VARCHAR}, #{poll,jdbcType=INTEGER})"
    })
    int insert(Option record);

    @InsertProvider(type= OptionSqlProvider.class, method="insertSelective")
    int insertSelective(Option record);

    @SelectProvider(type= OptionSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="option", property="option", jdbcType= JdbcType.VARCHAR),
        @Result(column="vote_id", property="voteId", jdbcType= JdbcType.VARCHAR),
        @Result(column="poll", property="poll", jdbcType= JdbcType.INTEGER)
    })
    List<Option> selectByExample(OptionExample example);

    @Select({
        "select",
        "id, option, vote_id, poll",
        "from option",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="option", property="option", jdbcType= JdbcType.VARCHAR),
        @Result(column="vote_id", property="voteId", jdbcType= JdbcType.VARCHAR),
        @Result(column="poll", property="poll", jdbcType= JdbcType.INTEGER)
    })
    Option selectByPrimaryKey(String id);

    @UpdateProvider(type= OptionSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Option record, @Param("example") OptionExample example);

    @UpdateProvider(type= OptionSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Option record, @Param("example") OptionExample example);

    @UpdateProvider(type= OptionSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Option record);

    @Update({
        "update option",
        "set option = #{option,jdbcType=VARCHAR},",
          "vote_id = #{voteId,jdbcType=VARCHAR},",
          "poll = #{poll,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(Option record);
}