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

    @Results({
            @Result(column = "id",property = "id"),
            @Result(column = "good_id",property = "good_id"),
            @Result(column = "good_id",property = "goods",one = @One(select = "com.example.springbootdemo.mybatis.GoodsDao.selectGoods")),
    })
    @Select("select orderdetail.id,orderdetail.order_id,orderdetail.good_id,orderdetail.name,orderdetail.price,orderdetail.number,itemcount,orderdetail.is_delete," +
            "DATE_FORMAT(orderdetail.gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create," +
            "DATE_FORMAT(orderdetail.gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified from orderdetail WHERE order_id = #{order_id} AND orderdetail.is_delete=0")
    List<OrderDetail> selectOrderDetailList(@Param("order_id") String order_id);

    @Select("select * from orders WHERE order_id = #{order_id}")
    Order selectOrderById(@Param("order_id") String order_id);

    @Results({
            @Result(column = "id",property = "id")
    })
    @Select("<script>select orders.id,total_num,total_price,order_id,user_id,pay_type,is_pay,orders.is_delete,DATE_FORMAT(orders.gmt_create,'%Y-%m-%d %H:%i:%s') gmt_create," +
            "DATE_FORMAT(orders.gmt_modified,'%Y-%m-%d %H:%i:%s') gmt_modified,username from orders left join user on user.id=orders.user_id WHERE orders.is_delete=0" +
            "<if test=\"order_id!=null and order_id!=''\">AND order_id like concat('%',#{order_id},'%')</if>" +
            "<if test=\"startTime!=null and startTime!='' and endTime!=null and endTime!=''\">AND orders.gmt_create between #{startTime}" +
            "AND #{endTime}</if>" +
            "<if test=\"is_pay!=null\">" +
                "<if test=\"is_pay==1\">AND is_pay=#{is_pay}</if>" +
                "<if test=\"is_pay==0\">AND is_pay is null</if>" +
            "</if>" +
            "</script>")
    List<Order> selectOrderAdmin(@Param("order_id") String order_id,@Param("startTime") String startTime,@Param("endTime") String endTime,@Param("is_pay") Integer is_pay);

    @Update("<script>update orders set gmt_modified = now()" +
            "<if test=\"order.pay_type!=null\">,pay_type = #{order.pay_type}</if>" +
            "<if test=\"order.is_pay!=null\">,is_pay = #{order.is_pay}</if>" +
            "<if test=\"order.is_delete!=null\">,is_delete = #{order.is_delete}</if>" +
            "WHERE order_id = #{order.order_id}</script>")
    int updateOrder(@Param("order") Order order);
}
