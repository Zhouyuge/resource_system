package com.bishe.main.jsoup;

import cn.hutool.core.img.ImgUtil;
import com.bishe.main.dao.TechnologyMapper;
import com.bishe.main.entity.Technology;
import com.bishe.main.util.PicUtil;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @author Kirito
 * @Date 2020/2/1 10:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class JsoupTechnolege {

    @Autowired
    private TechnologyMapper technologyMapper;

    @Test
    public void test() throws Exception {
        Document doc = Jsoup.connect("https://www.nowcoder.com/stacks/244/248?page=1").maxBodySize(0).get();
        Elements techList = doc.select("div[class='tech-list']");
        Elements techItems = techList.select("a[class='tech-item']");
        int i = 36;
        for(Element element : techItems) {
            Technology technology = technologyMapper.selectByPrimaryKey(i);
            String url = element.attr("abs:href");
            doc = Jsoup.connect(url).maxBodySize(0).get();
            String content = doc.select("div[class='tech-intr-detail']").select("p").text();
            technology.setTechnologyIntroduction(content);
            technologyMapper.updateByPrimaryKeySelective(technology);
            i++;
        }
    }
}
