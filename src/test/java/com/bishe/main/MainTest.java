package com.bishe.main;

import com.bishe.main.dto.BlogContentDto;
import com.bishe.main.dto.EtileCategoryDto;
import com.bishe.main.dto.EtileDto;
import com.bishe.main.entity.BlogCenter;
import com.bishe.main.entity.Etile;
import com.bishe.main.entity.EtileWithBLOBs;
import com.bishe.main.service.BlogCenterService;
import com.bishe.main.service.EtileService;
import com.bishe.main.service.UserService;
import com.github.pagehelper.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author Kirito
 * @Date 2019/11/7 14:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class MainTest {
    @Autowired
    private EtileService etileService;

    @Autowired
    private BlogCenterService blogCenterService;

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        List<? extends Etile> etileDtoPage = etileService.getEtileDtosByNo(1, 1, 20);
        for (Etile e : etileDtoPage) {
            EtileWithBLOBs e1 = (EtileWithBLOBs) e;
            System.out.println(e1.getEtitleQuestion());
        }
    }

    @Test
    public void testC() {
        List<EtileCategoryDto> etileCategoryDtos = etileService.getEtileCategorys();
        for (EtileCategoryDto e : etileCategoryDtos) {
            System.out.println(e.toString());
        }
    }

    /**
     * 测试博客专栏
     */
    @Test
    public void testBC() {
        List<BlogCenter> blogCenterList = blogCenterService.getBlogDtos(1, 0);
        System.out.println(blogCenterList.size());

        BlogContentDto blogContentDto = blogCenterService.getBlogContentDtoById(1);
        System.out.println(blogContentDto.toString());
    }

    @Test
    public void testT(){
        String token = "ef3cbbd7-1634-4f1f-8b08-468aaad23933";
        String str = userService.queryUserByToken(token);
        System.out.println(str);
    }

    @Test
    public void testRegex() {
        String s = "4.111汉字javaxx";
        String ss[] = s.split("\\D");
        for (String t : ss) {
            System.out.println(t);
        }
    }
}
