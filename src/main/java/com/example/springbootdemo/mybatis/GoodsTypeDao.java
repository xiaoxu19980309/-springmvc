package com.example.springbootdemo.mybatis;

import com.example.springbootdemo.pojo.GoodsType;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodsTypeDao {
    /**
     * Xudeng
     */
    @Select("select id,type_name,is_active,is_delete,note,DATE_FORMAT(gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create,DATE_FORMAT(gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified from goods_type WHERE is_delete!=1")
    List<GoodsType> queryGoodsType();

    @Insert("insert into goods_type(type_name,note,gmt_create,gmt_modified) values(#{goodsType.type_name},#{goodsType.note},now(),now())")
    int insertGoodsType(@Param("goodsType") GoodsType goodsType);

    @Update("<script>update goods_type set gmt_modified = now()"+
            "<if test=\"goodsType.type_name!=null and goodsType.type_name!=''\">,type_name = #{goodsType.type_name}</if>"+
            "<if test=\"goodsType.is_active!=null\">,is_active = #{goodsType.is_active}</if>"+
            "<if test=\"goodsType.is_delete!=null\">,is_delete = #{goodsType.is_delete}</if>"+
            "<if test=\"goodsType.note!=null and goodsType.note!=''\">,note = #{goodsType.note}</if>"+
            " WHERE id = #{goodsType.id} </script>")
    int updateGoodsType(@Param("goodsType") GoodsType goodsType);

    @Delete("delete from goods_type WHERE id = #{id}")
    int deleteGoodsType(@Param("id") Integer id);
}
