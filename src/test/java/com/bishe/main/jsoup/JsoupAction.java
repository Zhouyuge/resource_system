package com.bishe.main.jsoup;

import com.bishe.main.dao.ProjectActionMapper;
import com.bishe.main.entity.ProjectAction;
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

import java.util.Random;

/**
 * @author Kirito
 * @Date 2020/2/19 11:59
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class JsoupAction {
    @Autowired
    private ProjectActionMapper projectActionMapper;

    /**
     * 爬取项目实战 https://www.nowcoder.com/project/recommend
     */
    @Test
    public void test() throws Exception{
        Document doc = Jsoup.connect("https://www.nowcoder.com/project/recommend").maxBodySize(0).get();
        Elements projects = doc.select("div[class='p-reco-item']");
        for(Element project : projects) {
            String imgUrl = project.select("div[class='p-reco-pic']").select("a").select("img").attr("abs:src");
            String url = project.select("div[class='p-reco-pic']").select("a").attr("abs:href");
            String actionImg = "http://localhost:10086/img/action/" + PicUtil.downImages("D://niuke//action", imgUrl);
            String actionName = project.select("div[class='p-reco-title']").text();
            String label = project.select("span[class='p-reco-tag']").text();
            Integer hard = new Random().nextInt(2) + 1;
            doc = Jsoup.connect(url).maxBodySize(0).get();
            String detail = doc.select("div[class='module-body']").select("div[class='project-brief-txt']").text();
            String adviceTime = doc.select("div[class='project-status-main']").select("div[class='project-status-main']").text();
            ProjectAction projectAction = new ProjectAction();
            projectAction.setActionHard(hard);
            projectAction.setActionDetail(detail);
            projectAction.setActionImg(actionImg);
            projectAction.setActionName(actionName);
            projectAction.setActionType(label);
            projectAction.setActionProposeTime(adviceTime);
            projectActionMapper.insertSelective(projectAction);
        }
    }
}
