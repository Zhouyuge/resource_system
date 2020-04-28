package com.bishe.main.service.impl;

import com.bishe.main.entity.Stock;
import com.bishe.main.entity.result.CodeMsg;
import com.bishe.main.exception.RunException;
import com.bishe.main.mapper.StockMapper;
import com.bishe.main.service.StockService;
import com.bishe.main.util.AutoMapperUtil;
import com.bishe.main.vo.StockVO;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/4/28 10:03
 */
@Service
public class StockServiceImpl implements StockService {
    @Autowired
    private StockMapper stockMapper;

    private CodeMsg codeMsg;

    private final Integer PAGE_SIZE = 10;

    private Long count;

    @Override
    public Long getCount() {
        return count;
    }

    @Override
    public int operationStock(StockVO stockVO) {
        Stock stock = stockMapper.selectByPrimaryKey(stockVO.getStockId());
        // 入库操作
        if (stockVO.getType() == 1) {
            stock.setNumber(stock.getNumber() + stockVO.getNum());
        } else {
            // 出库操作
            stock.setNumber(stock.getNumber() - stockVO.getNum());
            if (stock.getNumber() < 0) {
                codeMsg = new CodeMsg(500, "该资源库存不足!");
                throw new RunException(codeMsg);
            }
        }
        // 转换
        return stockMapper.updateByPrimaryKeySelective(stock);
    }

    @Override
    public Page<StockVO> getStockVOs(Integer pageNum) {
        Page<StockVO> page = PageHelper.startPage(pageNum, PAGE_SIZE);
        List<StockVO> stockVOS = stockMapper.selectAll();
        count = page.getTotal();
        return page;
    }

    @Override
    public Page<StockVO> getStockVOsByCondition(Integer pageNum, String str) {
        Page<StockVO> page = PageHelper.startPage(pageNum, PAGE_SIZE);
        List<StockVO> stockVOS = stockMapper.selectByStr(str);
        count = page.getTotal();
        return page;
    }
}
