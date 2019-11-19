package com.example.springbootdemo.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.pojo.ShoppingCar;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCarDao {
    /**
     * Author Xudeng
     */
    @Insert("insert into shoppingcar(user_id,good_id,count,gmt_create,gmt_modified) " +
            "values(#{shoppingCar.user_id},#{shoppingCar.good_id},#{shoppingCar.count},now(),now())")
    int insertGoodsToCar(@Param("shoppingCar")ShoppingCar shoppingCar);

    @Select("select shoppingcar.id,shoppingcar.user_id,shoppingcar.good_id,shoppingcar.count,DATE_FORMAT(shoppingcar.gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create," +
            "DATE_FORMAT(shoppingcar.gmt_modified,'%Y-%m-%d %H:%i:%s')gmt_modified,goods.goods_name,goods.goods_price,goods.main_pic,goods.sub_pic," +
            "goods.description,goods.goods_num" +
            " from shoppingcar left join goods on goods.id=shoppingcar.good_id WHERE shoppingcar.user_id = #{userId} AND shoppingcar.is_delete != 1")
    List<ShoppingCar> selectShoppingCar(@Param("userId") Integer userId);

    @Update("<script><foreach collection='goodsList' item='item' index='key' separator=','>" +
            "update shoppingcar set gmt_modified = now(),is_delete = 1 " +
            "WHERE user_id = #{user_id} AND good_id = #{item.id}" +
            "</foreach>" +
            "</script>")
    void updateShoppingCarList(@Param("goodsList")List<JSONObject> goodsList,@Param("user_id") Integer user_id);
}
