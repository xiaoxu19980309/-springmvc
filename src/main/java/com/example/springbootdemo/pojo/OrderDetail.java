package com.example.springbootdemo.pojo;

public class OrderDetail {
    private Integer id;
    private String order_id;
    private String name;
    private Double price;
    private Integer number;
    private Double itemcount;
    private Integer is_delete;
    private String gmt_create;
    private String gmt_modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrder_id() {
        return order_id;
    }

    public void setOrder_id(String order_id) {
        this.order_id = order_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Double getItemcount() {
        return itemcount;
    }

    public void setItemcount(Double itemcount) {
        this.itemcount = itemcount;
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

    public OrderDetail() {
    }

    public OrderDetail(String order_id, String name, Double price, Integer number, Double itemcount) {
        this.order_id = order_id;
        this.name = name;
        this.price = price;
        this.number = number;
        this.itemcount = itemcount;
    }
}
