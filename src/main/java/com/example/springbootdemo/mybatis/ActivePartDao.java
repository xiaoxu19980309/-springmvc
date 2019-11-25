package com.example.springbootdemo.mybatis;

import com.example.springbootdemo.pojo.IndexModel;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ActivePartDao {
    @Insert("insert into activepart(part_name,is_active,gmt_create,gmt_modified) values(#{part.part_name},#{part.is_active},now(),now())")
    int insertPart(@Param("part") IndexModel part);

    @Results({
            @Result(column = "id",property = "id")
    })
    @Select("select id,part_name,is_active,DATE_FORMAT(gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create,DATE_FORMAT(gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified " +
            "from activepart WHERE id = #{id}")
    IndexModel selectPart(@Param("id") Integer id);

    @Select("select id,part_name,is_active,DATE_FORMAT(gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create,DATE_FORMAT(gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified" +
            " from activepart")
    List<IndexModel> selectParts();

    @Update("<script>update activepart set gmt_modified = now()" +
            "<if test=\"part.part_name!=null and part.part_name!=''\">,part_name = #{part.part_name}</if>" +
            "<if test=\"part.is_active!=null\">,is_active = #{part.is_active}</if>" +
            "</script>")
    int updatePart(@Param("part") IndexModel part);

    @Delete("delete from activepart WHERE id = #{id}")
    int deletePart(@Param("id") Integer id);
}
