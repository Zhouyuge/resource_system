package com.bishe.main.controller;

import com.bishe.main.entity.Note;
import com.bishe.main.entity.SquareTitle;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.SquareServer;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Kirito
 * @Date 2020/4/6 20:11
 */
@RestController
@RequestMapping("/square/api")
public class SquareController {
    @Autowired
    private SquareServer squareServer;

    @ApiOperation("分页获取试题")
    @GetMapping("/squares/{page_num}")
    public Result<Page<SquareTitle>> getSquareTitles(@PathVariable("page_num")Integer pageNum){
        Result<Page<SquareTitle>> result = Result.success(squareServer.getSqaureTitles(pageNum));
        result.setPage(squareServer.getPageNums());
        return result;
    }

    @ApiOperation("上传图片")
    @PostMapping("/upload")
    public Result<Map> uploadPicture(@RequestBody MultipartFile file) {
        Result<Map> result = null;
        if ( ! file.isEmpty()) {
            Map<String, Object> data = new HashMap<>();
            try {
                String filePath = "D://niuke/square_img/";
                File file1 = new File(filePath);
                if( !file1.exists()){
                    file1.mkdirs();
                }
                filePath += file.getOriginalFilename();

                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(new File(filePath)));
                out.write(file.getBytes());
                out.close();

                data.put("src", "http://localhost:10086/img/square_img/" + file.getOriginalFilename());
                result = new Result<Map>(data, "", 0);
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        return result;
    }


    @ApiOperation("获取试题详情")
    @GetMapping("/square/{id}")
    public Result<SquareTitle> getSquareTitleById(@PathVariable("id") Integer id){
        return Result.success(squareServer.getSquareTitleById(id));
    }

    @ApiOperation("添加试题")
    @PostMapping("/square")
    public Result addSquare(@RequestBody SquareTitle squareTitle){
        return Result.success(squareServer.insertSquare(squareTitle));
    }

    @ApiOperation("添加试题笔记")
    @PostMapping("/note")
    public Result addNote(@RequestBody Note note){
        note.setCreateTime(new Date());
        return Result.success(squareServer.addNote(note));
    }


    @ApiOperation("删除试题笔记")
    @DeleteMapping("/note")
    public Result deleteNote(@RequestParam Integer id){
        return Result.success(squareServer.deleteNode(id));
    }


    @ApiOperation("获取笔记")
    @GetMapping("/note/{userId}/{id}")
    public Result getNote(@PathVariable("id") Integer id, @PathVariable("userId")String userId){
        HashMap<String, Object> params = new HashMap<>();
        params.put("userId", userId);
        params.put("titleId", id);
        return Result.success(squareServer.getNote(params));
    }
}
