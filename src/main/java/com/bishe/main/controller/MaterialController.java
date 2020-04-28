package com.bishe.main.controller;

import com.bishe.main.entity.Material;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.MaterialService;
import com.bishe.main.vo.MaterialVO;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/4/25 10:43
 */
@RestController
@RequestMapping("/mate")
public class MaterialController {
    @Autowired
    private MaterialService materialService;

    @ApiOperation("根据条件查询资源信息")
    @GetMapping("/mates/{pageNum}/{str}")
    public Result<List<MaterialVO>> getMaterialVOs(@PathVariable("str") String str, @PathVariable("pageNum") Integer pageNum){
        if (str.equals("null")) {
            str = null;
        }
        Result<List<MaterialVO>> result = Result.success(materialService.getMaterialVOs(str, pageNum));
        result.setPage(materialService.getCount().intValue());
        return result;
    }

    @ApiOperation("添加资源")
    @PostMapping("/mate")
    public Result insertMaterial(@RequestBody Material material){
        return Result.success(materialService.insertMaterial(material));
    }

    @ApiOperation("更改资源")
    @PutMapping("/mate")
    public Result updateMaterial(@RequestBody MaterialVO material){
        return Result.success(materialService.updateMaterial(material));
    }

    @ApiOperation("删除资源")
    @DeleteMapping("/mate/{id}")
    public Result deleteMaterial(@PathVariable("id") Integer id){
        return Result.success(materialService.deleteMaterial(id));
    }

    @ApiOperation("获取资源")
    @GetMapping("/mate/{id}")
    public Result getMaterial(@PathVariable("id") Integer id){
        return Result.success(materialService.getMaterial(id));
    }
}
