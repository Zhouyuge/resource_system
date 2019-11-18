package com.bishe.main;


import com.bishe.main.dao.EtileMapper;
import com.bishe.main.entity.Etile;
import com.bishe.main.entity.EtileExample;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.ListableBeanFactoryExtensionsKt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class MianshiApplicationTests {
    @Autowired
    private EtileMapper etileMapper;

    @Test
    public void contextLoads() {
        int i = 0;
        EtileExample etileExample = new EtileExample();
        etileExample.or().andEtileNoEqualTo(12);
        List<Etile> etiles = etileMapper.selectByExample(etileExample);
        for (Etile etile : etiles) {
            etile.setEtileNoAli(++i);
            etileMapper.updateByPrimaryKey(etile);
        }
    }

}
