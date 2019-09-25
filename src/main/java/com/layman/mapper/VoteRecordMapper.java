package com.layman.mapper;

import com.layman.pojo.VoteRecord;
import com.layman.pojo.VoteRecordExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface VoteRecordMapper {
    @SelectProvider(type= VoteRecordSqlProvider.class, method="countByExample")
    long countByExample(VoteRecordExample example);

    @DeleteProvider(type= VoteRecordSqlProvider.class, method="deleteByExample")
    int deleteByExample(VoteRecordExample example);

    @Insert({
        "insert into vote_record (id, user_id, ",
        "vote_id, option_id)",
        "values (#{id,jdbcType=VARCHAR}, #{userId,jdbcType=VARCHAR}, ",
        "#{voteId,jdbcType=VARCHAR}, #{optionId,jdbcType=VARCHAR})"
    })
    int insert(VoteRecord record);

    @InsertProvider(type= VoteRecordSqlProvider.class, method="insertSelective")
    int insertSelective(VoteRecord record);

    @SelectProvider(type= VoteRecordSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType= JdbcType.VARCHAR),
        @Result(column="vote_id", property="voteId", jdbcType= JdbcType.VARCHAR),
        @Result(column="option_id", property="optionId", jdbcType= JdbcType.VARCHAR)
    })
    List<VoteRecord> selectByExample(VoteRecordExample example);

    @UpdateProvider(type= VoteRecordSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") VoteRecord record, @Param("example") VoteRecordExample example);

    @UpdateProvider(type= VoteRecordSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") VoteRecord record, @Param("example") VoteRecordExample example);
}