package com.bishe.main.service;

import com.bishe.main.vo.StockVO;
import com.github.pagehelper.Page;

/**
 * @author Kirito
 * @Date 2020/4/28 9:48
 */
public interface StockService {
    int operationStock(StockVO stockVO);

    Long getCount();

    Page<StockVO> getStockVOs(Integer pageNum);

    Page<StockVO> getStockVOsByCondition(Integer pageNum, String str);

}
