package com.example.springbootdemo.pojo;

public class IndexModel {
    private Integer id;
    private String part_name;
    private Integer is_active;
    private String gmt_create;
    private String gmt_modified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public Integer getIs_active() {
        return is_active;
    }

    public void setIs_active(Integer is_active) {
        this.is_active = is_active;
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

    public IndexModel(String part_name, Integer is_active) {
        this.part_name = part_name;
        this.is_active = is_active;
    }

    public IndexModel() {
    }

    @Override
    public String toString() {
        return "IndexModel{" +
                "id=" + id +
                ", part_name='" + part_name + '\'' +
                ", is_active=" + is_active +
                ", gmt_create='" + gmt_create + '\'' +
                ", gmt_modified='" + gmt_modified + '\'' +
                '}';
    }
}
