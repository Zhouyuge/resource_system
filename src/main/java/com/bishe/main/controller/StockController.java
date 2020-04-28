package com.bishe.main.controller;

import com.bishe.main.entity.result.Result;
import com.bishe.main.mapper.StockMapper;
import com.bishe.main.service.StockService;
import com.bishe.main.vo.StockVO;
import com.github.pagehelper.Page;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author Kirito
 * @Date 2020/4/28 10:12
 */

@RestController
@RequestMapping("/stock")
public class StockController {
    @Autowired
    private StockService stockService;

    @ApiOperation("分页获取库存信息")
    @GetMapping("/stocks/{pageNum}")
    public Result<Page<StockVO>> getStocks(@PathVariable("pageNum")Integer pageNum){
        Result<Page<StockVO>> result = Result.success(stockService.getStockVOs(pageNum));
        result.setPage(stockService.getCount().intValue());
        return result;
    }

    @ApiOperation("分页模糊查询库存信息")
    @GetMapping("/stocks/{pageNum}/{str}")
    public Result<Page<StockVO>> getStocks(@PathVariable("pageNum")Integer pageNum, @PathVariable("str")String str){
        Result<Page<StockVO>> result = Result.success(stockService.getStockVOsByCondition(pageNum, str));
        result.setPage(stockService.getCount().intValue());
        return result;
    }

    @ApiOperation("入库出库操作")
    @PutMapping("/operation")
    public Result operation(@RequestBody StockVO stockVO){
        return Result.success(stockService.operationStock(stockVO));
    }
}
