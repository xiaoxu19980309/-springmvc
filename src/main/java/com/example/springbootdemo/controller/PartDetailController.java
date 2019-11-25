package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.ModelContent;
import com.example.springbootdemo.service.PartContentServices;
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
@RequestMapping(value = "/api/partDetail")
public class PartDetailController {
    @Autowired
    private PartContentServices partContentServices;

    @RequestMapping(value = "/getPartDetailList",method = RequestMethod.POST)
    public Result getPartDetailList(@RequestParam Integer part_id,@RequestParam(defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageInfo<ModelContent> modelContentPageInfo = null;
        try{
            modelContentPageInfo = PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->this.partContentServices.getModelContentList(part_id));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(modelContentPageInfo!=null){
            return Result.success(modelContentPageInfo,"获取模块内容成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"获取模块内容失败！");
        }
    }

    @RequestMapping(value = "/addPartDetail",method = RequestMethod.POST)
    public Result addPartDetail(@RequestParam Integer part_id,@RequestParam Integer goods_id){
        int ans = 0;
        ModelContent modelContent = new ModelContent(part_id,goods_id);
        try{
            ans = partContentServices.addPartDetail(modelContent);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"添加模块内容成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"添加模块内容失败！");
        }
    }

    @RequestMapping(value = "/deletePartDetail",method = RequestMethod.POST)
    public Result deletePartDetail(@RequestParam Integer id){
        int ans = 0;
        try{
            ans = partContentServices.deletePartDetail(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"删除成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"删除失败！");
        }
    }
}
