package com.example.springbootdemo.pojo;

public class ShoppingCar {
    private Integer id;
    private Integer user_id;
    private Integer good_id;
    private Integer count;
    private Integer is_delete;
    private String gmt_create;
    private String gmt_modified;
    private String goods_name;
    private Double goods_price;
    private Integer goods_num;
    private String main_pic;
    private String sub_pic;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public Integer getGood_id() {
        return good_id;
    }

    public void setGood_id(Integer good_id) {
        this.good_id = good_id;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public Double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(Double goods_price) {
        this.goods_price = goods_price;
    }

    public Integer getGoods_num() {
        return goods_num;
    }

    public void setGoods_num(Integer goods_num) {
        this.goods_num = goods_num;
    }

    public String getMain_pic() {
        return main_pic;
    }

    public void setMain_pic(String main_pic) {
        this.main_pic = main_pic;
    }

    public String getSub_pic() {
        return sub_pic;
    }

    public void setSub_pic(String sub_pic) {
        this.sub_pic = sub_pic;
    }

    public ShoppingCar(Integer user_id, Integer good_id, Integer count) {
        this.user_id = user_id;
        this.good_id = good_id;
        this.count = count;
    }

    public ShoppingCar() {
    }
}
