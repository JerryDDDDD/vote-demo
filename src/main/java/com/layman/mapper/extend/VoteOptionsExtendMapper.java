package com.layman.mapper.extend;

import com.layman.mapper.VoteOptionsSqlProvider;
import com.layman.pojo.VoteOptions;
import com.layman.pojo.VoteOptionsExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface VoteOptionsExtendMapper {



//    @SelectProvider(type=VoteOptionsExtendSqlProvider.class, method="selectVoteOptionByExample")
    @Select("<script>" +
            "SELECT vote_option from vote_options WHERE ((vote_id = #{id}))" +
            "</script>")
    List<String> selectVoteOptionByExample(String id);
}