package com.bishe.main.controller;

import com.bishe.main.entity.MaterialCategory;
import com.bishe.main.entity.result.Result;
import com.bishe.main.service.CategoryService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.vo.CategoryVO;
import com.bishe.main.vo.MaterialVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kirito
 * @Date 2020/4/24 16:46
 */
@RestController
@RequestMapping("/cate")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @ApiOperation("分页获取资源分类信息")
    @GetMapping("/cates/{pageNum}")
    public Result getCategorys(@PathVariable("pageNum") Integer pageNum){
        Result result = Result.success(categoryService.getCategorys(pageNum));
        result.setPage(categoryService.getCount().intValue());
        return result;
    }

    @ApiOperation("插入资源分类信息")
    @PostMapping("/cate")
    public Result insertCategory(@RequestBody CategoryVO categoryVO){
        if (categoryVO.getUseStr().equals("1")) {
            categoryVO.setUseRepeat(true);
        } else {
            categoryVO.setUseRepeat(false);
        }
        MaterialCategory category = new MaterialCategory();
        AutoMapperUtil.mapping(categoryVO, category);

        return Result.success(categoryService.insertCategory(category));
    }

    @ApiOperation("根据id获取资源分类信息")
    @GetMapping("/cate/{id}")
    public Result getCategoryById(@PathVariable("id") Integer id){
        return Result.success(categoryService.getOneById(id));
    }

    @ApiOperation("更改资源分类信息")
    @PutMapping("/cate")
    public Result updateCategory(@RequestBody CategoryVO categoryVO){
        if (categoryVO.getUseStr().equals("1")) {
            categoryVO.setUseRepeat(true);
        } else {
            categoryVO.setUseRepeat(false);
        }
        MaterialCategory category = new MaterialCategory();
        AutoMapperUtil.mapping(categoryVO, category);
        return Result.success(categoryService.updateCategory(category));
    }

    @ApiOperation("删除资源分类信息")
    @DeleteMapping("/category/{id}")
    public Result delteCategory(@PathVariable("id") Integer id){
        return Result.success(categoryService.deleteById(id));
    }

    @ApiOperation("分页获取资源分类信息")
    @GetMapping("/cates/{pageNum}/{str}")
    public Result getCategorys(@PathVariable("pageNum") Integer pageNum, @PathVariable("str")String str){
        Result result = Result.success(categoryService.getCategorysByLike(str, pageNum));
        result.setPage(categoryService.getCount().intValue());
        return result;
    }

    @ApiOperation("获取所有资源分类信息")
    @GetMapping("/cates")
    public Result getAll(){
        return Result.success(categoryService.getAll());
    }
}
