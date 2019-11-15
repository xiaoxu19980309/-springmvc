package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.GoodsType;
import com.example.springbootdemo.service.GoodsTypeServices;
import com.example.springbootdemo.tools.ResponseCode;
import com.example.springbootdemo.tools.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/goodsType")
public class GoodsTypeController {
    @Autowired
    private GoodsTypeServices goodsTypeServices;

    @RequestMapping(value = "/getTypeList",method = RequestMethod.POST)
    public Result getTypeList(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10")int pageSize){
        PageInfo<GoodsType> pageInfo=null;
        try{
            pageInfo = PageHelper.startPage(pageNum,pageSize).setOrderBy("id asc").doSelectPageInfo(()->this.goodsTypeServices.queryType());
        }catch(Exception e){
            e.printStackTrace();
        }
        if(pageInfo!=null){
            return Result.success(pageInfo,"获取商品类别列表成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"失败");
        }
    }
}
