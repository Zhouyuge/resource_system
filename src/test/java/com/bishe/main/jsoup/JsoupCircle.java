package com.bishe.main.jsoup;

import com.bishe.main.dao.CircleMapper;
import com.bishe.main.entity.Circle;
import com.bishe.main.enums.CircleTypeEnum;
import com.bishe.main.service.CircleService;
import com.bishe.main.util.PicUtil;
import com.bishe.main.vo.CircleVO;
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
import java.util.List;

/**
 * @author Kirito
 * @Date 2020/2/4 16:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class JsoupCircle {

    @Autowired
    private CircleMapper circleMapper;

    @Autowired
    private CircleService circleService;

    @Test
    public void test() throws  Exception{
        Document doc = Jsoup.connect("https://www.nowcoder.com/circle").maxBodySize(0).get();
        Elements lis = doc.select("div[class='module-box explore-group-mod']").select("ul[class='group-list']").select("li");
        for(Element li : lis) {
            Circle circle = new Circle();
            String name = li.select("div[class='explore-group-info']").select("p[class='txt']").text();
            String detailUrl = li.select("a").select("a[class='pic']").attr("abs:href");
            doc = Jsoup.connect(detailUrl).maxBodySize(0).get();
            String imgUrl = doc.select("div[class='group-introduce']").select("div[class='pic']").select("img").attr("src");
            String detail = doc.select("div[class='group-introduce']").select("div[class='main']").select("div[class='intr']").select("p").text();
            String url = "http://localhost:10086/img/cir_img/" + PicUtil.downImages("D://niuke//cir_img", imgUrl);
            String label = doc.select("div[class='group-introduce']").select("div[class='tag-box']").select("a").text();

            circle.setCircleUserId("6aca7cbe-dff0-4342-a4f4-c7ad86699c4b");
            circle.setCreateTime(new Date());
            circle.setCircleInstruction(detail);
            circle.setCircleUserNum(0);
            circle.setCircleName(name);
            circle.setCirclePic(url);
            circle.setCircleLabel(label);
            circleMapper.insertSelective(circle);
        }
    }

    @Test
    public void test1() {
        List<Circle> circleVOList = circleService.getCircleVOs(0);
        System.out.println(circleVOList.size());
        for (Circle circleVO : circleVOList) {
            System.out.println(circleVO.toString());
        }
    }
}
