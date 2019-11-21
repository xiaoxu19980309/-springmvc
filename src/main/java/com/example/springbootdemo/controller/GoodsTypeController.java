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

    @RequestMapping(value = "/addGoodsType",method = RequestMethod.POST)
    public Result addGoodsType(@RequestParam String type_name,@RequestParam(required = false) String note){
        GoodsType goodsType = new GoodsType();
        int ans = 0;
        goodsType.setType_name(type_name);
        goodsType.setNote(note);
        try{
            ans = goodsTypeServices.addGoodsType(goodsType);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"添加商品类别成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"添加失败");
        }
    }

    @RequestMapping(value = "/deleteType",method = RequestMethod.POST)
    public Result deleteGoodsType(@RequestParam Integer id){
        int ans = 0;
        try{
            ans = goodsTypeServices.deleteGoodsType(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"删除成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"删除失败！");
        }
    }

    @RequestMapping(value = "updateGoodsType",method = RequestMethod.POST)
    public Result updateGoodsType(@RequestParam Integer id,@RequestParam(required = false) String type_name,
                                  @RequestParam(required = false) String note,@RequestParam(required = false) Integer is_active,
                                  @RequestParam(required = false) Integer is_delete){
        int ans =0;
        GoodsType goodsType = new GoodsType();
        goodsType.setId(id);
        goodsType.setNote(note);
        goodsType.setType_name(type_name);
        goodsType.setIs_active(is_active);
        goodsType.setIs_delete(is_delete);
        try{
            ans=goodsTypeServices.updateGoodsType(goodsType);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"失败！");
        }
    }

}
