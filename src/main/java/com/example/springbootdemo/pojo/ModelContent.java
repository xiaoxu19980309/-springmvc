package com.example.springbootdemo.pojo;

public class ModelContent {
    private Integer id;
    private Integer part_id;
    private Integer goods_id;
    private String gmt_create;
    private String gmt_modified;

    private IndexModel part;
    private Goods goods;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPart_id() {
        return part_id;
    }

    public void setPart_id(Integer part_id) {
        this.part_id = part_id;
    }

    public Integer getGoods_id() {
        return goods_id;
    }

    public void setGoods_id(Integer goods_id) {
        this.goods_id = goods_id;
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

    public IndexModel getPart() {
        return part;
    }

    public void setPart(IndexModel part) {
        this.part = part;
    }

    public Goods getGoods() {
        return goods;
    }

    public void setGoods(Goods goods) {
        this.goods = goods;
    }

    public ModelContent() {
    }

    public ModelContent(Integer part_id, Integer goods_id) {
        this.part_id = part_id;
        this.goods_id = goods_id;
    }

    @Override
    public String toString() {
        return "ModelContent{" +
                "id=" + id +
                ", part_id=" + part_id +
                ", goods_id=" + goods_id +
                ", gmt_create='" + gmt_create + '\'' +
                ", gmt_modified='" + gmt_modified + '\'' +
                ", part=" + part +
                ", goods=" + goods +
                '}';
    }
}
