package com.bishe.main.controller;

import com.bishe.main.entity.ProjectAction;
import com.bishe.main.entity.ProjectDemo;
import com.bishe.main.entity.TechFile;
import com.bishe.main.entity.User;
import com.bishe.main.entity.result.CodeMsg;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.ProjectActionSerivce;
import com.bishe.main.util.MapUtil;
import com.bishe.main.vo.TechnologeVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author Kirito
 * @Date 2020/2/19 12:34
 */
@RestController
@RequestMapping("/pa/api")
public class ProjectActionController {
    @Autowired
    private ProjectActionSerivce projectActionSerivce;

    @ApiOperation("获取所有(20个)的实战项目信息")
    @GetMapping("/projects")
    public Result<List> getProjects() {
        List<ProjectAction> projectActions = projectActionSerivce.getProjectActions();
        System.out.println(projectActions.size());
        Result<List> result = Result.success(projectActions);
        return result;
    }

    @ApiOperation("根据id获取实战项目信息")
    @GetMapping("/project/{id}")
    public Result<ProjectAction> getProjectById(@PathVariable("id") Integer id){
        ProjectAction projectAction = projectActionSerivce.getProjectActionById(id);
        Result<ProjectAction> projectActionResult = Result.success(projectAction);
        return projectActionResult;
    }

    @ApiOperation("文件上传")
    @PostMapping("/upload")
    public Map<String, Object> fileUpload(@RequestParam("file") MultipartFile file, @RequestParam("id") Integer id, HttpServletRequest request) {
        if(! file.isEmpty()) {
            ProjectDemo projectDemo = new ProjectDemo();
            ProjectAction projectAction = projectActionSerivce.getProjectActionById(id);
            try {
                String filePath = "D://demo//" + projectAction.getActionName().split(" ")[0] + "//";
                File pdfFile = new File(filePath);
                if(! pdfFile.exists()) {
                    pdfFile.mkdirs();
                }
                String type = file.getOriginalFilename().split("\\.")[1];
                if(! type.equals("java") && ! type.equals("jar") && ! type.equals("c++") && ! type.equals("py")) {
                    return MapUtil.errMsg("仅支持.java、.jar、.c++、.py文件");
                }
                filePath += file.getOriginalFilename();
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                out.write(file.getBytes());
                out.close();

                projectDemo.setDemoUrl("http://localhost:9526/demo/" + projectAction.getActionName().split(" ")[0] + "/" +file.getOriginalFilename());
                projectDemo.setDemoName(file.getOriginalFilename());
                User user = (User)request.getSession().getAttribute("user");
                projectDemo.setUserId(user.getUserId());
                projectDemo.setUploadTime(new Date());
                projectDemo.setProjectId(id);
                projectDemo.setDemoDownUrl("D://download");
                projectDemo.setDemoStatus(1);
                projectActionSerivce.insertDemo(projectDemo);

                return MapUtil.sucMsg( file.getOriginalFilename() + "上传成功");
            } catch (Exception e){
                e.printStackTrace();
                return MapUtil.errMsg( file.getOriginalFilename() +  "上传失败");
            }
        } else {
            return MapUtil.errMsg("文件为空");
        }
    }

    @ApiOperation("文件下载")
    @PostMapping("/download")
    public Result<String> download(@RequestBody ProjectDemo projectDemo, HttpServletResponse response) throws IOException {
        String downLoadFilePath = projectDemo.getDemoUrl();
        String fileName = projectDemo.getDemoName();

        //获取文件URL
        URL url = new URL(downLoadFilePath);
        //获得连接
        URLConnection connection = url.openConnection();
        if(connection.getContent() != null) {
            byte[] buffer = new byte[1024];
            InputStream is = null;
            BufferedInputStream bis = null;
            try {
                is = connection.getInputStream();
                bis = new BufferedInputStream(is);
                BufferedOutputStream os = new BufferedOutputStream(new FileOutputStream(projectDemo.getDemoDownUrl() + File.separator + projectDemo.getDemoName()));

                int i = bis.read(buffer);
                while(i != -1) {
                    os.write(buffer, 0, i);
                    i = bis.read(buffer);
                }
                return Result.success("下载成功");
            } catch (Exception e) {
                e.printStackTrace();
            }finally {
                if (bis != null) {
                    bis.close();
                }

                if(is != null) {
                    is.close();
                }
            }
        }
        return Result.error(CodeMsg.SERVER_ERROR);
    }

    @ApiOperation("获取我上传的源码列表")
    @GetMapping("/mine_demo/{project_id}")
    public Result<List> getMineDemoList(@PathVariable("project_id")Integer projectId, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        String userId = user.getUserId();
        return Result.success(projectActionSerivce.getMineProjectDemoVOS(projectId, userId));
    }


    @ApiOperation("获取除我外上传的源码列表")
    @GetMapping("/no_mine_demo/{project_id}")
    public Result<List> getNotMineDemoList(@PathVariable("project_id")Integer projectId, HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("user");
        String userId = user.getUserId();
        return Result.success(projectActionSerivce.getNotMineProjectDemoVOS(projectId, userId));
    }

    @ApiOperation("删除项目源码")
    @DeleteMapping("/project_demo")
    public Result<String> deleteProjectDemo(@RequestParam Integer demoId){
        projectActionSerivce.deleteMineProjectDemo(demoId);
        return Result.success("删除成功");
    }
}
