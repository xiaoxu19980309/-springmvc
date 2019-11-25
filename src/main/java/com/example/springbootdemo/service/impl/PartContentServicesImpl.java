package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mybatis.PartDetailDao;
import com.example.springbootdemo.pojo.ModelContent;
import com.example.springbootdemo.service.PartContentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartContentServicesImpl implements PartContentServices {
    @Autowired
    private PartDetailDao partDetailDao;

    @Override
    public List<ModelContent> getModelContentList(Integer part_id) {
        List<ModelContent> modelContents = null;
        modelContents = partDetailDao.selectPartContent(part_id);
        return modelContents;
    }

    @Override
    public int addPartDetail(ModelContent modelContent) {
        int ans = 0;
        ans = partDetailDao.insertPartDetail(modelContent);
        return ans;
    }

    @Override
    public int deletePartDetail(Integer id) {
        int ans = 0;
        ans = partDetailDao.deletePartDetail(id);
        return ans;
    }
}
