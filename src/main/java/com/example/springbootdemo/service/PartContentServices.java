package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.ModelContent;

import java.util.List;

public interface PartContentServices {
    List<ModelContent> getModelContentList(Integer part_id);
    int addPartDetail(ModelContent modelContent);
    int deletePartDetail(Integer id);
}
