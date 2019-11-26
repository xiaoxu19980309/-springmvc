package com.example.springbootdemo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.springbootdemo.mybatis.GoodsDao;
import com.example.springbootdemo.mybatis.OrderDao;
import com.example.springbootdemo.mybatis.OrderDetailDao;
import com.example.springbootdemo.mybatis.ShoppingCarDao;
import com.example.springbootdemo.pojo.Goods;
import com.example.springbootdemo.pojo.Order;
import com.example.springbootdemo.pojo.OrderDetail;
import com.example.springbootdemo.service.OrderServices;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderServices {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private GoodsDao goodsDao;

    @Autowired
    private OrderDetailDao orderDetailDao;

    @Autowired
    private ShoppingCarDao shoppingCarDao;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int addOrder(Order order, JSONArray list) {
        int ans = 0;
        List<JSONObject> goodsList = new ArrayList<>();
        for(int i=0;i<list.size();i++){
            Integer id = JSONObject.parseObject(JSONObject.toJSONString(list.get(i))).getInteger("id");
            Double price = JSONObject.parseObject(JSONObject.toJSONString(list.get(i))).getDouble("price");
            Integer count = JSONObject.parseObject(JSONObject.toJSONString(list.get(i))).getInteger("count");
            JSONObject goods = (JSONObject) JSONObject.toJSON(goodsDao.selectGoods(id));
            goods.put("count",count);
            goods.put("goods_num",Integer.parseInt(goods.get("goods_num").toString())-count);
            if(goods.getInteger("goods_num")<0){
                ans = 2;
            }
            goods.put("has_sold",Integer.parseInt(goods.get("has_sold").toString())+count);
            goods.put("itemcount",price*count);
            goodsList.add(goods);
        }
        if(ans==2){
            return ans;
        }
        orderDao.insertOrder(order);
        String order_id = order.getOrder_id();
        orderDetailDao.insertOrderDetail(goodsList,order_id);
        ans = goodsDao.updateGoodsList(goodsList);
        shoppingCarDao.updateShoppingCarList(goodsList,order.getUser_id());
        return ans;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public List<Order> getOrdersList(Integer user_id) {
        List<Order> orderList = new ArrayList<>();
        orderList = orderDao.selectOrderList(user_id);
        return orderList;
    }

    @Override
    public List<OrderDetail> getOrderDetails(String order_id) {
        List<OrderDetail> orderDetails = new ArrayList<>();
        orderDetails = orderDao.selectOrderDetailList(order_id);
        return orderDetails;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteOrder(String order_id) {
        Order order = orderDao.selectOrderById(order_id);
        int ans = 0;
        order.setIs_delete(1);
        ans = orderDao.updateOrder(order);
        return ans;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateOrder(Order order) {
        int ans =0;
        ans = orderDao.updateOrder(order);
        return ans;
    }

    @Override
    public Order selectOrderById(String order_id) {
        Order order = null;
        order = orderDao.selectOrderById(order_id);
        return order;
    }

    @Override
    public List<Order> getOrderListAdmin(Order order,String startTime,String endTime) {
        List<Order> orderList = null;
        orderList = orderDao.selectOrderAdmin(order.getOrder_id(),startTime,endTime,order.getIs_pay());
        return orderList;
    }

    @Override
    public List<OrderDetail> getOrderStatics(String startTime, String endTime, String goods_name) {
        List<OrderDetail> orderDetailList = null;
        orderDetailList=orderDetailDao.selectStaticNumbers(startTime,endTime,goods_name);
        return orderDetailList;
    }
}
