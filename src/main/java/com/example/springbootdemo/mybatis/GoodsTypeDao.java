package com.example.springbootdemo.mybatis;

import com.example.springbootdemo.pojo.GoodsType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsTypeDao {
    /**
     * Xudeng
     */
    @Select("select * from goods_type")
    List<GoodsType> queryGoodsType();

    @Insert("insert into goods_type(type_name,note,gmt_create,gmt_modified) values(#{type_name},#{note},now(),now())")
    int insertGoodsType(@Param("type_name") String type_name,@Param("note") String note);

    @Update("update goods_type set type_name = #{type_name} ,gmt_modified = now()")
    int updateGoodsType(@Param("type_name") String type_name);

    @Delete("delete from goods_type WHERE id = #{id}")
    int deleteGoodsType(@Param("id") Integer id);
}
