package shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/file")
public class fileController {
    @RequestMapping(value="/upload",method= RequestMethod.POST)
    @ResponseBody //不写会默认返回当前路径！！
    public String upload(MultipartFile file, HttpServletRequest request) throws Exception, IOException {
        //接收文件数据
        String realpath = request.getSession().getServletContext().getRealPath("/upload");
        try {
            //写入到磁盘中
            file.transferTo(new File(realpath,file.getOriginalFilename()));
        } catch (Exception e) {
            System.out.println(e);
        }
        return "redirect: uploadFile";
    }
}
