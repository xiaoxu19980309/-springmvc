package com.example.springbootdemo.pojo;

import java.util.List;

public class GoodsType {
    private Integer id;
    private String type_name;
    private String note;
    private Integer is_active;
    private Integer is_delete;
    private List<Goods> goodsList;
    private String gmt_create;
    private String gmt_modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
    }
    public Integer getIs_delete() {
        return is_delete;
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

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
    }

    public List<Goods> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<Goods> goodsList) {
        this.goodsList = goodsList;
    }

    @Override
    public String toString() {
        return "GoodsType{" +
                "id=" + id +
                ", type_name='" + type_name + '\'' +
                ", note='" + note + '\'' +
                ", is_delete=" + is_delete +
                ", gmt_create='" + gmt_create + '\'' +
                ", gmt_modified='" + gmt_modified + '\'' +
                '}';
    }
}
