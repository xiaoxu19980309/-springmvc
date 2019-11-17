package com.example.springbootdemo.mybatis;

import com.example.springbootdemo.pojo.ShoppingCar;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingCarDao {
    /**
     * Author Xudeng
     */
    @Insert("insert into shoppingcar(user_id,good_id,count,gmt_create,gmt_modified) " +
            "values(#{shoppingCar.user_id},#{shoppingCar.good_id},#{shoppingCar.count},now(),now())")
    int insertGoodsToCar(@Param("shoppingCar")ShoppingCar shoppingCar);
}
