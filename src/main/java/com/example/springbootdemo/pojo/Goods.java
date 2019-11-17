package com.example.springbootdemo.pojo;

public class Goods {
    private Integer id;
    private String goods_name;
    private Double goods_price;
    private Integer goods_num;
    private String main_pic;
    private String sub_pic;
    private String description;
    private Integer type_id;
    private String typeName;
    private Integer is_special;
    private Integer is_delete;
    private String gmt_create;
    private String gmt_modified;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", goods_name='" + goods_name + '\'' +
                ", goods_price=" + goods_price +
                ", goods_num=" + goods_num +
                ", main_pic='" + main_pic + '\'' +
                ", sub_pic='" + sub_pic + '\'' +
                ", description='" + description + '\'' +
                ", type_id=" + type_id +
                ", is_special=" + is_special +
                ", is_delete=" + is_delete +
                ", gmt_create='" + gmt_create + '\'' +
                ", gmt_modified='" + gmt_modified + '\'' +
                '}';
    }

    public Goods(Integer id, String goods_name, Double goods_price, Integer goods_num, String main_pic, String sub_pic, String description, Integer type_id, Integer is_special, Integer is_delete) {
        this.id = id;
        this.goods_name = goods_name;
        this.goods_price = goods_price;
        this.goods_num = goods_num;
        this.main_pic = main_pic;
        this.sub_pic = sub_pic;
        this.description = description;
        this.type_id = type_id;
        this.is_special = is_special;
        this.is_delete = is_delete;
    }

    public Goods() {
    }
}
