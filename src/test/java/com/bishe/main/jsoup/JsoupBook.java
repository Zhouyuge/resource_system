package com.bishe.main.jsoup;

import com.bishe.main.dao.BookMapper;
import com.bishe.main.entity.Book;
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

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * @author Kirito
 * @Date 2020/1/22 20:55
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.bishe.main.dao")
public class JsoupBook {

    @Autowired
    private BookMapper bookMapper;
    /**
     * 爬取牛客网书籍信息 ---  https://www.nowcoder.com/library
     */
    @Test
    public void getBook() throws IOException {
        String url = "https://www.nowcoder.com/library";
        Document doc = Jsoup.connect(url).maxBodySize(0).get();

        Elements ul = doc.select("ul[class='recommend-book-list']");
        Elements li = ul.select("li");
        for(Element e : li) {
            Book book = new Book();
            String rUrl = e.select("a").attr("abs:href");
            doc = Jsoup.connect(rUrl).maxBodySize(0).get();
            String bookName = doc.select("div[class='library-book-mod clearfix']").select("div[class='library-book-info']").select("h2").text();
            book.setBookName(bookName);
            String author = doc.select("div[class='library-book-mod clearfix']")
                    .select("div[class='library-book-info']").select("ul")
                    .select("li").get(0).text().split("：")[1];
            book.setBookAuthor(author);
            String price = doc.select("div[class='library-book-mod clearfix']")
                    .select("div[class='library-book-info']").select("ul")
                    .select("li").get(1).text().split("：")[1];
            if( doc.select("div[class='library-book-mod clearfix']")
                    .select("div[class='library-book-info']").select("ul")
                    .select("li").get(1).text().contains("译者")) {
                 price = doc.select("div[class='library-book-mod clearfix']")
                        .select("div[class='library-book-info']").select("ul")
                        .select("li").get(2).text().split("：")[1];
                 String bookCode = doc.select("div[class='library-book-mod clearfix']")
                         .select("div[class='library-book-info']").select("ul")
                         .select("li").get(3).text().split("：")[1];
                 book.setBookCode(bookCode);
                 String bookPress = doc.select("div[class='library-book-mod clearfix']")
                         .select("div[class='library-book-info']").select("ul")
                         .select("li").get(4).text().split("：")[1];
                 book.setBookPress(bookPress);
                 Date date = new Date();
                 book.setBookTime(date);
            } else {
                String bookCode = doc.select("div[class='library-book-mod clearfix']")
                        .select("div[class='library-book-info']").select("ul")
                        .select("li").get(2).text().split("：")[1];
                book.setBookCode(bookCode);
                String bookPress = doc.select("div[class='library-book-mod clearfix']")
                        .select("div[class='library-book-info']").select("ul")
                        .select("li").get(3).text().split("：")[1];
                book.setBookPress(bookPress);
                Date date = new Date();
                book.setBookTime(date);
            }
            book.setBookPrice(price);

            String img = doc.select("div[class='library-book-pic']").select("img").attr("src");
            String imgUrl = "http://localhost:10086/img/bookImg/" + PicUtil.downImages("D://niuke//bookImg//", img);
            book.setBookPic(imgUrl);
            book.setCreateTime(new Date());
            book.setBookRecomendNum(new Random().nextInt(100));
            bookMapper.insertSelective(book);
        }

    }
}
