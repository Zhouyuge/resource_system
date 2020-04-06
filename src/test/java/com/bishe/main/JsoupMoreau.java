package com.bishe.main;

import com.bishe.main.dao.MoreauChapMapper;
import com.bishe.main.dao.MoreauContentMapper;
import com.bishe.main.dao.MoreauMapper;
import com.bishe.main.dao.SquareTitleMapper;
import com.bishe.main.entity.Moreau;
import com.bishe.main.entity.MoreauChap;
import com.bishe.main.entity.MoreauContent;
import com.bishe.main.entity.SquareTitle;
import com.bishe.main.util.PicUtil;
import com.bishe.main.vo.MoreauVO;
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
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author Kirito
 * @Date 2020/3/31 12:01
 */
@SpringBootTest
@MapperScan("com.bishe.main.dao")
@RunWith(SpringRunner.class)
public class JsoupMoreau {

    @Autowired
    private MoreauChapMapper moreauChapMapper;

    @Autowired
    private MoreauContentMapper moreauContentMapper;

    /**
     * 爬取面经："https://www.nowcoder.com/interview/center"
     * @throws Exception
     */
    @Test
    public void test() throws Exception{
        Document doc = Jsoup.connect("https://www.nowcoder.com/tutorial/100/c3aba3871ed24150920175629e2c4cf0").
                maxBodySize(0).get();

        Elements titles = doc.select("span[class='sub-menu-lesson']");
        for(Element title : titles) {
            MoreauChap moreauChap = new MoreauChap();
            moreauChap.setChapName(title.text());
            moreauChap.setMoreauId(8);
            moreauChapMapper.insertSelective(moreauChap);
        }
    }

    @Test
    public void test2() throws Exception {
        String url = "https://www.nowcoder.com/tutorial/100/c3aba3871ed24150920175629e2c4cf0";
        Document doc = Jsoup.connect(url).
                maxBodySize(0).get();
        String falg = "";
        Integer num = 0;
        while(!url.equals(falg)) {
            MoreauContent moreauContent = new MoreauContent();
            String title = doc.select("dd[class='sub-menu-underway']").select("a").select("span").text();
            String content = doc.select("article[class='post-topic-des entry-content nc-post-content js-nc-pop-image']").toString();
            moreauContent.setAli(num ++);
            moreauContent.setChapId(Integer.valueOf(title.split("\\.")[0]));
            moreauContent.setTitle(title);
            moreauContent.setContent(content);
            moreauContentMapper.insertSelective(moreauContent);
            falg = url;
            url = doc.select("div[class='sub-menu-btn']").select("a").attr("abs:href");
            doc = Jsoup.connect(url).maxBodySize(0).get();
        }
    }

    @Autowired
    private SquareTitleMapper squareTitleMapper;

    @Test
    public void test3() throws Exception {
        for (int i = 1; i <= 20; i++) {
            String url = "https://www.nowcoder.com/questionCenter?orderByHotValue=1&onlyReference=false&page=" + i;
            Document doc = Jsoup.connect(url).maxBodySize(0).get();
            Elements ul = doc.select("ul[class='common-list']");
            Elements lis = ul.select("li");
            for (Element li : lis) {
                SquareTitle squareTitle = new SquareTitle();
                String titleName = li.select("div[class='end-quot']").select("a").text();
                String labels = li.select("div[class='tags-box']").select("a").text();
                String a = li.select("div[class='end-quot']").select("a").attr("abs:href");
                doc = Jsoup.connect(a).maxBodySize(0).get();
                String titleContent = doc.select("ul[class='subject-des-list']").toString();
                Date date = new Date();

                squareTitle.setCreateTime(date);
                squareTitle.setTitleContent(titleContent);
                squareTitle.setTitleHard(new Random().nextInt(5) + 1);
                squareTitle.setTitleLabels(labels);
                squareTitle.setTitleName(titleName);
                squareTitle.setUserId("6aca7cbe-dff0-4342-a4f4-c7ad86699c4b");
                squareTitleMapper.insertSelective(squareTitle);
            }
        }
    }
}
