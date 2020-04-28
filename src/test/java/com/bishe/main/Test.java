package com.bishe.main;

import com.bishe.main.entity.Material;
import com.bishe.main.mapper.MaterialMapper;
import com.bishe.main.service.MaterialService;
import com.bishe.main.util.AESUtil;
import com.bishe.main.vo.MaterialVO;
import com.github.pagehelper.Page;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Kirito
 * @Date 2020/4/24 10:27
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class Test {
    @Autowired
    private MaterialMapper materialMapper;

    @Autowired
    private MaterialService service;
    @org.junit.Test
    public void test(){
//        List<MaterialVO> materials = materialMapper.getMaterials(null);
//        System.out.println(materials.size());

        Page<MaterialVO> materialVOS = service.getMaterialVOs( null, 1);
        System.out.println(materialVOS.getResult().get(0).getCategoryName());
    }
}
