package com.example.springbootdemo.service.impl;

import com.example.springbootdemo.mybatis.ActivePartDao;
import com.example.springbootdemo.pojo.IndexModel;
import com.example.springbootdemo.service.PartServiecs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartServiceImpl implements PartServiecs {

    @Autowired
    private ActivePartDao activePartDao;

    @Override
    public List<IndexModel> getPartsAll() {
        List<IndexModel> indexModels = null;
        indexModels = activePartDao.selectParts();
        return indexModels;
    }

    @Override
    public int addPart(IndexModel indexModel) {
        int ans = 0;
        ans = activePartDao.insertPart(indexModel);
        return ans;
    }

    @Override
    public int updatePart(IndexModel indexModel) {
        int ans = 0;
        ans =activePartDao.updatePart(indexModel);
        return ans;
    }

    @Override
    public int deletePart(Integer id) {
        int ans=0;
        ans = activePartDao.deletePart(id);
        return ans;
    }

    @Override
    public IndexModel selectPart(Integer id) {
        IndexModel indexModel = null;
        indexModel = activePartDao.selectPart(id);
        return indexModel;
    }
}
