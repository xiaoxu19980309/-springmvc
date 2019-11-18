package com.example.springbootdemo.mybatis;

import com.example.springbootdemo.pojo.ShoppingCar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

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
            " from shoppingcar left join goods on goods.id=shoppingcar.id WHERE shoppingcar.user_id = #{userId}")
    List<ShoppingCar> selectShoppingCar(@Param("userId") Integer userId);
}
