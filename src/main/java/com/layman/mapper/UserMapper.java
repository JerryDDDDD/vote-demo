package com.layman.mapper;

import com.layman.pojo.User;
import com.layman.pojo.UserExample;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

import java.util.List;

public interface UserMapper {
    @SelectProvider(type= UserSqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    @DeleteProvider(type= UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    @Insert({
        "insert into user (id, open_id, ",
        "nick_name, gender, ",
        "country, province, ",
        "city, avatar_url)",
        "values (#{id,jdbcType=VARCHAR}, #{openId,jdbcType=VARCHAR}, ",
        "#{nickName,jdbcType=VARCHAR}, #{gender,jdbcType=INTEGER}, ",
        "#{country,jdbcType=VARCHAR}, #{province,jdbcType=VARCHAR}, ",
        "#{city,jdbcType=VARCHAR}, #{avatarUrl,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type= UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type= UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="open_id", property="openId", jdbcType= JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType= JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType= JdbcType.INTEGER),
        @Result(column="country", property="country", jdbcType= JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType= JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType= JdbcType.VARCHAR),
        @Result(column="avatar_url", property="avatarUrl", jdbcType= JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, open_id, nick_name, gender, country, province, city, avatar_url",
        "from user",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
        @Result(column="open_id", property="openId", jdbcType= JdbcType.VARCHAR),
        @Result(column="nick_name", property="nickName", jdbcType= JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType= JdbcType.INTEGER),
        @Result(column="country", property="country", jdbcType= JdbcType.VARCHAR),
        @Result(column="province", property="province", jdbcType= JdbcType.VARCHAR),
        @Result(column="city", property="city", jdbcType= JdbcType.VARCHAR),
        @Result(column="avatar_url", property="avatarUrl", jdbcType= JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(String id);

    @UpdateProvider(type= UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type= UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type= UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set open_id = #{openId,jdbcType=VARCHAR},",
          "nick_name = #{nickName,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=INTEGER},",
          "country = #{country,jdbcType=VARCHAR},",
          "province = #{province,jdbcType=VARCHAR},",
          "city = #{city,jdbcType=VARCHAR},",
          "avatar_url = #{avatarUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(User record);
}