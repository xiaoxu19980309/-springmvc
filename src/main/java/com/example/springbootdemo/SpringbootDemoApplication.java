package com.example.springbootdemo;

import com.example.springbootdemo.pojo.*;
import com.example.springbootdemo.service.GoodsServices;
import com.github.pagehelper.PageHelper;
import org.apache.commons.io.FileUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@SpringBootApplication
@Controller
@MapperScan("com.example.springbootdemo.mybatis")
public class SpringbootDemoApplication {

    @Autowired
    private GoodsServices goodsServices;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemoApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String homePage() throws Exception {
        return "index";
    }

    @RequestMapping(value = "/login")
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/register")
    public String register() {
        return "register";
    }

    @RequestMapping(value = "/allproducts")
    public String allproducts() {
        return "allproducts";
    }

    @RequestMapping(value = "/shopcar")
    public String shopcar(){ return "shopcar"; }

    @RequestMapping(value = "/pay_result")
    public String pay_result(){ return "pay_result"; }

    @RequestMapping(value = "/orderList")
    public String orderList(){ return "orderList"; }

    @RequestMapping(value = "/orderDetail")
    public String orderDetail(){ return "orderDetail"; }

    @RequestMapping(value = "/changePsw")
    public String changePsw(){ return "changePsw"; }


    @RequestMapping(value = "/proDetail")
    public String proDetail(Model model,@RequestParam String goodId){
        Goods goods = goodsServices.getGoods(Integer.valueOf(goodId));
        model.addAttribute("goods",goods);
        return "proDetail";
    }

    @PostMapping("/register_submit")
    public String register_submit(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("psw");
        String pswconfirm = request.getParameter("pswconfirm");
        if(!password.equals(pswconfirm)){

        }
        return "login";
    }

    @RequestMapping(value = "/uploadFile")
    public String uploadFile(Model model, HttpServletRequest request){
        String path = request.getParameter("path");
        String name = request.getParameter("name");
        if(path==null)
            path="";
        if(name==null)
            name="";
        System.out.println(path+"11111111"+name);
        model.addAttribute("path",path);
        model.addAttribute("name",name);
        return "uploadFile";
    }

    @RequestMapping(value="/upload",method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String upload(MultipartFile file, Model model, HttpServletRequest request) throws Exception {
        //接收文件数据
        String realpath = ("e:/upload/");
        try {
            //写入到磁盘中
            file.transferTo(new File(realpath,file.getOriginalFilename()));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(realpath);
        String href = realpath + file.getOriginalFilename();
        System.out.println(href);
        href = URLEncoder.encode(href,"utf-8");
        String name =URLEncoder.encode(file.getOriginalFilename(),"utf-8");
        return "redirect:uploadFile?path="+href+"&name="+name;
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName, HttpServletRequest request) throws IOException {
        //获取下载文件的路径，在文件中的真实路径
        String path=("e:/upload/");
        //下载文件的全路径
        File file=new File(path+File.separator+fileName);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String(fileName.getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);

    }

    @GetMapping("/field")
    public String field(Model model) {
        // 设置用户对象
        model.addAttribute("user", new User("crazyit", "lady"));
        // 设置性别常量，集合中存放字符串
        List<String> sexCons = new ArrayList<String>();
        sexCons.add("man");
        sexCons.add("lady");
        model.addAttribute("sexCons", sexCons);
        return "field";
    }

    @PostMapping("/field_submit")
    public String submit(@ModelAttribute User user) {
        System.out.println("表单对象: " + user.getUsername());
        return "index";
    }
}

