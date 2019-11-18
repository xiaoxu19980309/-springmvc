package com.example.springbootdemo.mybatis;

import com.example.springbootdemo.pojo.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDao {
    @Insert("insert into order(total_num,total_price,order_id,user_id,pay_type,gmt_create,gmt_modified)" +
            "values(#{order.total_num},#{order.total_price},#{order.order_id},#{order.user_id},#{order.pay_type},now(),now())")
    int insertOrder(@Param("order") Order order);
}
