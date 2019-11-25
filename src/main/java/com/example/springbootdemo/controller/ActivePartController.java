package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.IndexModel;
import com.example.springbootdemo.service.PartServiecs;
import com.example.springbootdemo.tools.ResponseCode;
import com.example.springbootdemo.tools.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/api/part")
@RestController
public class ActivePartController {
    @Autowired
    private PartServiecs partServiecs;

    @RequestMapping(value = "/getPartList",method = RequestMethod.POST)
    public Result getPartList(@RequestParam (defaultValue = "1") int pageNum,@RequestParam(defaultValue = "10") int pageSize){
        PageInfo<IndexModel> indexModelPageInfo = null;
        try{
            indexModelPageInfo = PageHelper.startPage(pageNum,pageSize).doSelectPageInfo(()->this.partServiecs.getPartsAll());
        }catch (Exception e){
            e.printStackTrace();
        }
        if(indexModelPageInfo!=null){
            return Result.success(indexModelPageInfo,"获取首页模块成功!");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"获取首页模块失败！");
        }
    }

    @RequestMapping(value = "/addPart",method = RequestMethod.POST)
    public Result addPart(@RequestParam String part_name,@RequestParam Integer is_active){
        IndexModel indexModel = new IndexModel(part_name,is_active);
        int ans = 0;
        try{
            ans = partServiecs.addPart(indexModel);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"增加首页模块成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"添加失败！");
        }
    }

    @RequestMapping(value = "deletePart",method = RequestMethod.POST)
    public Result deletePart(@RequestParam Integer id){
        int ans = 0;
        try{
            ans = partServiecs.deletePart(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"删除成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"删除失败！");
        }
    }

    @RequestMapping(value = "/updatePart",method = RequestMethod.POST)
    public Result updatePart(@RequestParam (required = false) String part_name,@RequestParam(required = false) Integer is_active,@RequestParam Integer id){
        IndexModel indexModel = null;
        int ans = 0;
        indexModel = partServiecs.selectPart(id);
        if(indexModel == null){
            return Result.success(null,"找不到对应的模块");
        }else{
            indexModel.setPart_name(part_name);
            indexModel.setIs_active(is_active);
        }
        try{
            ans = partServiecs.updatePart(indexModel);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"更新成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"更新失败！");
        }
    }
}
