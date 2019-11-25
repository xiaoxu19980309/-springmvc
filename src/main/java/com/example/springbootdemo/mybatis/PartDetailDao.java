package com.example.springbootdemo.mybatis;

import com.example.springbootdemo.pojo.ModelContent;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.RequestParam;

import javax.swing.*;
import java.util.List;

@Mapper
public interface PartDetailDao {
    @Insert("insert into partdetail(part_id,goods_id,gmt_create,gmt_modified) values(#{content.part_id},#{content.goods_id},now(),now())")
    int insertPartDetail(@Param("content")ModelContent content);

    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "part_id",property = "part_id"),
            @Result(column = "part_id",property = "part",one = @One(select = "com.example.springbootdemo.mybatis.ActivePartDao.selectPart")),
            @Result(column = "goods_id",property = "goods",one = @One(select = "com.example.springbootdemo.mybatis.GoodsDao.selectGoods"))
    })
    @Select("select content.id,content.part_id,content.goods_id,DATE_FORMAT(content.gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create," +
            "DATE_FORMAT(content.gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified " +
            "from partdetail content WHERE content.part_id = #{part_id}")
    List<ModelContent> selectPartContent(@Param("part_id") Integer part_id);

    @Delete("delete from partdetail WHERE id = #{id}")
    int deletePartDetail(@Param("id") Integer id);
}
