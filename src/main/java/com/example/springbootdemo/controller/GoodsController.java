package com.example.springbootdemo.controller;

import com.example.springbootdemo.pojo.Goods;
import com.example.springbootdemo.service.GoodsServices;
import com.example.springbootdemo.tools.IdGenerator;
import com.example.springbootdemo.tools.ResponseCode;
import com.example.springbootdemo.tools.Result;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(value = "/api/goods")
public class GoodsController {
    @Autowired
    private GoodsServices goodsServices;

    public static File getImgDirFile(){
        String filePath = new String("src/main/resources/static/image");
        File fileDir = new File(filePath);
        if(!fileDir.exists()){
            fileDir.mkdirs();
        }
        return fileDir;
    }

    @RequestMapping(value = "/getGoodsList",method = RequestMethod.POST)
    public Result getGoodsList(@RequestParam(required = false) Integer type_id,@RequestParam(required = false) String goods_name,
                                @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10")int pageSize,
                                @RequestParam(required = false) Integer status){
        PageInfo<Goods> goodsPageInfo = null;
        Goods goods = new Goods();
        goods.setType_id(type_id);
        goods.setGoods_name(goods_name);
        try{
            goodsPageInfo = PageHelper.startPage(pageNum,pageSize).setOrderBy("id asc").doSelectPageInfo(()->this.goodsServices.getGoodsList(goods,status));
        }catch (Exception e){
            e.printStackTrace();
        }
        if(goodsPageInfo!=null){
            return Result.success(goodsPageInfo,"获取商品列表成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"获取商品列表失败");
        }
    }

    @RequestMapping(value = "/addGoods",method = RequestMethod.POST)
    public Result addGoods(@RequestParam String goods_name,@RequestParam Double goods_price,@RequestParam Integer goods_num,
                           @RequestParam(required = false) String main_pic,@RequestParam(required = false) String sub_pic,
                           @RequestParam(required = false) String description,@RequestParam Integer type_id){
        Goods goods = new Goods();
        goods.setGoods_name(goods_name);
        goods.setGoods_price(goods_price);
        goods.setGoods_num(goods_num);
        goods.setMain_pic(main_pic);
        goods.setSub_pic(sub_pic);
        goods.setDescription(description);
        goods.setType_id(type_id);
        int ans = 0;
        try{
            ans = goodsServices.addGoods(goods);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"添加商品成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"添加商品失败！");
        }
    }


    @RequestMapping(value = "/uploadFile",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Result uploadFile(HttpServletRequest request, @RequestParam("file")MultipartFile file){
        String fileName = file.getOriginalFilename();
        String prefix = fileName.substring(fileName.lastIndexOf("."));

        String s = IdGenerator.get();
        String fileNames = s+prefix;
        File fileDir = getImgDirFile();
        String absolutePath = fileDir.getAbsolutePath();
        File dest = new File(absolutePath+File.separator+fileNames);
        try{
            file.transferTo(dest);
            String url = absolutePath+File.separator+fileNames;
            return Result.success(url,"上传成功！");
        }catch (Exception e){
            return Result.fail(ResponseCode.ERROR.val(),"上传失败！");
        }
    }

    @RequestMapping(value = "/updateGoods",method = RequestMethod.POST)
    public Result updateGoods(@RequestParam Integer id,@RequestParam(required = false) String goods_name,@RequestParam(required = false) Double goods_price
                            ,@RequestParam(required = false) Integer goods_num,@RequestParam(required = false) String main_pic,
                              @RequestParam(required = false) String sub_pic,@RequestParam(required = false) String description,
                              @RequestParam(required = false) Integer type_id,@RequestParam(required = false) Integer is_special,
                              @RequestParam(required = false)Integer is_delete){
        Goods goods = new Goods(id,goods_name,goods_price,goods_num,main_pic,sub_pic,description,type_id,is_special,is_delete);
        int ans = 0;
        try{
            ans = goodsServices.updateGoods(goods);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(ans!=0){
            return Result.success(null,"修改商品信息成功！");
        }else{
            return Result.fail(ResponseCode.ERROR.val(),"修改失败！");
        }
    }
}
