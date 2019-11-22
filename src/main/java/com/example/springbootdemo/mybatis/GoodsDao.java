package com.example.springbootdemo.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface GoodsDao {
    /**
     * Xudeng
     */
    @Insert("insert into goods(goods_name,goods_price,goods_num,main_pic,sub_pic,description,type_id,gmt_create,gmt_modified)" +
            "values(#{goods.goods_name},#{goods.goods_price},#{goods.goods_num},#{goods.main_pic},#{goods.sub_pic},#{goods.description},#{goods.type_id},now(),now())")
    int insertGoods(@Param("goods") Goods goods);

    @Results({@Result(column = "id",property = "id")})
    @Select("select * from goods WHERE id = #{good_id} AND is_delete=0")
    Goods selectGoods(@Param("good_id") Integer good_id);

    @Select("<script>select goods.id,goods_name,goods_price,goods_num,has_sold,main_pic,sub_pic,description,goods.type_id,goods.is_special,goods.is_delete,goods_type.type_name as typeName," +
            "DATE_FORMAT(goods.gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create,DATE_FORMAT(goods.gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified from goods " +
            "left join goods_type on goods.type_id=goods_type.id WHERE 1=1" +
            "<if test=\"goods.type_id!=null and goods.type_id!=0\">AND type_id = #{goods.type_id}</if>"+
            "<if test=\"status!=null and status!='0'\">" +
            "<if test=\"status==1\">AND goods_num>0 AND goods.is_delete=0</if>" +
            "<if test=\"status==2\">AND goods_num=0 AND goods.is_delete=0</if>" +
            "<if test=\"status==3\">AND goods.is_delete=1</if>" +
            "</if>" +
            "<if test=\"goods.hasnum!=null and goods.hasnum==1\">AND goods_num>0 </if>"+
            "<if test=\"goods.goods_name!=null and goods.goods_name!=''\">AND goods_name like concat('%',#{goods.goods_name},'%')</if>"+
            " </script>")
    List<Goods> selectGoodsListAll(@Param("goods") Goods goods,@Param("status") Integer status);

    @Update("<script>update goods set gmt_modified = now()" +
            "<if test=\"goods.goods_name!=null and goods.goods_name!=''\">,goods_name = #{goods.goods_name}</if>" +
            "<if test=\"goods.goods_price!=null\">,goods_price = #{goods.goods_price}</if>" +
            "<if test=\"goods.goods_num!=null\">,goods_num = #{goods.goods_num}</if>" +
            "<if test=\"goods.main_pic!=null and goods.main_pic!=''\">,main_pic = #{goods.main_pic}</if>" +
            "<if test=\"goods.sub_pic!=null and goods.sub_pic!=''\">,sub_pic = #{goods.sub_pic}</if>" +
            "<if test=\"goods.description!=null and goods.description!=''\">,description = #{goods.description}</if>" +
            "<if test=\"goods.type_id!=null\">,type_id = #{goods.type_id}</if>" +
            "<if test=\"goods.is_special!=null\">,is_special = #{goods.is_special}</if>" +
            "<if test=\"goods.is_delete!=null\">,is_delete = #{goods.is_delete}</if>" +
            "WHERE id = #{goods.id}"+
            "</script>")
    int updateGoods(@Param("goods") Goods goods);

    @Update("<script><foreach collection='goodsList' item='goods' index='key' separator=','>update goods set gmt_modified = now() " +
//            "<if test=\"goods.goods_name!=null and goods.goods_name!=''\">,goods_name = #{goods.goods_name}</if>" +
//            "<if test=\"goods.goods_price!=null\">,goods_price = #{goods.goods_price}</if>" +
            "<if test=\"goods.goods_num!=null and goods.goods_num>=0\">,goods_num = #{goods.goods_num}</if>" +
            "<if test=\"goods.has_sold!=null and goods.has_sold>=0\">,has_sold = #{goods.has_sold}</if>" +
//            "<if test=\"goods.main_pic!=null and goods.main_pic!=''\">,main_pic = #{goods.main_pic}</if>" +
//            "<if test=\"goods.sub_pic!=null and goods.sub_pic!=''\">,sub_pic = #{goods.sub_pic}</if>" +
//            "<if test=\"goods.description!=null and goods.description!=''\">,description = #{goods.description}</if>" +
//            "<if test=\"goods.type_id!=null\">,type_id = #{goods.type_id}</if>" +
//            "<if test=\"goods.is_special!=null\">,is_special = #{goods.is_special}</if>" +
//            "<if test=\"goods.is_delete!=null\">,is_delete = #{goods.is_delete}</if>" +
            "WHERE id = #{goods.id}"+
            "</foreach></script>")
    int updateGoodsList(@Param("goodsList") List<JSONObject> goodsList);

    @Results(@Result(property = "id",column = "id"))
    @Select("select * from goods where type_id =#{type_id} AND is_delete=0")
    List<Goods> getGoodsByTypeId(@Param("type_id") Integer type_id);
}
