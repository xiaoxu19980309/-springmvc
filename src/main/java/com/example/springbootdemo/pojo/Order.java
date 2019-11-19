package com.example.springbootdemo.pojo;

import java.util.List;

public class Order {
    private Integer id;
    private Integer total_num;
    private Double total_price;
    private String order_id;
    private Integer user_id;
    private Integer pay_type;
    private Integer is_pay;
    private Integer is_delete;
    private String gmt_create;
    private String gmt_modified;
//    private List<OrderDetail> orderDetailList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTotal_num() {
        return total_num;
    }

    public void setTotal_num(Integer total_num) {
        this.total_num = total_num;
    }

    public Double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Double total_price) {
        this.total_price = total_price;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getPay_type() {
        return pay_type;
    }

    public void setPay_type(Integer pay_type) {
        this.pay_type = pay_type;
    }

    public Integer getIs_pay() {
        return is_pay;
    }

    public void setIs_pay(Integer is_pay) {
        this.is_pay = is_pay;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public String getGmt_create() {
        return gmt_create;
    }

    public void setGmt_create(String gmt_create) {
        this.gmt_create = gmt_create;
    }

    public String getGmt_modified() {
        return gmt_modified;
    }

    public void setGmt_modified(String gmt_modified) {
        this.gmt_modified = gmt_modified;
    }

//    public List<OrderDetail> getOrderDetailList() {
//        return orderDetailList;
//    }

//    public void setOrderDetailList(List<OrderDetail> orderDetailList) {
//        this.orderDetailList = orderDetailList;
//    }

    public Order() {

    }

    public Order(Integer total_num, Double total_price, String order_id, Integer user_id, Integer pay_type) {
        this.total_num = total_num;
        this.total_price = total_price;
        this.order_id = order_id;
        this.user_id = user_id;
        this.pay_type = pay_type;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", total_num=" + total_num +
                ", total_price=" + total_price +
                ", order_id='" + order_id + '\'' +
                ", user_id=" + user_id +
                ", pay_type=" + pay_type +
                ", is_pay=" + is_pay +
                ", is_delete=" + is_delete +
                ", gmt_create='" + gmt_create + '\'' +
                ", gmt_modified='" + gmt_modified + '\'' +
//                ", orderDetailList=" + orderDetailList +
                '}';
    }
}
