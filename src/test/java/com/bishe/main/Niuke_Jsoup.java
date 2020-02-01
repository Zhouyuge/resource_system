package com.bishe.main;

import com.bishe.main.dao.BlogCenterMapper;
import com.bishe.main.dao.EtileCategoryMapper;
import com.bishe.main.dao.EtileMapper;
import com.bishe.main.entity.*;
import org.apache.commons.lang3.StringUtils;
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

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author Kirito
 * @Date 2019/10/11 19:36
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class Niuke_Jsoup {

    @Autowired
    private EtileCategoryMapper etileCategoryMapper;
    @Autowired
    private EtileMapper etileMapper;
    @Autowired
    private BlogCenterMapper blogCenterMapper;

    /**
     * 爬取java面经
     *
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        String url = "https://www.nowcoder.com/tutorial/10009/93ea8bfac75844888a914d1b8741b791";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
        Elements tMenu = doc.select("dt[class='clearfix js-fold-section']")
                .select("span[class='sub-menu-lesson']");           //菜单
        for(Element i : tMenu) {
            boolean t = new File("D://面试题//javascript//" + tMenu.first().text() + "//" + i.text()).mkdirs();  //创建存储目录
            if(t == false){
                System.out.println("=========================》失败");
            }
        }
        while (StringUtils.isNotEmpty(url)) {
            Elements title = doc.select("dd[class='sub-menu-underway']").select("a");   //标题
            System.out.println(title.text());
            Elements divs = doc.select("div[class='study-sub-box']");
            Elements articles = divs.select("article[class='post-topic-des entry-content nc-post-content js-nc-pop-image']");
            for (Element a : articles) {
                //System.out.println(a.toString());      //爬取文章,文章内容
                saveDataToFile(title.text(), a.toString());
            }
            url = doc.select("a[class='link-gray float-right']").attr("abs:href");    //下一节url
            doc = Jsoup.connect(url).maxBodySize(0).get();
        }
    }

    /**
     * 保存面经
     *
     * @param fileName 文件名称
     * @param data     数据
     */
    public void saveDataToFile(String fileName, String data) {
        OutputStream os = null;
        String destDirName = "D:\\面试题\\javascript\\" + fileName + ".txt";
        File dir = new File(destDirName);   //建立连接
        try {
            //2.选择输出流，以追加形式（在原有内容上追加）写出文件，必须为true，否则为覆盖
            os = new BufferedOutputStream(new FileOutputStream(dir, true));
            byte[] datas = data.getBytes();

            os.write(datas, 0, datas.length);   //3.写入文件
            os.flush();                              //将存储在管道中的数据强制刷新出去
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("文件没有找到");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 爬取精华专题分类
     */
    @Test
    public void testEtile() throws IOException {
        String url = "https://www.nowcoder.com/activity/topics";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();   //建立连接

        Elements elements = doc.select("ul[class='topic-list clearfix']");  //获取题目列表
        Elements lis = elements.select("li");
        int i = 0;
        for (Element li : lis) {
            i ++;
            EtileCategory ec = new EtileCategory();
            String etileCategoryName = li.select("div[class='topic-info']").select("h3").text();
            Integer num = 100;
//            String imgUrl = li.select("img").attr("src");
            String picUrl = "http://localhost:10086/img/img/" + i + ".png";
            System.out.println(picUrl);
            ec.setEtileCategoryNum(num);
            ec.setEtileCategoryName(etileCategoryName);
            ec.setEtileCategoryEditTime(new Date());
            ec.setEtileCategoryCreateTime(new Date());
            ec.setEtileCategoryPhoto(picUrl);
            etileCategoryMapper.insert(ec);
        }
    }

    /**
     * 将图片写入到特定地址
     *
     * @param filePath
     * @param imgUrl
     */
    public static String downImages(String filePath, String imgUrl) {
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        // 截取图片文件名
        String fileName = imgUrl.substring(imgUrl.lastIndexOf('/') + 1, imgUrl.length()) + ".png";

        try {
            //文件名里面可能有中文或者空格，所以这里需要处理。但空格又会被URLEncoder转义为加号
            String urlTail = URLEncoder.encode(fileName, "UTF-8");
            //因此要将加号转化为UTF-8的格式%20
            imgUrl = imgUrl.substring(0, imgUrl.lastIndexOf('/') + 1) + urlTail.replaceAll("\\+", "\\%20");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //写出的路径
        File file = new File(filePath + File.separator + fileName);

        try {
            //获取图片URL
            URL url = new URL(imgUrl);
            //获得连接
            URLConnection connection = url.openConnection();
            //设置10秒的响应时间
            connection.setConnectTimeout(10 * 1000);
            //获得输入流
            InputStream in = connection.getInputStream();
            //获得输出流
            BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));
            //构建和缓冲区
            byte[] buf = new byte[1024];
            int size;
            //写入到文件
            while (-1 != (size = in.read(buf))) {
                out.write(buf, 0, size);
            }
            out.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * 爬取精华专题题目
     */
    @Test
    public void testEtiles() throws Exception {
        Map<String, List<String>> map = getAAndQ();
        String url = "https://www.nowcoder.com/ta/nine-chapter";
        Document doc = null;
        int num = 0;
        while (num < 69) {
            doc = Jsoup.connect(url).maxBodySize(0).get();
            Elements trs = doc.select("tr");
            int i = 0;
            for (Element tr : trs) {
                if (num < 69 && i != 0) {
                    EtileWithBLOBs ewb = new EtileWithBLOBs();
                    ewb.setEtileNo(12);
                    ewb.setEtileNoAli(num);
                    String point = tr.select("td[class='offer-pot txt-left']").toString();
                    String title = tr.select("td[class='txt-left']").select("a").text();

                    ewb.setEtileName(title);
                    ewb.setEtilePoint(point);
                    ewb.setEtileType("问答题");
                    ewb.setEtitleAnswer(map.get("ans").get(num));
                    ewb.setEtitleQuestion(map.get("que").get(num));

                    etileMapper.insertSelective(ewb);
                    num++;
                }
                i++;
            }
            url = doc.select("li[class='txt-pager js-next-pager']").select("a").attr("abs:href");
            System.out.println("------->" + url);
        }
    }

    /**
     * 爬取问题和回答
     *
     * @return
     * @throws Exception
     */
    public Map<String, List<String>> getAAndQ() throws Exception {
        Map<String, List<String>> qAndA = new HashMap<>();
        List<String> answer = new ArrayList<>();
        List<String> question = new ArrayList<>();
        String url = "https://www.nowcoder.com/ta/nine-chapter/review?tpId=1&tqId=10782&query=&asc=true&order=&page=1";
        Document doc = null;
        int num = 0;
        while (num < 69) {
            doc = Jsoup.connect(url).maxBodySize(0).get();
            String que = doc.select("div[class='final-question']").toString();
            question.add(que);
            String anw = doc.select("div[class='design-answer-box']").toString();
            //System.out.println(anw);
            answer.add(anw);
            url = doc.select("div[class='pre-next-box']").select("a[class='next-question']").attr("abs:href");
            num++;
        }
        qAndA.put("ans", answer);
        qAndA.put("que", question);
        return qAndA;
    }

    /**
     * 爬取专栏
     *
     * @throws IOException
     */
    @Test
    public void blogCenter() throws IOException {
        List<String> urls = new ArrayList<>();
        String url = "https://www.nowcoder.com/blog/blogCenter?type=blog";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();

        Elements ul = doc.select("ul[class='column-best-list']");
        Elements lis = ul.select("li");
        for (Element li : lis) {
            urls.add(li.select("div[class='bd']").select("h4").select("a").attr("abs:href"));
            BlogCenter blogCenter = new BlogCenter();
            String img = li.select("div[class='hd']").select("a[class='pic']").select("img").attr("src");
            String hImg = "http://localhost:10086/img/h_img/" + downImages("D://niuke//h_img", img);
            String name = li.select("div[class='hd']").select("a").next("a").text();
            String title = li.select("div[class='bd']").select("h4").select("a").text();
            String vlog = li.select("div[class='bd']").select("p").text();
            String agree = li.select("div[class='ft']").select("div[class='oprt']").select("span").first().text();
            String collect = li.select("div[class='ft']").select("div[class='oprt']").select("span").next().text();

            blogCenter.setBlogCenterName(title);
            blogCenter.setBlogCenterPic(hImg);
            blogCenter.setBlogCenterAgree(Integer.parseInt(agree));
            blogCenter.setBlogCenterCollect(Integer.parseInt(collect));
            blogCenter.setBlogCenterAuthor(name);
            blogCenter.setBlogCenterVlog(vlog);
            blogCenter.setBlogCenterEditTime(new Date());
            blogCenterMapper.insert(blogCenter);

        }
        int id = 11;
        for (String s : urls) {
            doc = Jsoup.connect(s).maxBodySize(0).get();
            String con = doc.select("div[class='post-content']").html();
            BlogCenter blogCenter = blogCenterMapper.selectByPrimaryKey(id);
            id++;
            blogCenter.setBlogCenterContent(con);
            blogCenterMapper.updateByPrimaryKey(blogCenter);
        }
    }
}
