package com.example.springbootdemo.mybatis;

import com.example.springbootdemo.pojo.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderDetailDao {
    @Insert("insert into orderDetail(order_id,name,price,number,itemcount,gmt_create,gmt_modified)" +
            "values(#{orderDetail.order_id},#{orderDetail.name},#{orderDetail.price},#{orderDetail.number},#{orderDetail.itemcount},now(),now())")
    int insertOrderDetail(@Param("orderDetail")OrderDetail orderDetail);
}
