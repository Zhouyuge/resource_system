package com.bishe.main;

import com.bishe.main.dao.ProblemMapper;
import com.bishe.main.entity.Problem;
import com.bishe.main.entity.ProblemWithBLOBs;
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

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * @author Kirito
 * @Date 2020/4/14 11:13
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class JsoupLeetCode {
    @Autowired
    private ProblemMapper problemMapper;

    @Test
    public void test() throws Exception{
        for(int page = 7; page <=8; page++) {
            Document doc = Jsoup.connect("https://www.nowcoder.com/ta/2019test?query=&asc=true&order=&tagQuery=&page=" + page).maxBodySize(0).get();
            Elements trs = doc.select("tbody").select("tr");
            int i = 0;
            for (Element tr : trs) {
                if (i != 0) {
                    ProblemWithBLOBs problem = new ProblemWithBLOBs();
                    String label = tr.select("td[class='offer-pot txt-left']").text();
                    String name = tr.select("td[class='txt-left']").select("a").text();
                    String url = tr.select("td[class='txt-left']").select("a").attr("abs:href");
                    String hard = tr.select("td").get(2).text();
                    doc = Jsoup.connect(url).maxBodySize(0).get();
                    String content = doc.select("div[class='subject-describe']").toString();
                    String timeLimit = doc.select("div[class='subject-item-wrap']").select("span").get(0).text();
                    String spaceLimit = doc.select("div[class='subject-item-wrap']").select("span").get(1).text();

                    System.out.println(timeLimit.split("其他语言")[1].split("秒")[0] + ":" + spaceLimit.split("其他语言")[1].split("M")[0]);
                    problem.setProblemLabel(label);
                    UUID uuid = UUID.randomUUID();
                    problem.setInputFileRootPath("D:\\JavaOJSystem\\problem\\" + uuid + "\\in");
                    problem.setOutputFileRootPath("D:\\JavaOJSystem\\problem\\" + uuid + "\\out");
                    problem.setProblemDifficulty(Integer.valueOf(hard));
                    problem.setIsPublish(true);
                    problem.setProblemTypeId(1);
                    problem.setProblemName(name);
                    problem.setProblemContent(content);
                    problem.setTimeLimit(Integer.valueOf(timeLimit.split("其他语言")[1].split("秒")[0]) * 1000);
                    problem.setMemoryLimit(Integer.valueOf(spaceLimit.split("其他语言")[1].split("M")[0]) * 1000);
                    problem.setProblemCreatorId(1);
                    problem.setProblemValue(Integer.valueOf(hard));
                    Long timeMillis = System.currentTimeMillis();
                    test2(problem.getInputFileRootPath(), doc.select("div[class='subject-describe']").select("div[class='question-oi-cont']").get(0).text(), timeMillis);
                    test2(problem.getOutputFileRootPath(), doc.select("div[class='subject-describe']").select("div[class='question-oi-cont']").get(1).text(), timeMillis);
                    problemMapper.insertSelective(problem);
                }
                i++;
            }
        }
    }

    public void test2(String path, String content, Long timeMillis) throws Exception{
        File file = new File(path);
        if(!file.exists()){
            file.mkdirs();
        }
        file = new File(path + File.separator + timeMillis + ".txt");
        OutputStream os = new FileOutputStream(file);
        os.write(content.getBytes(), 0, content.getBytes().length - 1);
    }
}
