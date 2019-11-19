package com.example.springbootdemo.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.pojo.OrderDetail;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface OrderDetailDao {
    @Insert("<script>insert into orderDetail(order_id,good_id,name,price,number,itemcount,gmt_create,gmt_modified)" +
            "values" +
            "<foreach item='value' index='key' collection='goodsList' separator=','>" +
            "(#{order_id},#{value.id},#{value.goods_name},#{value.goods_price},#{value.count},#{value.itemcount},now(),now())" +
            "</foreach></script>")
    void insertOrderDetail(List<JSONObject> goodsList,@Param("order_id") String order_id);
}
