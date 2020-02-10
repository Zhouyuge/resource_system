package com.bishe.main.jsoup;

import com.bishe.main.dao.FactoryMapper;
import com.bishe.main.dao.PostMapper;
import com.bishe.main.entity.Factory;
import com.bishe.main.entity.Post;
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
 * @Date 2020/2/10 11:17
 * 爬取岗位信息
 */
@SpringBootTest
@MapperScan("com.bishe.main.dao")
@RunWith(SpringRunner.class)
public class JsoupPost {

    @Autowired
    private FactoryMapper factoryMapper;

    @Autowired
    private PostMapper postMapper;

    @Test
    public void test() throws Exception{
        Document doc = Jsoup.connect("https://www.nowcoder.com/job/center?type=0").maxBodySize(0).get();
        Elements lis = doc.select("ul[class='reco-job-list']").select("li");
        for(Element li : lis) {
            String url = li.select("a").attr("abs:href");
            doc = Jsoup.connect(url).maxBodySize(0).get();
            Elements factoryDiv = doc.select("div[class='module-body']");
            String factoryName = factoryDiv.select("a").select("h3").text();
            Factory factory = factoryMapper.selectByName(factoryName);
            if(factory == null) {
                factory = new Factory();
                String imgUrl = factoryDiv.select("a").select("img[class='js-company-logo']").attr("abs:src");
                String factoryInfo = factoryDiv.select("div[class='rec-info']").select("p[class='com-type']").text();
                String factoryListed = factoryDiv.select("div[class='rec-info']").select("p[class='com-price']").text();
                String factoryPlace = factoryDiv.select("div[class='rec-info']").select("p[class='com-place']").text();
                String factoryImg = "http://localhost:10086/img/fac_img/" + PicUtil.downImages("D://niuke//fac_img", imgUrl);
                System.out.println(factoryName + ":" + imgUrl);
                factory.setFactoryName(factoryName);
                factory.setAddTime(new Date());
                factory.setBeListed(factoryListed);
                factory.setFactoryPlace(factoryPlace);
                factory.setFactoryInfo(factoryInfo);
                factory.setFactoryImg(factoryImg);
                factoryMapper.insertSelective(factory);
            }

            Elements postDiv = doc.select("div[class='module-body module-info']");
            String postName = postDiv.select("div[class='rec-job-hd']").select("div[class='rec-job-title clearfix']").select("h2").select("a").text();
            String postPlace = postDiv.select("div[class='rec-job-detail']").select("span[class='rec-job-item js-nc-title-tips']").get(1).text();
            String postWelface = postDiv.select("div[class='rec-job-detail']").select("p").text();
            String postInfo = postDiv.select("div[class='nc-post-content js-duty-content']").get(0).text().replaceAll(";", ";\n");
            String postRequirement = postDiv.select("div[class='nc-post-content js-duty-content']").get(1).text().replaceAll(";", ";\n");
            Post post = new Post();
            post.setFactoryId(factory.getId());
            post.setPostCity(postPlace);
            post.setPostType(8);
            post.setPostName(postName);
            post.setPostInfo(postInfo);
            post.setPostWelfare(postWelface);
            post.setPostRequirement(postRequirement);
            post.setPublishTime(new Date());
            postMapper.insertSelective(post);
        }
    }

}
