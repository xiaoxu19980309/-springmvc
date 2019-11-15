package com.example.springbootdemo.mybatis;

import com.example.springbootdemo.pojo.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserDao{
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    @Select("select * from user WHERE username = #{username}")
    User queryUserByUserName(@Param("username") String username);

    @Select("select * from user WHERE username = #{username} AND is_admin = 1")
    User queryUserByUserNameAdmin(@Param("username") String username);

    /**
     * 查找所有用户
     * @return
     */
    @Select("<script>"+"select id,username,is_admin,is_delete,phone,gmt_create,gmt_modified from user WHERE 1=1 " +
            "<if test=\"username !=null and username != ''\"> AND username like concat('%',#{username},'%') </if> "
            +"<if test=\"phone != null  and phone != ''\"> AND phone like concat('%',#{phone},'%') </if> "+"</script>")
    List<User> queryUserAll(@Param("username") String username,@Param("phone") String phone);

    /**
     * 添加用户
     * @param
     */
    @Insert("insert into user(username,password,gmt_create,gmt_modified) values(#{username},#{password},now(),now())")
    int insertUser(@Param("username") String username,@Param("password") String password);

    /**
     * 更新用户
     * @param
     */
    @Update("<script>"+"update user set gmt_modified = now() "+
            "<if test=\"is_admin!=null and is_admin!=''\">,is_admin=#{is_admin} </if>"+
            "<if test=\"password !=null and password!=''\">,password=#{password} </if>"+
            "where username = #{username}"+"</script>")
    int updateUser(@Param("username") String username,@Param("password") String password,@Param("is_admin") Integer is_admin);

    /**
     * 删除用户
     */
    @Delete("delete from account where username = #{username}")
    public void deleteUser(@Param("username") String username);
}
