package com.bishe.main;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

/**
 * @author Kirito
 * @Date 2019/10/11 19:36
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class Niuke_Jsoup {

    private static int num = 1;

    /**
     * 爬取java面经
     * @throws IOException
     */
    @Test
    public void test() throws IOException {
        String url = "https://www.nowcoder.com/tutorial/94/4206176d637541fa92c784a4f547e979";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();
//        Elements tMenu = doc.select("dt[class='clearfix js-fold-section']")
//                .select("span[class='sub-menu-lesson']");           //菜单
//        for(Element i : tMenu) {
//            boolean t = new File("D://面试题//" + tMenu.first().text() + "//" + i.text()).mkdirs();  //创建存储目录
//            if(t == false){
//                System.out.println("=========================》失败");
//            }
//        }
        while(StringUtils.isNotEmpty(url)){
            Elements title = doc.select("dd[class='sub-menu-underway']").select("a");   //标题
            System.out.println(title.text());
            Elements divs = doc.select("div[class='study-sub-box']");
            Elements articles = divs.select("article[class='post-topic-des entry-content nc-post-content js-nc-pop-image']");
            for(Element a : articles){
                //System.out.println(a.toString());      //爬取文章,文章内容
                saveDataToFile(title.text(), a.toString());
            }
            url = doc.select("a[class='link-gray float-right']").attr("abs:href");    //下一节url
            doc = Jsoup.connect(url).maxBodySize(0).get();
        }
    }

    /**
     * 保存面经
     * @param fileName      文件名称
     * @param data           数据
     */
    public void saveDataToFile(String fileName, String data){
        OutputStream os = null;
        String destDirName = "D:\\面试题\\" + (num++) +"." + fileName + ".txt";
        File dir = new File(destDirName);   //建立连接
        try{
            //2.选择输出流，以追加形式（在原有内容上追加）写出文件，必须为true，否则为覆盖
            os =new BufferedOutputStream(new FileOutputStream(dir, true));
            byte[] datas = data.getBytes();

            os.write(datas, 0, datas.length);   //3.写入文件
            os.flush();                              //将存储在管道中的数据强制刷新出去
        }catch (FileNotFoundException e){
            e.printStackTrace();
            System.out.println("文件没有找到");
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(os != null){
                try{
                    os.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 爬取精华专题
      */
    @Test
    public void testEtile() throws IOException{
        String url = "https://www.nowcoder.com/activity/topics";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();   //建立连接

        Elements elements = doc.select("ul[class='topic-list clearfix']");  //获取题目列表
        Elements lis = elements.select("li");
        for (Element li : lis) {
            System.out.println(li.select("div[class='topic-info']").select("h3").text());
        }

    }
}
