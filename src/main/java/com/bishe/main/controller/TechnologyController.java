package com.bishe.main.controller;

import com.bishe.main.entity.TechFile;
import com.bishe.main.entity.Technology;
import com.bishe.main.entity.User;
import com.bishe.main.service.TechnologeService;
import com.bishe.main.util.MapUtil;
import com.bishe.main.vo.TechnologeVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Map;
/**
 * @author Kirito
 * @Date 2020/2/1 16:20
 */
@RestController
@RequestMapping("/tech/api")
public class TechnologyController {
    @Autowired
    private TechnologeService technologeService;

    @ApiOperation("根据分类Id获取技术栈: 1.语言框架; 2.数据存储")
    @GetMapping("/technology/{id}")
    public Map<String, Object> getTechByTypeId(@PathVariable("id") Integer typeId) {
        try {
            return MapUtil.sucMsg(technologeService.getTechnologyByType(typeId));
        } catch (Exception e) {
            e.printStackTrace();
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("根据Id获取技术栈详情")
    @GetMapping("/tech/{id}")
    public Map<String, Object> getTechById(@PathVariable("id") Integer id) {
        try {
            return MapUtil.sucMsg(technologeService.getTechnologyById(id));
        } catch (Exception e) {
            e.printStackTrace();
            return MapUtil.errMsg("内部错误");
        }
    }

    @ApiOperation("文件上传")
    @PostMapping("/fileUpload")
    public Map<String, Object> fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id, HttpServletRequest request) {
        if(! file.isEmpty()) {
            TechnologeVO technology = technologeService.getTechnologyById(id);
            TechFile techFile = new TechFile();
            try {
                String filePath = "D://pdf//" + technology.getTechnologyName() + "//";
                File pdfFile = new File(filePath);
                if(! pdfFile.exists()) {
                    pdfFile.mkdirs();
                }
                filePath += file.getOriginalFilename();
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                out.write(file.getBytes());
                out.close();

                techFile.setFileDownUrl("http://localhost:9527/pdf/" + technology.getTechnologyName() + "/" +file.getOriginalFilename());
                techFile.setFileName(file.getOriginalFilename());
                User user = (User)request.getSession().getAttribute("user");
                techFile.setUserId(user.getUserId());
                techFile.setFileType(1);
                techFile.setTechnologyId(id);
                techFile.setUploadTime(new Date());
                techFile.setViewNum(0);
                technologeService.insertTechFile(techFile);

                return MapUtil.sucMsg( file.getName() + "上传成功");
            } catch (Exception e){
                e.printStackTrace();
                return MapUtil.errMsg( file.getName() +  "上传失败");
            }
        } else {
         return MapUtil.errMsg("文件为空");
        }
    }
}