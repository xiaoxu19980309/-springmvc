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
    @Select("select * from user WHERE username = #{username} AND is_delete!=1")
    User queryUserByUserName(@Param("username") String username);

    @Select("select * from user WHERE id = #{id}")
    User selectUserById(@Param("id") Integer id);

    @Select("select * from user WHERE username = #{username} AND is_admin = 1 AND is_delete!=1")
    User queryUserByUserNameAdmin(@Param("username") String username);

    /**
     * 查找所有用户
     * @return
     */
    @Select("<script>"+"select user.id,username,is_admin,user.is_delete,phone,DATE_FORMAT(user.gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create," +
            "DATE_FORMAT(user.gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified,IFNULL(sum(IFNULL(total_num,0)),0) as total_num" +
            ",IFNULL(sum(IFNULL(total_price,0)),0) as total_price" +
            " from user left join orders on user.id=orders.user_id WHERE 1=1 " +
            "<if test=\"username !=null and username != ''\"> AND username like concat('%',#{username},'%')</if>" +
            "<if test=\"phone != null  and phone != ''\"> AND phone like concat('%',#{phone},'%') </if>"+
            "group by id</script>")
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
            "<if test=\"is_admin!=null\">,is_admin=#{is_admin} </if>"+
            "<if test=\"is_delete!=null\">,is_delete=#{is_delete} </if>"+
            "<if test=\"password !=null and password!=''\">,password=#{password} </if>"+
            "where username = #{username}"+"</script>")
    int updateUser(@Param("username") String username,@Param("password") String password,@Param("is_admin") Integer is_admin,@Param("is_delete") Integer is_delete);

    /**
     * 删除用户
     */
    @Delete("delete from user where username = #{username}")
    public void deleteUser(@Param("username") String username);
}
