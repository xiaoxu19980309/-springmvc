package com.example.springbootdemo.pojo;

public class ShoppingCar {
    private Integer id;
    private Integer user_id;
    private Integer good_id;
    private Integer count;
    private String gmt_create;
    private String gmt_modified;

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

    public ShoppingCar(Integer user_id, Integer good_id, Integer count) {
        this.user_id = user_id;
        this.good_id = good_id;
        this.count = count;
    }

    public ShoppingCar() {
    }
}
