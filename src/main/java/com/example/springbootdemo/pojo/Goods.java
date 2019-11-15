package com.example.springbootdemo.pojo;

public class Goods {
    private Integer id;
    private String goods_name;
    private double goods_price;
    private Integer goods_num;
    private String main_pic;
    private String sub_pic;
    private String description;
    private Integer type_id;
    private Integer is_special;
    private Integer is_delete;

    public String getGoods_name() {
        return goods_name;
    }

    public void setGoods_name(String goods_name) {
        this.goods_name = goods_name;
    }

    public double getGoods_price() {
        return goods_price;
    }

    public void setGoods_price(double goods_price) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public Integer getIs_special() {
        return is_special;
    }

    public void setIs_special(Integer is_special) {
        this.is_special = is_special;
    }

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }
}
