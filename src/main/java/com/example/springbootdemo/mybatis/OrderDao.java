package com.example.springbootdemo.mybatis;

import com.example.springbootdemo.pojo.Order;
import com.example.springbootdemo.pojo.OrderDetail;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderDao {
    /**
     * Xudeng
     * @param order
     * @return
     */
    @Insert("insert into orders(total_num,total_price,order_id,user_id,pay_type,is_pay,gmt_create,gmt_modified)" +
            "values(#{order.total_num},#{order.total_price},#{order.order_id},#{order.user_id},#{order.pay_type},#{order.is_pay},now(),now())")
    void insertOrder(@Param("order") Order order);

    @Select("select id,total_num,total_price,order_id,user_id,pay_type,is_pay,is_delete,DATE_FORMAT(gmt_create,'%Y-%m-%d %H:%i:%s')gmt_create," +
            "DATE_FORMAT(gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified from orders WHERE user_id = #{user_id} AND is_delete=0")
    List<Order> selectOrderList(@Param("user_id") Integer user_id);

    @Select("select id,order_id,good_id,name,price,number,itemcount,is_delete,DATE_FORMAT(gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create," +
            "DATE_FORMAT(gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified from orderdetail WHERE order_id = #{order_id} AND is_delete=0")
    List<OrderDetail> selectOrderDetailList(@Param("order_id") String order_id);

    @Select("select * from orders WHERE order_id = #{order_id}")
    Order selectOrderById(@Param("order_id") String order_id);

    @Update("<script>update orders set gmt_modified = now()" +
            "<if test=\"order.pay_type!=null\">,pay_type = #{order.pay_type}</if>" +
            "<if test=\"order.is_pay!=null\">,is_pay = #{order.is_pay}</if>" +
            "<if test=\"order.is_delete!=null\">,is_delete = #{order.is_delete}</if>" +
            "WHERE order_id = #{order.order_id}</script>")
    int updateOrder(@Param("order") Order order);
}
