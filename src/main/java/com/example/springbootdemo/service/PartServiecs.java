package com.example.springbootdemo.service;

import com.example.springbootdemo.pojo.IndexModel;

import java.util.List;

public interface PartServiecs {
    List<IndexModel> getPartsAll();
    int addPart(IndexModel indexModel);
    int updatePart(IndexModel indexModel);
    int deletePart(Integer id);
    IndexModel selectPart(Integer id);
}
