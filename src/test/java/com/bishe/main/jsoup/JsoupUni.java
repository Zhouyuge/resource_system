package com.bishe.main.jsoup;

import com.bishe.main.dao.PaperMapper;
import com.bishe.main.dao.PaperTitleMapper;
import com.bishe.main.dao.UniversityMapper;
import com.bishe.main.entity.Paper;
import com.bishe.main.entity.PaperTitle;
import com.bishe.main.entity.University;
import com.bishe.main.enums.TitleEnum;
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

import java.util.List;
import java.util.Random;

/**
 * @author Kirito
 * @Date 2020/2/13 18:01
 * 爬取考研真题板块
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class JsoupUni {

    @Autowired
    private UniversityMapper universityMapper;

    @Autowired
    private PaperMapper paperMapper;

    @Autowired
    private PaperTitleMapper paperTitleMapper;

    @Test
    public void test() throws Exception{
        String url = "https://www.nowcoder.com/kaoyan/detail/19002";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        String name = doc.select("div[class='uni-info']").select("p").text();
        String href = doc.select("div[class='uni-info']").select("a").attr("abs:href");
        String img = doc.select("div[class='school-badge-box']").select("img").attr("src");
        String uniImg = "http://localhost:10086/img/uni_img/" + PicUtil.downImages("D://niuke//uni_img", img);
        University university = new University();
        university.setCityId(16);
        university.setTitleNum(0);
        university.setUniverName(name);
        university.setUniverUrl(href);
        university.setUniverImg(uniImg);
        universityMapper.insert(university);
    }

    /**
     * 爬取试卷
     */
    @Test
    public void test2() throws Exception{
        Document doc = Jsoup.connect("https://www.nowcoder.com/kaoyan/detail/19002").maxBodySize(0).get();
        Elements table = doc.select("table[class='no-border-table']").select("tbody");
        Elements trs = table.select("tr");
        int id = 3300;
        for (Element tr : trs) {
            id ++;
            Paper paper = new Paper();
            String url = tr.select("a").get(0).attr("abs:href");
            String year = tr.select("a").get(0).text();
            String title = tr.select("a").get(2).text();
            String hotNum = tr.select("a").get(3).text();
            paper.setPaperCode(title);
            paper.setPaperYear(year);
            paper.setPaperHot(hotNum);
            paper.setUniId(37);
            paper.setId(id);
            paper.setTitleNum(0);
            paperMapper.insertSelective(paper);

            doc = Jsoup.connect(url).maxBodySize(0).get();
            Elements trs2 = doc.select("table[class='no-border-table']").select("tbody").select("tr");
            for (Element tr1 : trs2) {
                PaperTitle paperTitle = new PaperTitle();
                String url2 = tr1.select("td").select("a").attr("abs:href");
                String paperType = tr1.select("td").get(1).text();
                doc = Jsoup.connect(url2).maxBodySize(0).get();
                Elements body = doc.select("div[class='subject-des']");
                String name = body.select("div[class='nc-post-content']").select("p").toString();
                String titleBody = body.select("ul[class='subject-des-list']").select("li").toString();
                paperTitle.setPaperId(id);
                paperTitle.setPaperTitleAnserNum(0);
                paperTitle.setPaperTitleHard(new Random().nextInt(6));
                paperTitle.setPaperTitleBody(titleBody);
                System.out.println(name);
                paperTitle.setPaperTitleName(name);
                paperTitle.setPaperTitleType(TitleEnum.getKey(paperType));
                paperTitleMapper.insert(paperTitle);
            }
        }
    }

    @Test
    public void test3() {
        List<PaperTitle> paperTitlesList = paperTitleMapper.getPaperIds();
        List<Paper> papers = paperMapper.getPapers();
        for(int i = 0; i < paperTitlesList.size() - 1; i++) {
            int length = paperTitlesList.get(i + 1).getId() - paperTitlesList.get(i).getId();
            for(int id = paperTitlesList.get(i).getId(); id < (length + paperTitlesList.get(i).getId()); id++) {
                PaperTitle paperTitle = paperTitleMapper.selectByPrimaryKey(id);
                paperTitle.setPaperId(papers.get(i).getId());
                System.err.println(papers.get(i).getId());
                paperTitleMapper.updateByPrimaryKeySelective(paperTitle);
            }
        }
    }
}
