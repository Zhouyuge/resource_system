package com.bishe.main.jsoup;

import cn.hutool.core.date.DateTime;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import com.bishe.main.dao.SelectTitleMapper;
import com.bishe.main.entity.SelectTitle;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.StringUtil;
import org.jsoup.nodes.Element;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.*;

/**
 * @author Kirito
 * @Date 2019/11/18 11:30
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class JsoupTitle {
    @Autowired
    private SelectTitleMapper selectTitleMapper;

    @Test
    public void testType() throws IOException {
        String url = "http://www.gxtiku.com/zxtk_9110_a801.html";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();

        Elements lis = doc.select("div[id='questions_col']").select("li");
        for (Element li : lis) {
            Elements ps = li.select("p[class='btns']").select("a");
            String rUrl = ps.attr("abs:href");                  //题目详情url

            doc = Jsoup.connect(rUrl).maxBodySize(0).get();                  //定向到详情url
            ps = doc.select("div[id='questions_con']").select("p");
            String se = "";
            for (int i = 0; i < ps.size(); i++) {
               if (i == 0) {
                   String ques = ps.get(i).text();
                   System.out.println("问题：" + ques + "\n");
               } else
                   se += ps.get(i).text() + "\n";
            }
            System.out.println(se);
            se = "";
            doc = Jsoup.connect(url).maxBodySize(0).get();  //回溯状态

            String aws = doc.select("ul[id='ExamA']").select("span").text();
            System.out.println("答案：" + aws);

        }
    }

    @Test
    public void test2 () throws IOException {
        String url = "https://www.iteye.com/blog/tntxia-1179918";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements ps = doc.select("p[class='MsoNormal']");
        int no = 1;
        String se = "";
        String an = "";
        List<String> ans = new ArrayList<>();
        List<String> ses = new ArrayList<>();
        for (Element p : ps) {
            String ques = p.select("strong").select("span").text();
            if (no <= 100) {
                if (!StringUtil.isEmpty(ques)) {
//                    SelectTitle selectTitle = new SelectTitle();
//                    selectTitle.setTitleAuthor("Kirito");
//                    selectTitle.setTitleCreateTime(DateTime.now().toSqlDate());
//                    selectTitle.setTitleName(ques);
//                    selectTitle.setTitleType(2);
//                    selectTitle.setTitleHard(new Random().nextInt(5) + 1);
                    ans.add(an);
                    ses.add(se);
                    se = "";
                    an = "";
                    System.out.println((no++) + "、" + ques);
                   // selectTitleMapper.insertSelective(selectTitle);
                } else {
                    se += p.select("span").text() + "\n";
                    an += p.select("span[style='color: red;']").text().split("\\.")[0] + " ";
                }
            }
        }
        for(int i = 1; i < ses.size(); i++) {
            SelectTitle selectTitle = selectTitleMapper.selectByPrimaryKey(i);
            selectTitle.setTitleContent(ses.get(i) == null ? "1" : ses.get(i));
            selectTitleMapper.updateByPrimaryKey(selectTitle);
        }

        for(int i = 1; i < ans.size(); i++) {
            SelectTitle selectTitle = selectTitleMapper.selectByPrimaryKey(i);
            selectTitle.setTitleAnswer(ans.get(i) == null ? "1" : ans.get(i));
            selectTitleMapper.updateByPrimaryKey(selectTitle);
        }


    }
    @Test
    public void test3() throws  IOException{
        Document doc = Jsoup.connect("https://www.oschina.net/").maxBodySize(0).get();
        Elements elements = doc.select("div[class='col-of-news']")
                .select("div[class='page']");

        for(Element e : elements) {
            System.out.println(e.select("a").text());
        }

    }
}
