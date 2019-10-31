package shop.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

@Controller
@RequestMapping("/home")
public class indexController {
    @RequestMapping("/test")
    public String test() {
        return "test";
    }
    @RequestMapping("/login")
    public String login() {
        return "login";
    }
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    @RequestMapping("/register")
    public String register() {
        return "register";
    }
    @RequestMapping("/proDetail")
    public String proDetail() {
        return "proDetail";
    }
    @RequestMapping("/shopcar")
    public String shopcar() {
        return "shopcar";
    }
    @RequestMapping("/uploadFile")
    public String uploadFile(Model model, HttpServletRequest request){
        String path = request.getParameter("path");
        String name = request.getParameter("name");
        if(path==null)
            path="";
        if(name==null)
            name="";
        model.addAttribute("path",path);
        model.addAttribute("name",name);
        return "uploadFile";
    }
    @RequestMapping(value="/upload",method= RequestMethod.POST,produces = "text/plain;charset=utf-8")
    public String upload(MultipartFile file, Model model, HttpServletRequest request) throws Exception {
        //接收文件数据
        String realpath = request.getSession().getServletContext().getRealPath("/upload/");
        try {
            //写入到磁盘中
            file.transferTo(new File(realpath,file.getOriginalFilename()));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(realpath);
        String href = realpath + '\\' + file.getOriginalFilename();
        System.out.println(href);
        href = URLEncoder.encode(href,"utf-8");
        String name =URLEncoder.encode(file.getOriginalFilename(),"utf-8");
        return "redirect: uploadFile?path="+href+"&name="+name;
    }
    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(@RequestParam("fileName") String fileName,HttpServletRequest request) throws IOException {
            //获取下载文件的路径，在文件中的真实路径
            String path=request.getServletContext().getRealPath("/upload/");
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
}
