package com.example.springbootdemo.pojo;

public class GoodsType {
    private Integer id;
    private String type_name;
    private String note;
    private Integer is_delete;
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

    public Integer getIs_delete() {
        return is_delete;
    }

    public void setIs_delete(Integer is_delete) {
        this.is_delete = is_delete;
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
