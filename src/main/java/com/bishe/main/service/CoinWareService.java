package com.bishe.main.service;

import com.bishe.main.dto.CoinWareDto;

import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/13 13:43
 */
public interface CoinWareService {

    List<CoinWareDto> getCoinWareDtos();

    CoinWareDto getCoinWareDtoById(Integer id);

}
