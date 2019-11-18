package com.bishe.main.service.impl;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.bishe.main.dao.CoinWareMapper;
import com.bishe.main.dto.CoinWareDto;
import com.bishe.main.dto.EtileCategoryDto;
import com.bishe.main.entity.CoinWare;
import com.bishe.main.entity.CoinWareExample;
import com.bishe.main.enums.CoinWareTypeEnum;
import com.bishe.main.service.CoinWareService;
import com.bishe.main.util.AutoMapperUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Kirito
 * @Date 2019/11/13 13:45
 * 牛币商城服务
 */
@Service
public class CoinWareServiceImpl implements CoinWareService {

    @Autowired
    private CoinWareMapper coinWareMapper;

    private static Log log = LogFactory.get(CoinWareServiceImpl.class);

    @Override
    public List<CoinWareDto> getCoinWareDtos() {
        CoinWareExample wareExample = new CoinWareExample();
        List<CoinWare> coinWares = coinWareMapper.selectByExample(wareExample);
        List<CoinWareDto> coinWareDtoList = new ArrayList<>();
        if (coinWares != null) {
            AutoMapperUtil.mappingList(coinWares, coinWareDtoList, CoinWareDto.class);
            for (int index = 0; index < coinWareDtoList.size(); index++) {
                getType(coinWareDtoList.get(index), coinWares.get(index).getCoinWareType());
            }
            return coinWareDtoList;
        }
        return null;
    }

    @Override
    public CoinWareDto getCoinWareDtoById(Integer id) {
        if (id != null && id > 0) {
            CoinWare coinWare = coinWareMapper.selectByPrimaryKey(id);
            if (coinWare == null) {
                log.error("-----------mapper错误----------");
                return null;
            } else {
                CoinWareDto coinWareDto = new CoinWareDto();
                try {
                    AutoMapperUtil.mapping(coinWare, coinWareDto);
                    getType(coinWareDto, coinWare.getCoinWareType());
                } catch (Exception e) {
                    log.error(e.getMessage());
                    e.printStackTrace();
                }
                return coinWareDto;
            }

        } else {
            log.error("------------参数错误---------");
            return null;
        }
    }

    /**
     * 根据TypeId获取Type
     *
     * @param coinWareDto
     * @param typeId
     * @return
     */
    public void getType(CoinWareDto coinWareDto, Integer typeId) {
        switch (typeId) {
            case 1:
                coinWareDto.setCoinWareTypeName(CoinWareTypeEnum.SPECIAL.getValue());
                break;
            case 2:
                coinWareDto.setCoinWareTypeName(CoinWareTypeEnum.HOT_WARE.getValue());
                break;
            case 3:
                coinWareDto.setCoinWareTypeName(CoinWareTypeEnum.FACTORY.getValue());
                break;
            case 4:
                coinWareDto.setCoinWareTypeName(CoinWareTypeEnum.BOOKS.getValue());
                break;
        }
    }
}
