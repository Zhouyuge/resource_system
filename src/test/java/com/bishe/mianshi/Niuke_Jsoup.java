package com.bishe.mianshi;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

/**
 * @author Kirito
 * @Date 2019/10/11 19:36
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.mianshi.dao")
public class Niuke_Jsoup {

    @Test
    public void test() throws IOException {
        String url = "https://www.nowcoder.com/tutorial/94/4206176d637541fa92c784a4f547e979";

        Document doc = Jsoup.connect(url).maxBodySize(0).get();

        Elements divs = doc.select("div[class='study-sub-box']");
        Elements article = divs.select("article[class='post-topic-des entry-content nc-post-content js-nc-pop-image']");
        Elements questions = article.select("h2");  //问题
        Elements points = article.select("p");      //回答
        for(Element e : questions){
            System.out.println(e);
        }

        int index = 1;
        for(Element e : points){
            System.out.println("回答" + index++ +":" + e);
        }

    }

}
