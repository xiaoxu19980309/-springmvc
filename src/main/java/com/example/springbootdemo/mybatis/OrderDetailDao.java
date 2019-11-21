package com.example.springbootdemo.mybatis;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.pojo.OrderDetail;
import org.apache.ibatis.annotations.*;

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

    @Results({
            @Result(column = "good_id",property = "goods",one = @One(select = "com.example.springbootdemo.mybatis.GoodsDao.selectGoods")),
            @Result(column = "id",property = "id"),
            @Result(column = "good_id",property = "good_id"),
    })
    @Select("<script>select detail.id,detail.good_id,detail.name,detail.price," +
            "IFNULL(SUM(IFNULL(detail.number,0)),0) as total_number," +
            "IFNULL(SUM(IFNULL(detail.itemcount,0)),0) as total_price," +
            "DATE_FORMAT(detail.gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create," +
            "DATE_FORMAT(detail.gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified from orderdetail detail WHERE 1=1" +
            "<if test=\"startTime!=null and startTime!='' and endTime!=null and endTime!=''\">AND gmt_create between #{startTime} and #{endTime}</if>" +
            "<if test=\"goods_name!=null and goods_name!=''\">AND name like concat('%',#{goods_name},'%')</if>" +
            "GROUP BY good_id</script>" +
            "")
    List<OrderDetail> selectStaticNumbers(@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("goods_name")String goods_name);
}
